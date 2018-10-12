package com.example.ron_wang.rchelper;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anzhi.sdk.ad.main.AzSplashAd;
import com.anzhi.sdk.ad.manage.AnzhiAdCallBack;
//import com.azad.demo.AdIDs;
//import com.azad.demo.BannerActivity;
//import com.com2us.smon.normal.freefull.google.kr.android.common.R;

import java.util.ArrayList;
import java.util.List;


public class SplashActivity extends Activity {
    private AzSplashAd splshAd;
    TextView tx;
    ImageView holder;
    private boolean next;

    private boolean isFront = false;//这个值表示页面是否在前台（true 表示在，false 表示不在前台）

    private boolean isClosed = false;//该值表示广告是否关闭（isClosed 为 true 表示该广告关闭了，false 表示该广告没有关闭）


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity_ly);
        holder = (ImageView) findViewById(R.id.anzhi_splash_holder);
        tx = (TextView) findViewById(R.id.anzhi_skip_view);

        // 如果targetSDKVersion >= 23，就要申请好权限。如果您的App没有适配到Android6.0（即targetSDKVersion < 23）。
        if (Build.VERSION.SDK_INT >= 23) {
            checkAndRequestPermission();
        } else {
            // 如果是Android6.0以下的机器，默认在安装时获得了所有权限，可以直接调用SDK
            loadAdSplash();
        }
    }

    private void loadAdSplash() {
        splshAd = new AzSplashAd(this, AdIDs.APPKEY, AdIDs.SPLASH_ID, new AnzhiAdCallBack() {
            @Override
            public void onShow() {
                holder.setVisibility(View.INVISIBLE);
                Log.e("","--闪屏广告展示---");
            }

            @Override
            public void onReceiveAd() {
            }

            @Override
            public void onLoadFailed(String result) {
                Log.e("","--闪屏广告加载失败---原因----：" + result);
                toNextActivity();
            }

            /*
             *
             * 关闭广告
             */
            @Override
            public void onCloseAd() {
                toNextActivity();
                Log.e("","--闪屏广告关闭");
            }

            @Override
            public void onAdExposure() {

            }

            @Override
            public void onADTick(long millisUntilFinished) {
                tx.setText(String.format("点击跳过 %d", Math.round(millisUntilFinished / 1000f)));
            }

            @Override
            public void onAdClik() {
                Log.e("","---闪屏广告被点击---");
            }
        }, (FrameLayout) findViewById(R.id.anzhi_splash_container), tx);
        splshAd.setDelayTimes(5);
        splshAd.loadAd();
    }

    /**
     * 跳转到新的页面
     */
    private void toNextActivity() {
        isClosed = true;
        if (isFront) {
            if (next) {
                return;
            }
            next = true;
            finish();
            Intent intent = new Intent();
            intent.setClass(SplashActivity.this, MainActivity.class);
            SplashActivity.this.startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        isFront = true;
        if (isClosed) {
            toNextActivity();
        }
        if (splshAd != null) {
            splshAd.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        splshAd.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        isFront = false;
        super.onPause();
    }

    /**
     * ----------非常重要----------
     * <p>
     * Android6.0以上的权限适配简单示例：
     * <p>
     * 如果targetSDKVersion >= 23，那么必须要申请到所需要的权限，再调用广点通SDK，否则广点通SDK不会工作。
     * <p>
     * Demo代码里是一个基本的权限申请示例，请开发者根据自己的场景合理地编写这部分代码来实现权限申请。
     * 注意：下面的`checkSelfPermission`和`requestPermissions`方法都是在Android6.0的SDK中增加的API，如果您的App还没有适配到Android6.0以上，则不需要调用这些方法，直接调用广点通SDK即可。
     */
    @TargetApi(Build.VERSION_CODES.M)
    private void checkAndRequestPermission() {
        List<String> lackedPermission = new ArrayList<String>();
        if (!(checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED)) {
            lackedPermission.add(Manifest.permission.READ_PHONE_STATE);
        }

        if (!(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)) {
            lackedPermission.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (!(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {
            lackedPermission.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }

        // 权限都已经有了，那么直接调用SDK
        if (lackedPermission.size() == 0) {
            loadAdSplash();
        } else {
            // 请求所缺少的权限，在onRequestPermissionsResult中再看是否获得权限，如果获得权限就可以调用SDK，否则不要调用SDK。
            String[] requestPermissions = new String[lackedPermission.size()];
            lackedPermission.toArray(requestPermissions);
            requestPermissions(requestPermissions, 1024);
        }
    }

    private boolean hasAllPermissionsGranted(int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1024 && hasAllPermissionsGranted(grantResults)) {
            loadAdSplash();
        } else {
            // 如果用户没有授权，那么应该说明意图，引导用户去设置里面授权。
            Toast.makeText(this, "应用缺少必要的权限！请点击\"权限\"，打开所需要的权限。", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
            finish();
        }
    }

    /**
     * 防止用户返回键退出APP
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
