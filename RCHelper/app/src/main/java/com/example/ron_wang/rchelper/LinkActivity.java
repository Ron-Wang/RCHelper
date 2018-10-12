package com.example.ron_wang.rchelper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class LinkActivity extends AppCompatActivity {

    private Button btnCal;
    private String mailAdress = "wangrongxin168@163.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        btnCal = (Button)findViewById(R.id.Btncal1);
        btnCal.setOnClickListener(btnCalOnClick);
    }

    private View.OnClickListener btnCalOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("mailto:"+mailAdress);
            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            //intent.putExtra(Intent.EXTRA_CC, email); // 抄送人
            intent.putExtra(Intent.EXTRA_SUBJECT, "关于RCHelper的问题"); // 主题
            intent.putExtra(Intent.EXTRA_TEXT, "To Ron-Wang:\n"); // 正文
            LinkActivity.this.startActivity(Intent.createChooser(intent, "请选择邮件类应用"));
        }
    };
}
