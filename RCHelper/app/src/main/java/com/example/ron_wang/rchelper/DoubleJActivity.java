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

public class DoubleJActivity extends AppCompatActivity {

    final Context context = this;
    private List<String> listType = new ArrayList<String>(), listCon = new ArrayList<String>(),
            listRein = new ArrayList<String>(), listRein_ = new ArrayList<String>();
    private Spinner spinnerType, spinnerCon, spinnerRein, spinnerRein_;
    private ArrayAdapter<String> adapterType, adapterCon, adapterRein, adapterRein_;
    private Button btnCal;
    private EditText edittxtH, edittxtB, edittxtA, edittxtA_,edittxtAs, edittxtAs_, edittxtK, edittxtM;
    float h, b, k, a, a_, m, as_, h0, m_,alphas,alphas1, xi,xib_,xi1,x, As,As_, fc, fy, fy_, ft,Mu, rho, rhomin;
    float con[] = {7.2f, 9.6f, 11.9f, 14.3f, 16.7f, 19.1f, 21.1f, 23.1f, 25.3f, 27.5f};
    float conft[] = {0.91f, 1.10f, 1.27f, 1.43f, 1.5f, 1.71f, 1.80f, 1.89f, 1.96f, 2.04f};
    float rein[] = {210, 300, 360, 360};
    int type_no, rein_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_j);

        btnCal = (Button) findViewById(R.id.Btncal1);
        edittxtH = (EditText) findViewById(R.id.EditH);
        edittxtB = (EditText) findViewById(R.id.EditB);
        edittxtA = (EditText) findViewById(R.id.EditA);
        edittxtA_ = (EditText) findViewById(R.id.EditA_);
        edittxtAs = (EditText) findViewById(R.id.EditAs);
        edittxtAs_ = (EditText) findViewById(R.id.EditAs_);
        edittxtK = (EditText) findViewById(R.id.EditK);
        edittxtM = (EditText) findViewById(R.id.EditM);
        spinnerType = (Spinner) findViewById(R.id.SpinType);
        spinnerCon = (Spinner) findViewById(R.id.SpinCon);
        spinnerRein = (Spinner) findViewById(R.id.SpinRein);
        spinnerRein_ = (Spinner) findViewById(R.id.SpinRein_);

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
            As = Float.valueOf(edittxtAs.getText().toString());
            As_ = Float.valueOf(edittxtAs_.getText().toString());


            h0 = h - a;
            xib_ = 0.522f;
            x = Math.round((fy * As - fy_ * As_) / (b * fc) * 100f)/100f;
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

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder
                    .setTitle("双筋矩形截面校核")
                    .setIcon(R.drawable.icon7)
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
                    + "计算受压区高度：\n"
                    + "x = (fy*As-fy'*As')/(b*fc)\n"
                    + " = (" + fy + "*" + As  + "-" + fy_  + "*" + As_ + ")/(" + b  + "*" + fc + ")\n"
                    + " = " + x + "mm\n";

            if (x < 2 * a_) {
                Mu = Math.round(fy * As * (h0 - a_) /1000000);
                s += " < 2a' = 2*" + a_ + " = " + 2 * a_ + "mm\n"
                        + "能够抵抗的最大弯矩为：\n"
                        + "Mu = fy*As*(h0-a')\n"
                        + "   = (" + fy + "*" + As + "*(" + h0 + "-" + a_ + "))/10^6\n"
                        + "   = " + Mu + "kN·m\n";
            }
            else if(x > xib_ * h0){
                Mu = Math.round((0.386 * fc * b * h0 * h0 + fy_ * As_ * (h0 - a_)) /1000000);
                s += " > α1*0.85*ξb*h0 = 0.522*" + h0 + " = " + xib_ * h0 + "mm\n"
                        + "能够抵抗的最大弯矩为：\n"
                        + "Mu = αsb*fc*b*h0^2+fy'*As'*(h0-a')\n"
                        + "   = (0.386*" + fc + "*" + b + "*" + h0 + "^2+" + fy_+ "*" + As_+ "*(" + h0+ "-" + a_ + "))/10^6\n"
                        + "   = " + Mu + "kN·m\n";
            }
            else{
                Mu = Math.round((fc*b*x*(h0-x/2)+fy_*As_*(h0-a_)) /1000000);
                s += "2a' = 2*" + a_ + " = " + 2 * a_ + "mm <= x <= α1*0.85*ξb*h0 = 0.522*" + h0 + " = " + xib_ * h0 + "mm\n"
                        + "能够抵抗的最大弯矩为：\n"
                        + "Mu = fc*b*x*(h0-x/2)+fy'As'*(h0-a')\n"
                        + "   = (" + fc + "*" + b + "*" + x + "*(" + h0+ "-" + x+ "/2)+" + fy_ + "*" + As_ + "*(" + h0 + "-" + a_ + "))/10^6\n"
                        + "   = " + Mu + "kN·m\n";
            }
            if(Mu >= k * m)
                s += ">=KM = "+ k + "*" + m + "=" + Math.round(k*m*100)/100f + "km*m\n" + "因此构件安全";
            else
                s += "<KM = "+ k + "*" + m + "=" + Math.round(k*m*100)/100f + "km*m\n" + "因此构件不安全";
            alertDialogBuilder.setMessage(s);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    };
}
