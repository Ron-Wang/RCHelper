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

public class TJActivity extends AppCompatActivity {

    final Context context = this;
    private List<String> listType = new ArrayList<String>()
            ,listCon = new ArrayList<String>()
            ,listRein = new ArrayList<String>();
    private Spinner spinnerType,spinnerCon,spinnerRein;
    private ArrayAdapter<String> adapterType,adapterCon,adapterRein;
    private Button btnCal;
    private EditText edittxtH,edittxtB,edittxtHf_,edittxtBf_,edittxtA,edittxtAs,edittxtK,edittxtM;
    float h,b,hf_,bf_,k,a,m,m_,h0,alphas,alphas1,xi,xi1,As,fc,fy,ft,rho,rhomin,first,Mu,x;
    float con[] = {7.2f,9.6f,11.9f,14.3f,16.7f,19.1f,21.1f,23.1f,25.3f,27.5f};
    float conft[] = {0.91f,1.10f,1.27f,1.43f,1.5f,1.71f,1.80f,1.89f,1.96f,2.04f};
    float rein[] = {210,300,360,360};
    int type_no,rein_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tj);

        btnCal = (Button)findViewById(R.id.Btncal1);
        edittxtH = (EditText)findViewById(R.id.EditH);
        edittxtB = (EditText)findViewById(R.id.EditB);
        edittxtHf_ = (EditText)findViewById(R.id.EditHf_);
        edittxtBf_ = (EditText)findViewById(R.id.EditBf_);
        edittxtA = (EditText)findViewById(R.id.EditA);
        edittxtAs = (EditText)findViewById(R.id.EditAs);
        edittxtK = (EditText)findViewById(R.id.EditK);
        edittxtM = (EditText)findViewById(R.id.EditM);
        spinnerType = (Spinner)findViewById(R.id.SpinType) ;
        spinnerCon = (Spinner)findViewById(R.id.SpinCon);
        spinnerRein = (Spinner)findViewById(R.id.SpinRein);

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

        adapterType = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,listType);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapterType);
        spinnerType.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
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
        spinnerType.setOnTouchListener(new Spinner.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return false;
            }
        });
        spinnerType.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
            }
        });

        adapterCon = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,listCon);
        adapterCon.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCon.setAdapter(adapterCon);
        spinnerCon.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
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
        spinnerCon.setOnTouchListener(new Spinner.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return false;
            }
        });
        spinnerCon.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
            }
        });

        adapterRein = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,listRein);
        adapterRein.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRein.setAdapter(adapterRein);
        spinnerRein.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
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
        spinnerRein.setOnTouchListener(new Spinner.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return false;
            }
        });
        spinnerRein.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){
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
            hf_ = Float.valueOf(edittxtHf_.getText().toString());
            bf_ = Float.valueOf(edittxtBf_.getText().toString());
            k = Float.valueOf(edittxtK.getText().toString());
            a = Float.valueOf(edittxtA.getText().toString());
            m = Float.valueOf(edittxtM.getText().toString());
            As = Float.valueOf(edittxtAs.getText().toString());

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

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder
                    .setTitle("T形截面校核")
                    .setIcon(R.drawable.icon8)
                    .setCancelable(true)
                    .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    });

            first = Math.round(fc*bf_*hf_/fy);
            String s;
            s = "已知：\n"
                    + "fc = " + fc + "N/mm²\n"
                    + "ft = " + ft + "N/mm²\n"
                    + "fy = " + fy + "N/mm²\n"
                    + "h0 = h - a = " + h0 + "mm\n"
                    + "As = " + As + "mm^2\n";

            if(As <= first){
                x = Math.round(fy*As/(fc*bf_)*100)/100f;
                Mu = Math.round(fy*As*(h0-(As*fy)/(2*fc*bf_))/1000000);
                s += " <= fc*bf'*hf'/fy = " + fc + "*" + bf_ + "*" + hf_ + "/" + fy + " = " + first + "mm^2\n"
                        + "为第一类T形截面\n"
                        + "钢筋屈服时混凝土的受压高度为：\n"
                        + "x = fy*As/(fc*bf')\n"
                        + "  = " + fy + "*" + As + "/(" + fc + "*" + bf_ + ")\n"
                        + "  = " + x + "mm\n"
                        + "能够抵抗的最大弯矩为：\n"
                        + "Mu = fy*As*(h0-x/2)\n"
                        + "   = (" + fy + "*" + As + "*(" + h0 + "-" + x + "/2)))/10^6\n"
                        + "   = " + Mu + "kN·m\n";
            }
            else{
                x = Math.round((fy*As-fc*(bf_-b)*hf_)/(fc*b)*100)/100f;
                Mu = Math.round((fc*b*x*(h0-x/2)+fc*(bf_-b)*hf_*(h0-hf_/2))/1000000);
                s += " > fc*bf'*hf'/fy = " + fc + "*" + bf_ + "*" + hf_ + "/" + fy + " = " + first + "mm\n"
                        + "为第二类T形截面\n"
                        + "钢筋屈服时混凝土的受压高度为：\n"
                        + "x = (fy*As-fc*(bf'-b)*hf')/(fc*b)\n"
                        + "  = (" + fy + "*" + As + "-" + fc + "*(" + bf_ + b + ")*" + hf_ + ")/(" + fc + "*" + b + ")\n"
                        + "  = " + x + "mm\n"
                        + "能够抵抗的最大弯矩为：\n"
                        + "Mu = fc*b*x*(h0-x/2)+fc*(bf'-b)*hf'*(h0-hf'/2)\n"
                        + "   = (" + fc + "*" + b + "*" + x + "*(" + h0 + "-" + x + "/2)+" + fc + "*(" + bf_+ "-"
                        + b + ")*" + hf_ + "*(" + h0 + "-" + hf_ + "/2))/10^6\n"
                        + "  = " + Mu + "kN·m\n";
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
