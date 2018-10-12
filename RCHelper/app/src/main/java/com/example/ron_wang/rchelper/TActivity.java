package com.example.ron_wang.rchelper;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.MainThread;
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

public class TActivity extends AppCompatActivity {

    final Context context = this;
    private List<String> listType = new ArrayList<String>()
            ,listCon = new ArrayList<String>()
            ,listRein = new ArrayList<String>();
    private Spinner spinnerType,spinnerCon,spinnerRein;
    private ArrayAdapter<String> adapterType,adapterCon,adapterRein;
    private Button btnCal;
    private EditText edittxtH,edittxtB,edittxtHf_,edittxtBf_,edittxtA,edittxtK,edittxtM;
    float h,b,hf_,bf_,k,a,m,m_,h0,alphas,alphas1,xi,xi1,As,fc,fy,ft,rho,rhomin;
    float con[] = {7.2f,9.6f,11.9f,14.3f,16.7f,19.1f,21.1f,23.1f,25.3f,27.5f};
    float conft[] = {0.91f,1.10f,1.27f,1.43f,1.5f,1.71f,1.80f,1.89f,1.96f,2.04f};
    float rein[] = {210,300,360,360};
    int type_no,rein_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t);

        btnCal = (Button)findViewById(R.id.Btncal1);
        edittxtH = (EditText)findViewById(R.id.EditH);
        edittxtB = (EditText)findViewById(R.id.EditB);
        edittxtHf_ = (EditText)findViewById(R.id.EditHf_);
        edittxtBf_ = (EditText)findViewById(R.id.EditBf_);
        edittxtA = (EditText)findViewById(R.id.EditA);
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
                    .setTitle("T形截面设计")
                    .setIcon(R.drawable.icon3)
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
                    + "h0 = h - a = " + h0 + "mm\n"
                    + "计算过程：\n"
                    + "临界状态混凝土提供的弯矩为：\n"
                    +"M = fc*bf'*hf'*(h0-hf'/2)\n"
                    +"  = " + fc + "*" + bf_ + "*" +hf_ + "*(" +h0 + "-" + hf_ +"/2)/10^6\n"
                    +"  = " + Math.round(fc * bf_ * hf_ * (h0 - hf_ / 2)/10000)/100f + "kN*m\n";

            if(k * m * 1000000 <= fc * bf_ * hf_ * (h0 - hf_ / 2)){
                alphas = Math.round(k * m / (fc * bf_ * h0 * h0)* 1000000 * 1000) / 1000.0f;
                xi = Math.round((1 - Math.sqrt(1 - 2 * alphas)) * 1000) / 1000.0f;
                As = Math.round(fc * bf_ * xi * h0 / fy);
                rho = Math.round(As / (b * h)*10000)/10000f;
                s += "  >= KM = " + k + "*" + m + "=" + Math.round(k*m*100)/100f + "kN*m\n"
                        +"为第一类T形截面\n"
                        + "αs = KM/(fc*bf'*h0*h0)\n"
                        + "   = " + k + "*" + m + "*10^6/(" + fc + "*" + bf_ + "*" + h0 + "*" + h0 + ")\n"
                        + "   = " + alphas + "\n";
                if(alphas <= 0.386){
                    s += "ξ = 1-sqrt(1-2αs)\n"
                            + "   = 1-sqrt(1-2*" + alphas + ")\n"
                            + "   = " + xi + "<=0.85ξb = 0.522,未超筋\n"
                            + "配筋面积为：\n"
                            + "As = fc*bf'*ξ*h0/fy\n"
                            + "   = " + fc + "*" + bf_ + "*" + xi + "*" + h0 + "/" + fy + "\n"
                            + "   = " + As + "mm²\n"
                            + "配筋率为：\n"
                            + "ρ = As/(b*h)\n"
                            + "   = " + As + "/(" + b + "*" + h + ")\n"
                            + "   = " + rho + "\n";
                    if(rho < rhomin)
                    {
                        s += "   <ρmin = " + rhomin + ",少筋\n"
                                + "按照最小配筋率配筋，配筋面积为：\n"
                                + "As = ρmin*b*h\n"
                                + "   = " + rhomin + "*" + b + "*" + h + "\n"
                                + "   = " + Math.round(rhomin*b*h) + "mm²\n";
                    }
                    else
                    {
                        s += "   >=ρmin = " + rhomin + ",适筋\n";
                    }
                }
                else{
                    s += "> αsb = 0.386,超筋\n"
                            + "请重新设计截面尺寸或修改材料强度";
                }
            }
            else{
                m_ = Math.round(fc *(bf_ - b) * hf_ * (h0 - hf_ / 2)/10000)/100f;
                alphas1 = Math.round((k * m - m_) * 1000000 / (fc * b * h0 * h0)*1000)/1000f;

                s += "  < KM = " + k + "*" + m + "=" + Math.round(k*m*100)/100f + "kN*m\n"
                        +"为第二类T形截面\n"
                        +"翼缘所承担的弯矩值：\n"
                        +"M' = fc*(bf'-b)*hf'*(h0-hf'/2)\n"
                        +"   = " + fc + "*(" + bf_ + "-" + b + ")*" +hf_ + "*(" + h0 + "-" + hf_ +"/2)/10^6\n"
                        +"   = " + m_ + "kN*m\n"
                        + "αs1 = (KM-M')/(fc*b*h0*h0)\n"
                        + "    = (" + k + "*" + m + "-" + m_ + ")*10^6/(" + fc + "*" + b + "*" + h0 + "*" + h0 + ")\n"
                        + "    = " + alphas1 + "\n";

                if(alphas1 <= 0.386){
                    xi1 = Math.round((1 - Math.sqrt(1 - 2 * alphas1)) * 1000) / 1000.0f;
                    As = Math.round((fc * b * xi1 * h0 + fc * (bf_ - b) * hf_) / fy);
                    rho = Math.round(As / (b * h)*10000)/10000f;
                    s += "ξ1 = 1-sqrt(1-2αs1)\n"
                            + "    = 1-sqrt(1-2*" + alphas1 + ")\n"
                            + "    = " + xi1 + "<=0.85ξb = 0.522,未超筋\n"
                            + "配筋面积为：\n"
                            + "As = (fc*b*ξ1*h0+fc*(bf'-b)hf')/fy\n"
                            + "   = (" + fc + "*" + b + "*" + xi1 + "*" + h0 + "+" + fc + "*(" + bf_ + "-" + b + "*" + hf_ +")/" + fy + "\n"
                            + "   = " + As + "mm²\n"
                            + "配筋率为：\n"
                            + "ρ = As/(b*h)\n"
                            + "   = " + As + "/(" + b + "*" + h + ")\n"
                            + "   = " + rho + "\n";
                    if(rho < rhomin)
                    {
                        s += "   <ρmin = " + rhomin + ",少筋\n"
                                + "按照最小配筋率配筋，配筋面积为：\n"
                                + "As = ρmin*b*h\n"
                                + "   = " + rhomin + "*" + b + "*" + h + "\n"
                                + "   = " + Math.round(rhomin*b*h) + "mm²\n";
                    }
                    else
                    {
                        s += "   >=ρmin = " + rhomin + ",适筋\n";
                    }
                }
                else{
                    s += "> αsb = 0.386,超筋\n"
                            + "请重新设计截面尺寸或修改材料强度";
                }
            }
            alertDialogBuilder.setMessage(s);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    };

}
