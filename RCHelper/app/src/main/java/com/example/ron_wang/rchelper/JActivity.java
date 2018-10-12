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

public class JActivity extends AppCompatActivity {

    final Context context = this;
    private List<String> listType = new ArrayList<String>()
            ,listCon = new ArrayList<String>()
            ,listRein = new ArrayList<String>()
            ,listRein_ = new ArrayList<String>();
    private Spinner spinnerType,spinnerCon,spinnerRein_;
    private ArrayAdapter<String> adapterType,adapterCon,adapterRein_;
    private Button btnCal;
    private EditText edittxtH,edittxtH_,edittxtB,edittxtA,edittxtK,edittxtV;
    float h,hw,b,k,a,v_,h0,h_,Asv,Vc,fc,fyv,ft,rho,rhosvmin,kk;
    float con[] = {7.2f,9.6f,11.9f,14.3f,16.7f,19.1f,21.1f,23.1f,25.3f,27.5f};
    float conft[] = {0.91f,1.10f,1.27f,1.43f,1.5f,1.71f,1.80f,1.89f,1.96f,2.04f};
    float rein[] = {210,300};
    int type_no,rein_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j);

        btnCal = (Button)findViewById(R.id.Btncal1);
        edittxtH = (EditText)findViewById(R.id.EditH);
        edittxtH_ = (EditText)findViewById(R.id.EditH_);
        edittxtB = (EditText)findViewById(R.id.EditB);
        edittxtA = (EditText)findViewById(R.id.EditA);
        edittxtK = (EditText)findViewById(R.id.EditK);
        edittxtV = (EditText)findViewById(R.id.EditV);
        spinnerType = (Spinner)findViewById(R.id.SpinType) ;
        spinnerCon = (Spinner)findViewById(R.id.SpinCon);
        spinnerRein_ = (Spinner)findViewById(R.id.SpinRein_);

        listType.add("矩形截面");
        listType.add("T形截面");
        listType.add("工形截面");
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
        listRein_.add("HPB235");
        listRein_.add("HRB335");

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

        adapterRein_ = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, listRein_);
        adapterRein_.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRein_.setAdapter(adapterRein_);
        spinnerRein_.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                fyv = rein[arg2];
                rein_no = arg2;
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
            v_ = Float.valueOf(edittxtV.getText().toString());

            h0 = h - a;

            if(type_no == 0){
                hw = h0;
            }
            else if(type_no == 1){
                h_ = Float.valueOf(edittxtH_.getText().toString());
                hw = h0 - h_;
            }
            else{
                h_ = Float.valueOf(edittxtH_.getText().toString());
                hw = h_;
            }

            if(rein_no == 0){
                rhosvmin = 0.0015f;
            }
            else{
                rhosvmin = 0.0010f;
            }

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder
                    .setTitle("斜截面抗剪设计")
                    .setIcon(R.drawable.icon5)
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
                    + "fyv = " + fyv + "N/mm²\n"
                    + "h0 = h - a = " + h0 + "mm\n"
                    + "hw = " + hw + "mm\n";

            if(hw / b <= 4){
                kk = 0.25f;
                s += "hw/b = " + hw + "/" + b + "=" + Math.round(hw/b*1000f)/1000f + "<= 4\n"
                        + "KV = " + k + "*" + v_ + "=" + Math.round(k*v_*10f)/10f+"kN";
            }
            else if(hw / b >= 6) {
                kk = 0.20f;
                s += "hw/b = " + hw + "/" + b + "=" + Math.round(hw/b*1000f)/1000f + ">= 6\n"
                        + "KV = " + k + "*" + v_ + "=" + Math.round(k*v_*10f)/10f+"kN";
            }
            else {
                kk = Math.round((0.25 - 0.05 * (hw / b - 4) / 2) * 1000) / 1000f;
                s += "4 < hw/b = " + hw + "/" + b + "=" + Math.round(hw/b*1000f)/1000f + "< 6\n"
                        + "KV = " + k + "*" + v_ + "=" + Math.round(k*v_*10f)/10f + "kN";
            }
            if(k * v_ >  kk * fc * b * h0 / 1000){
                s += " > "+ kk +"fc*b*h0 = "+ kk + "*" + fc
                        + "*" + b + "*" + h0 + "/10^3=" + Math.round( kk * fc * b * h0 / 100)/10f + "kN\n"
                        + "截面尺寸不满足抗剪要求，请重新设计\n";
            }
            else{
                Vc = Math.round(0.7 * ft * b * h0)/1000f;
                s += "<= "+ kk +"fc*b*h0 = "+ kk + "*" + fc
                        + "*" + b + "*" + h0 + "/10^3=" + Math.round( kk * fc * b * h0 / 100)/10f + "kN\n"
                        + "截面尺寸满足抗剪要求\n"
                        + "Vc = 0.7fc*b*h0 = " + 0.7 + "*" + fc + "*" + b + "*" + h0 + "=" + Vc + "kN";
                if(Vc < k * v_){
                    Asv = Math.round((k * v_ - Vc)/(1.25 * fyv * h0)*1000000)/1000f;
                    rho = Math.round(Asv / b * 100000) / 100000f;
                    s += "< " + "KV = " + k + "*" + v_ + "=" + Math.round(k*v_*10f)/10f+"kN\n"
                            + "需要腹筋抗剪，计算箍筋面积：\n"
                            + "Asv/s = (KV-Vc)/(1.25fyv*h0) = ("+ k + "*" + v_ + "-" + Vc + ")/(" + 1.25
                            + "*" + fyv + "*" + h0 + ")*10^3=" + Asv + "mm^2/mm\n"
                            + "ρsv = Asv/(bs) = "+ Asv + "/" + b + "=" + rho;
                    if(rho >= rhosvmin)
                        s += " >= ρsvmin = " + rhosvmin + " \n" + "满足最小配筋要求";
                    else
                        s += " < ρsvmin = " + rhosvmin + " \n" + "按照最小配筋率配筋，即\n"
                                + "Asv/s = ρsvmin*b = "+ rhosvmin + "*" + b + "=" + Math.round(rhosvmin*b*1000)/1000f + "mm^2/mm\n";
                }
                else{
                    s += " >= " + "KV = " + k + "*" + v_ + "=" + Math.round(k*v_*10f)/10f+"kN\n"
                            + "不需要腹筋抗剪，按构造要求配置即可";
                }
            }
            alertDialogBuilder.setMessage(s);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    };
    }
