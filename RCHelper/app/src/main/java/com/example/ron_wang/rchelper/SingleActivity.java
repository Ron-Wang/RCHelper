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

public class SingleActivity extends AppCompatActivity {

    final Context context = this;
    private List<String> listType = new ArrayList<String>()
            ,listCon = new ArrayList<String>()
            ,listRein = new ArrayList<String>();
    private Spinner spinnerType,spinnerCon,spinnerRein;
    private ArrayAdapter<String> adapterType,adapterCon,adapterRein;
    private Button btnCal;
    private EditText edittxtH,edittxtB,edittxtA,edittxtK,edittxtM;
    float h,b,k,a,m,h0,alphas,xi,As,fc,fy,ft,rho,rhomin;
    float con[] = {7.2f,9.6f,11.9f,14.3f,16.7f,19.1f,21.1f,23.1f,25.3f,27.5f};
    float conft[] = {0.91f,1.10f,1.27f,1.43f,1.5f,1.71f,1.80f,1.89f,1.96f,2.04f};
    float rein[] = {210,300,360,360};
    int type_no,rein_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        btnCal = (Button)findViewById(R.id.Btncal1);
        edittxtH = (EditText)findViewById(R.id.EditH);
        edittxtB = (EditText)findViewById(R.id.EditB);
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
            k = Float.valueOf(edittxtK.getText().toString());
            a = Float.valueOf(edittxtA.getText().toString());
            m = Float.valueOf(edittxtM.getText().toString());

            h0 = h - a;
            alphas = k * m /(fc * b * h0 * h0) * 1000000;
            xi = (float)(1 - Math.sqrt(1 - 2 * alphas));
            As = fc * b * xi * h0 / fy;
			rho = As / (b * h0);
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
                    .setTitle("单筋矩形截面设计")
                    .setIcon(R.drawable.icon1)
                    .setCancelable(true)
                    .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    });

            if(rho < rhomin && alphas < 0.386){
                alertDialogBuilder.setMessage("已知：\n"
                        + "fc = " + fc + "N/mm²\n"
                        + "ft = " + ft + "N/mm²\n"
                        + "fy = " + fy + "N/mm²\n"
                        + "h0 = " + h0 + "mm\n"
                        + "计算过程：\n"
                        + "αs = KM/(fc*b*h0*h0)\n"
                        + "   = " + k + "*" + m + "/(" + fc + "*" + b + "*" + h0 + "*" + h0 + ")\n"
                        + "   = " + alphas + "\n"
                        + "ξ = 1-sqrt(1-2αs)\n"
                        + "   = 1-sqrt(1-2*" + alphas + ")\n"
                        + "   = " + xi + "\n"
                        + "配筋面积为：\n"
                        + "As = fc*b*ξ*h0/fy\n"
                        + "   = " + fc + "*" + b + "*" + xi + "*" + h0 + "/" + fy + "\n"
                        + "   = " + As + "mm²\n"
                        + "配筋率为：\n"
                        + "ρ = As/(b*h0)\n"
                        + "   = " + As + "/(" + b + "*" + h0 + ")\n"
                        + "   = " + rho + "\n"
                        + "   <ρmin = " + rhomin + ",少筋\n"
                        + "按照最小配筋率配筋，配筋面积为：\n"
                        + "As = ρmin*b*h0\n"
                        + "   = " + rhomin + "*" + b + "*" + h0 + "\n"
                        + "   = " + (int)(rhomin*b*h0) + "mm²\n");
            }
            else if(alphas > 0.386){
                alertDialogBuilder.setMessage("已知：\n"
                        + "fc = " + fc + "N/mm²\n"
                        + "ft = " + ft + "N/mm²\n"
                        + "fy = " + fy + "N/mm²\n"
                        + "h0 = " + h0 + "mm\n"
                        + "计算过程：\n"
                        + "αs = KM/(fc*b*h0*h0)\n"
                        + "   = " + k + "*" + m + "/(" + fc + "*" + b + "*" + h0 + "*" + h0 + ")\n"
                        + "   = " + alphas + " < αsmin = 0.386\n"
                        + "即ξ<0.85ξb,超筋\n"
                        + "请重新设计截面尺寸或修改材料强度");
            }
            else{
                alertDialogBuilder.setMessage("已知：\n"
                        + "fc = " + fc + "N/mm²\n"
                        + "ft = " + ft + "N/mm²\n"
                        + "fy = " + fy + "N/mm²\n"
                        + "h0 = " + h0 + "mm\n"
                        + "计算过程：\n"
                        + "αs = KM/(fc*b*h0*h0)\n"
                        + "   = " + k + "*" + m + "/(" + fc + "*" + b + "*" + h0 + "*" + h0 + ")\n"
                        + "   = " + alphas + "\n"
                        + "ξ = 1-sqrt(1-2αs)\n"
                        + "   = 1-sqrt(1-2*" + alphas + ")\n"
                        + "   = " + xi + "\n"
                        + "配筋面积为：\n"
                        + "As = fc*b*ξ*h0/fy\n"
                        + "   = " + fc + "*" + b + "*" + xi + "*" + h0 + "/" + fy + "\n"
                        + "   = " + As + "mm²\n"
                        + "配筋率为：\n"
                        + "ρ = As/(b*h0)\n"
                        + "   = " + As + "/(" + b + "*" + h0 + ")\n"
                        + "   = " + rho + "\n"
                        + "   >=ρmin = " + rhomin + ",适筋");
            }


            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    };

}
