package com.example.ron_wang.rchelper;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class DoubleActivity extends AppCompatActivity {

    final Context context = this;
    private List<String> listAs = new ArrayList<String>(), listType = new ArrayList<String>(), listCon = new ArrayList<String>(), listRein = new ArrayList<String>(), listRein_ = new ArrayList<String>();
    private Spinner spinnerAs, spinnerType, spinnerCon, spinnerRein, spinnerRein_;
    private ArrayAdapter<String> adapterAs, adapterType, adapterCon, adapterRein, adapterRein_;
    private Button btnCal;
    private EditText edittxtH, edittxtB, edittxtA, edittxtA_, edittxtAs_, edittxtK, edittxtM;
    float h, b, k, a, a_, m, as_, h0, m_,alphas,alphas1, xi,xib_,xi1,x, As, fc, fy, fy_, ft, rho, rhomin;
    float con[] = {7.2f, 9.6f, 11.9f, 14.3f, 16.7f, 19.1f, 21.1f, 23.1f, 25.3f, 27.5f};
    float conft[] = {0.91f, 1.10f, 1.27f, 1.43f, 1.5f, 1.71f, 1.80f, 1.89f, 1.96f, 2.04f};
    float rein[] = {210, 300, 360, 360};
    int as_no, type_no, rein_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double);

        btnCal = (Button) findViewById(R.id.Btncal1);
        edittxtH = (EditText) findViewById(R.id.EditH);
        edittxtB = (EditText) findViewById(R.id.EditB);
        edittxtA = (EditText) findViewById(R.id.EditA);
        edittxtA_ = (EditText) findViewById(R.id.EditA_);
        edittxtAs_ = (EditText) findViewById(R.id.EditAs_);
        edittxtK = (EditText) findViewById(R.id.EditK);
        edittxtM = (EditText) findViewById(R.id.EditM);
        spinnerAs = (Spinner) findViewById(R.id.SpinAs);
        spinnerType = (Spinner) findViewById(R.id.SpinType);
        spinnerCon = (Spinner) findViewById(R.id.SpinCon);
        spinnerRein = (Spinner) findViewById(R.id.SpinRein);
        spinnerRein_ = (Spinner) findViewById(R.id.SpinRein_);

        listAs.add("求As和As'");
        listAs.add("已知As'，求As");
        listType.add("梁");
        listType.add("板");
        listCon.add("C15");
        listCon.add("C20");
        listCon.add("C25");
        listCon.add("C30");
        listCon.add("C35");
        listCon.add("C40");
        listCon.add("C45");
        listCon.add("C50");
        listCon.add("C55");
        listCon.add("C60");
        listRein.add("HPB235");
        listRein.add("HRB335");
        listRein.add("HRB400");
        listRein.add("RRB400");
        listRein_.add("HPB235");
        listRein_.add("HRB335");
        listRein_.add("HRB400");
        listRein_.add("RRB400");

        adapterAs = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listAs);
        adapterAs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAs.setAdapter(adapterAs);
        spinnerAs.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                as_no = arg2;
                arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }
        });
        spinnerAs.setOnTouchListener(new Spinner.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return false;
            }
        });
        spinnerAs.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
            }
        });

        adapterType = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listType);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapterType);
        spinnerType.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                type_no = arg2;
                arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }
        });
        spinnerType.setOnTouchListener(new Spinner.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return false;
            }
        });
        spinnerType.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
            }
        });

        adapterCon = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listCon);
        adapterCon.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCon.setAdapter(adapterCon);
        spinnerCon.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                fc = con[arg2];
                ft = conft[arg2];
                arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }
        });
        spinnerCon.setOnTouchListener(new Spinner.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return false;
            }
        });
        spinnerCon.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
            }
        });

        adapterRein = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listRein);
        adapterRein.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRein.setAdapter(adapterRein);
        spinnerRein.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                fy = rein[arg2];
                rein_no = arg2;
                arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }
        });
        spinnerRein.setOnTouchListener(new Spinner.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return false;
            }
        });
        spinnerRein.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
            }
        });

        adapterRein_ = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listRein_);
        adapterRein_.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRein_.setAdapter(adapterRein_);
        spinnerRein_.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                fy_ = rein[arg2];
                arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }
        });
        spinnerRein_.setOnTouchListener(new Spinner.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return false;
            }
        });
        spinnerRein_.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
            }
        });

        btnCal.setOnClickListener(btnCalOnClick);
    }

    private View.OnClickListener btnCalOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            h = Float.valueOf(edittxtH.getText().toString());
            b = Float.valueOf(edittxtB.getText().toString());
            k = Float.valueOf(edittxtK.getText().toString());
            a = Float.valueOf(edittxtA.getText().toString());
            a_ = Float.valueOf(edittxtA_.getText().toString());
            m = Float.valueOf(edittxtM.getText().toString());

            h0 = h - a;
            if(type_no == 0){
                if(rein_no == 0)
                    rhomin = 0.0025f;
                else
                    rhomin = 0.0020f;
            }
            else {
                if (rein_no == 0)
                    rhomin = 0.0020f;
                else
                    rhomin = 0.0015f;
            }

            if(as_no == 0){
				alphas = Math.round(k * m /(fc * b * h0 * h0) * 1000000 * 1000) / 1000.0f;
                xi = Math.round((1 - Math.sqrt(1 - 2 * alphas)) * 1000) / 1000.0f;
                As = Math.round(fc * b * xi * h0 / fy);
                rho = Math.round(As / (b * h0) * 10000) / 10000.0f;
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder
                        .setTitle("双筋矩形截面设计：求As和As'")
                        .setIcon(R.drawable.icon2)
                        .setCancelable(true)
                        .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

                String s;
                s = "已知：\n"
                        + "fc = " + fc + "N/mm²\n"
                        + "ft = " + ft + "N/mm²\n"
                        + "fy = " + fy + "N/mm²\n"
                        + "fy' = " + fy_ + "N/mm²\n"
                        + "h0 = h - a = " + h0 + "mm\n"
                        + "计算过程：\n"
                        + "αs = KM/(fc*b*h0*h0)\n"
                        + "   = " + k + "*" + m + "*10^6/(" + fc + "*" + b + "*" + h0 + "*" + h0 + ")\n"
                        + "   = " + alphas + "\n";

                if(alphas > 0.386){
                    as_ = Math.round((k * m * 1000000 - 0.386 * fc * b * h0 * h0) / (fy_ * (h0 - a_)));
                    xib_ = 0.522f;
                    s += " > αsb = 0.386\n"
                            + "即ξ>0.85ξb,超筋\n"
                            + "需要按照双筋矩形截面设计\n"
                            + "受压钢筋面积为：\n"
                            + "As' = (KM-αsb*fc*b*h0*h0)/(fy'*(h0-a'))\n"
                            + "    = (" + k + "*" + m + "*10^6-" + "0.386*" + fc + "*" + b + "*" + h0 + "*" + h0 + ")/("
                            + fy_ + "*(" + h0 + "-" + a_ + ")" + "\n"
                            + "    = " + as_ + "mm^2\n"
                            + "受拉钢筋面积为：\n"
                            + "As = (fc*b*0.85*ξb*h0+fy'*As')/fy\n"
                            + "   = (" + fc + "*" + b + "*" + xib_ + "*" + h0 + "+" + fy + "*" + as_ + ")/" + fy + "\n"
                            + "   = " + Math.round((fc * b * xib_ * h0 + fy_ * as_) / fy) + "mm^2\n";
                } else {
                    s += "ξ = 1-sqrt(1-2αs)\n"
                            + "   = 1-sqrt(1-2*" + alphas + ")\n"
                            + "   = " + xi + "<0.85ξb = 0.522\n"
                            + "未超筋，按照单筋矩形截面设计即可\n"
                            + "配筋面积为：\n"
                            + "As = fc*b*ξ*h0/fy\n"
                            + "   = " + fc + "*" + b + "*" + xi + "*" + h0 + "/" + fy + "\n"
                            + "   = " + As + "mm²\n"
                            + "配筋率为：\n"
                            + "ρ = As/(b*h0)\n"
                            + "   = " + As + "/(" + b + "*" + h0 + ")\n"
                            + "   = " + rho + "\n";
                    if(rho < rhomin){
                        s += "   <ρmin = " + rhomin + ",少筋\n"
                                + "按照最小配筋率配筋，受拉钢筋面积为：\n"
                                + "As = ρmin*b*h0\n"
                                + "   = " + rhomin + "*" + b + "*" + h0 + "\n"
                                + "   = " + Math.round(rhomin*b*h0) + "mm²\n"
                                + "受压钢筋应该按照构造要求配置"
                                + "能够抵抗的最大弯矩(即KM)为：\n"
                                + "Mu = 7/24*ft*b*h*h\n"
                                + "   = 7/24*" + ft + "*" + b + "*" + h + "*" + h + "/10^6\n"
                                + "   = " + Math.round(7.0/24.0*ft*b*h*h/1000000.0) + "kN·m\n";
                    }
                    else{
                        s += "   >=ρmin = " + rhomin + ",适筋\n"
                                + "受压钢筋应该按照构造要求配置";
                    }
                }
                alertDialogBuilder.setMessage(s);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
            else{
                as_ = Float.valueOf(edittxtAs_.getText().toString());
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder
                        .setTitle("双筋矩形截面设计：求As")
                        .setIcon(R.drawable.icon2)
                        .setCancelable(true)
                        .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });
                m_ = fy_ * as_ * (h0 - a_) / 1000000;
                alphas1 = Math.round((k * m - m_) / (fc * b * h0 * h0) * 1000000 * 1000) / 1000.0f;

                String s;
                s = "已知：\n"
                        + "fc = " + fc + "N/mm²\n"
                        + "ft = " + ft + "N/mm²\n"
                        + "fy = " + fy + "N/mm²\n"
                        + "fy' = " + fy_ + "N/mm²\n"
                        + "h0 = h - a = " + h0 + "mm\n"
                        + "As' = " + as_ + "mm^2\n"
                        + "计算过程：\n"
                        + "M' = fy'*As'*(h0-a')\n"
                        + "   =" + fy_ + "*" + as_ + "*(" + h0 + "-" + a_ + ")/10^6\n"
                        + "   =" + m_ + "kN*m\n"
                        + "αs = (KM-M')/(fc*b*h0*h0)\n"
                        + "    = (" + k + "*" + m + "-" + m_ +")*10^6/(" + fc + "*" + b + "*" + h0 + "*" + h0 + ")\n"
                        + "   = " + alphas1;

                if(alphas1 <= 0.386)
                {
                    xi1 = Math.round((1 - Math.sqrt(1 - 2 * alphas1)) * 1000) / 1000f;
                    x = Math.round(xi1 * h0 * 100)/100f;

                    if(alphas1 < 0){
                        s += " < 0\n"
                                + "按照最小配筋率配筋，受拉钢筋面积为：\n"
                                + "As = ρmin*b*h0\n"
                                + "   = " + rhomin + "*" + b + "*" + h0 + "\n"
                                + "   = " + Math.round(rhomin*b*h0) + "mm²\n";
                    }
                    else{
                        s += " <= αsb = 0.386\n"
                                + "ξ  = 1-sqrt(1-2αs)\n"
                                + "    = 1-sqrt(1-2*" + alphas1 + ")\n"
                                + "    = " + xi1 + "<0.85ξb = 0.522\n"
                                + "混凝土受压高度：\n"
                                + "x = ξh0 = " + x + "mm";
                        if(x >= 2 * a_)
                        {
                            s += " >= 2a' = " + 2 * a_ + "mm\n"
                                    + "受拉钢筋面积为：\n"
                                    + "As = (fc*b*ξ*h0+fy'*As')/fy\n"
                                    + "   = (" + fc + "*" + b + "*" + xi1 + "*" + h0 + "+" + fy + "*" + as_ + ")/" + fy + "\n"
                                    + "   = " + Math.round((fc * b * xi1 * h0 + fy_ * as_) / fy) + "mm^2\n";
                        }
                        else
                        {
                            s += " < 2a' = " + 2 * a_ + "mm\n"
                                    + "受拉钢筋面积为：\n"
                                    + "As = k*m/(fy*(h0-a'))\n"
                                    + "   = " + k + "*" + m + "*10^6/(" + fy + "*(" + h0 + "-" + a_ + "))\n"
                                    + "   = " + Math.round(k * m / (fy * (h0 - a_)) * 1000000) + "mm^2\n";
                        }
                    }
                }
                else
                {
                    as_ = Math.round((k * m * 1000000 - 0.386 * fc * b * h0 * h0) / (fy_ * (h0 - a_)));
                    xib_ = 0.522f;

                    s += " > αsb = 0.386\n"
                            + "即ξ>0.85ξb\n"
                            + "受压钢筋面积过小，需重新设计\n"
                            + "受压钢筋面积为：\n"
                            + "As' = (KM-αsb*fc*b*h0*h0)/(fy'*(h0-a'))\n"
                            + "    = (" + k + "*" + m + "*10^6-" + "0.386*" + fc + "*" + b + "*" + h0 + "*" + h0 + ")/("
                            + fy_ + "*(" + h0 + "-" + a_ + ")" + "\n"
                            + "    = " + as_ + "mm^2\n"
                            + "As = (fc*b*0.85*ξb*h0+fy'*As')/fy\n"
                            + "   = (" + fc + "*" + b + "*" + xib_ + "*" + h0 + "+" + fy + "*" + as_ + ")/" + fy + "\n"
                            + "   = " + Math.round((fc * b * xib_ * h0 + fy_ * as_) / fy) + "mm^2\n";
                }
                alertDialogBuilder.setMessage(s);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }

        }
    };
}
