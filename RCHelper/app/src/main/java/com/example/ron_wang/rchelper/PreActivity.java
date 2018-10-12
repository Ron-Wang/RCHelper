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

public class PreActivity extends AppCompatActivity {

    final Context context = this;
    private List<String> listType = new ArrayList<String>()
            ,listType_ = new ArrayList<String>()
            ,listCon = new ArrayList<String>()
            ,listRein = new ArrayList<String>()
            ,listRein_ = new ArrayList<String>();
    private Spinner spinnerType,spinnerType_,spinnerCon,spinnerRein,spinnerRein_;
    private ArrayAdapter<String> adapterType,adapterType_,adapterCon,adapterRein,adapterRein_;
    private Button btnCal;
    private EditText edittxtL,edittxtH,edittxtB,edittxtA,edittxtA_,edittxtE,edittxtK,edittxtN;
    float l,h,b,k,a,a_,e0,e,e_,n,kk,zeta1,zeta2,eta,xib,h0,alphas,As,As_,fc,fy,fy_,rho,rhomin,rhomin_,h0_,xi,x;
    float con[] = {7.2f,9.6f,11.9f,14.3f,16.7f,19.1f,21.1f,23.1f,25.3f,27.5f};
    float rein[] = {210,300,360,360};
    int type_no,type__no,rein_no,rein__no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre);

        btnCal = (Button)findViewById(R.id.Btncal1);
        edittxtL = (EditText)findViewById(R.id.EditL);
        edittxtH = (EditText)findViewById(R.id.EditH);
        edittxtB = (EditText)findViewById(R.id.EditB);
        edittxtA = (EditText)findViewById(R.id.EditA);
        edittxtA_ = (EditText)findViewById(R.id.EditA_);
        edittxtE = (EditText)findViewById(R.id.EditE);
        edittxtK = (EditText)findViewById(R.id.EditK);
        edittxtN = (EditText)findViewById(R.id.EditN);
        spinnerType = (Spinner)findViewById(R.id.SpinType);
        spinnerType_ = (Spinner)findViewById(R.id.SpinType_);
        spinnerCon = (Spinner)findViewById(R.id.SpinCon);
        spinnerRein = (Spinner)findViewById(R.id.SpinRein);
        spinnerRein_ = (Spinner)findViewById(R.id.SpinRein_);

        listType.add("未知计算高度");
        listType.add("已知计算高度");
        listType_.add("两端固定");
        listType_.add("一端自由一端固定");
        listType_.add("一端固定一端铰");
        listType_.add("两端均为铰");
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

        adapterType_ = new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,listType_);
        adapterType_.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType_.setAdapter(adapterType_);
        spinnerType_.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                type__no = arg2;
                arg0.setVisibility(View.VISIBLE);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                arg0.setVisibility(View.VISIBLE);
            }
        });
        spinnerType_.setOnTouchListener(new Spinner.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return false;
            }
        });
        spinnerType_.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){
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
                rein__no = arg2;
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
            l = Float.valueOf(edittxtL.getText().toString());
            h = Float.valueOf(edittxtH.getText().toString());
            b = Float.valueOf(edittxtB.getText().toString());
            k = Float.valueOf(edittxtK.getText().toString());
            a = Float.valueOf(edittxtA.getText().toString());
            a_ = Float.valueOf(edittxtA_.getText().toString());
            e0 = Float.valueOf(edittxtE.getText().toString());
            n = Float.valueOf(edittxtN.getText().toString());

            h0 = h - a;
            xib = 0.614f;

            if(type_no == 0){
                if(type__no == 0)
                    kk = 0.5f;
                else if(type__no == 1)
                    kk = 2f;
                else if(type__no == 2)
                    kk = 0.7f;
                else
                    kk = 1;
            }
            else {
                kk = 1;
            }
            if(rein_no == 0)
                rhomin = 0.0025f;
            else
                rhomin = 0.0020f;
            if(rein__no == 0)
                rhomin_ = 0.0025f;
            else
                rhomin_ = 0.0020f;

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder
                    .setTitle("偏心受压截面设计")
                    .setIcon(R.drawable.icon4)
                    .setCancelable(true)
                    .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    });

            String s;
            s = "已知：\n" + "fc = " + fc + "N/mm²\n"
                    + "fy = " + fy + "N/mm²\n"
                    + "fy' = " + fy_ + "N/mm²\n"
                    + "h0 = h - a = " + h0 + "mm\n"
                    + "l0/h = " + kk*l + "*1000/" + h + "=" +Math.round(kk*l/h*100000)/100f;

            if(kk * l / h * 1000<= 8){
                eta = 1;
                s += "<= 8\n" + "不需要考虑纵向弯曲的影响,η = 1\n"
                        + "ηe0 = " + eta + "*" + e0 + "=" + eta*e0;
            }
            else {
                zeta1 = Math.round(0.5 * fc * b * h / (k * n)) / 1000f;
                zeta2 = Math.round((1.15f - 0.01f * kk * l / h * 1000) * 1000) / 1000f;
                s += ">8\n" + "需要考虑纵向弯曲的影响\n"
                        + "ζ1 = 0.5*fc*b*h/(K*N)\n"
                        + "    = " + 0.5 + "*" + fc + "*" + b + "*" + h + "/(" + k + "*" + n + "*10^3)\n"
                        + "    = " + zeta1;
                if (zeta1 > 1) {
                    zeta1 = 1;
                    s += ">1\n" + "故ζ1 = 1\n";
                } else {
                    s += "<1\n" + "故ζ1 = " + zeta1 + "\n";
                }
                s += "ζ2 = 1.15-0.01*l0/h\n"
                        + "    = " + 1.15 + "-" + 0.01 + "*" + Math.round(kk * l / h * 100000) / 100f + "\n"
                        + "    = " + zeta2;
                if (zeta2 > 1) {
                    zeta2 = 1;
                    s += ">1\n" + "故ζ2 = 1\n";
                } else {
                    s += "<1\n" + "故ζ2 = " + zeta2 + "\n";
                }
                eta = Math.round((1 + 1 / (1400f * e0 / h0) * (kk * l / h * 1000) * (kk * l / h * 1000) * zeta1 * zeta2)*1000)/1000f;
                s += "η = 1+1/(1400*e0/h0)*(l0/h)^2*ζ1*ζ2\n"
                        + "   = " + 1 + "+" + 1 + "/(" + 1400 + "*" + e0 + "/" + h0 + ")*" + Math.round(kk * l / h * 100000) / 100f + "^2*" + zeta1 + "*" + zeta2 + "\n"
                        + "   = " + eta + "\n"
                        + "ηe0 = " + eta + "*" + e0 + "=" + Math.round(eta * e0*100)/100f + "mm\n";
            }

            if (eta * e0 > 0.3 * h0) {
                e = Math.round((eta * e0 + h / 2 - a)*100)/100f;
                //e_ = Math.round((h/2 - a_ - eta * e0)*100)/100f;
                As_ = Math.round((k * n * e * 1000 - fc * b * h0 * h0 * xib * (1 - 0.5 * xib)) / (fy_ * (h0 - a_)));
                s += ">0.3*h0 = " + 0.3 + "*" + h0 + " = " + Math.round(0.3 * h0 * 100) / 100f + "mm\n"
                        + "属于大偏心受压\n"
                        + "e = η*e0+h/2-a\n"
                        + "  = "+ eta + "*" + e0 + "*" + h +  "/2-" + a + "\n"
                        + "  = "+ e + "mm\n"
                        + "靠近受压端钢筋面积：\n"
                        + "As' = (K*N*e-fc*b*h0^2*ξb*(1-0.5*ξb))/(fy'*(h0-a'))\n"
                        + "      = (" + k + "*" + n + "*1000*" + e + "-" + fc
                        + "*" + b + "*" + h0 + "^2*" + xib + "*(1-0.5*" + xib + "))/(" + fy_ + "*(" + h0 + "-" + a_ + "))\n"
                        + "      = " + As_ + "mm^2\n";
                if (As_ < rhomin_ * b * h0) {
                    As_ = Math.round(rhomin_ * b * h0);
                    s += "<ρmin*b*h0 \n"
                            + " = " + rhomin_ + "*" + b + "*" + h0 + "=" + Math.round(rhomin_ * b * h0) + "\n"
                            + "故取As' = ρmin*b*h0\n"
                            + "= " + As_ + "mm^2\n";
                } else {
                    s += ">ρmin*b*h0 \n"
                            + " =ρmin*" + rhomin_ + "*" + b + "*" + h0 + "=" + Math.round(rhomin_ * b * h0) + "\n"
                            + "故取As' = " + As_ + "mm^2\n";
                }
                /*
                alphas = Math.round((k*n*e*1000-fy_*As_*(h0-a_))/(fc*b*h0*h0)*1000)/1000f;
                xi = Math.round((1 - Math.sqrt(1 - 2 * alphas)) * 1000) / 1000.0f;
                x = Math.round(xi*h0*100)/100f;
                s += "αs = (K*N*e-fy'*As'*(h0-a'))/(fc*b*h0*h0)\n "
                        + "   = ("+k+"*"+n+"*"+e+"*1000-"+fy_+"*"+As_+"*("+h0+"-"+a_+"))/("+fc+"*"+b+"*"+h0+"*"+h0+")\n"
                        + "   = "+alphas
                        + "ξ = 1-sqrt(1-2αs)\n"
                        + "   = 1-sqrt(1-2*" + alphas + ")\n"
                        + "   = " + xi + "\n"
                        + "x = ξ*h0\n"
                        + "  = "+xi+"*"+h0+"\n"
                        + "  = "+x+"mm\n";
                if(x < 2 * a_){
                    As = Math.round(k*n*e_*1000/(fy*(h0-a_)));
                    s += " < 2*a' = 2*"+a_+"mm\n"
                            + "因此靠近压力一端的钢筋未屈服\n"
                            + "As = K*N*e'/(fy*(h0-a'))\n"
                            + "   ="+k+"*"+n+"*"+e_+"*1000/("+fy+"*("+h0+"-"+a_+"))\n"
                            + "   ="+As + "mm^2\n";
                }
                else{
                    As = Math.round((k*n*1000-fc*b*x-fy_*As_)/fy);
                    s += " >= 2*a' = 2*"+a_+"mm\n"
                            + "因此靠近压力一端的钢筋屈服\n"
                            + "As = (K*N-fc*b*x-fy'*As')/fy\n"
                            + "   ="+k+"*"+n+"*1000-"+fc+"*"+b+"*"+x+"-"+fy_+"*"+As_+")/"+fy+"\n"
                            + "   ="+As + "mm^2\n";
                }
                */
                As = Math.round((fc*b*h0*xib+fy_*As_-k*n*1000)/fy_);
                s += "远离受压端钢筋面积：\n"
                        + "As = (fc*b*h0*ξb+fy'*As'-k*n*1000)/fy'\n"
                        +"   = ("+fc+"*"+b+"*"+h0+"*"+xib+"+"+fy_+"*"+As_+"-"+k+"*"+n+"*1000)/"+fy_+"\n"
                        +"   = " + As + "mm^2\n";

                if (As < rhomin * b * h0) {
                    As = Math.round(rhomin * b * h0);
                    s += "<ρmin*b*h0\n"
                            + " = " + rhomin + "*" + b + "*" + h0 + "=" + Math.round(rhomin * b * h0) + "\n"
                            + "故取As = ρmin*b*h0 = " + As + "mm^2\n";
                } else {
                    s += ">=ρmin*b*h0\n"
                            + " = " + rhomin + "*" + b + "*" + h0 + "=" + Math.round(rhomin * b * h0) + "\n"
                            + "故取As = " + As + "mm^2\n";
                }
            } else {
                e = Math.round((eta * e0 + h / 2 - a)*100)/100f;
                e_ = Math.round((h/2 - a_ - eta * e0)*100)/100f;
                h0_ = h - a_;
                As = Math.round((k*n*e_*1000-fc*b*h*(h0_-0.5*h))/(fy_*(h0_-a)));
                s += "<=0.3*h0 = " + 0.3 + "*" + h0 + " = " + Math.round(0.3 * h0 * 100) / 100f + "mm\n"
                        + "属于小偏心受压\n"
                        + "e = η*e0+h/2-a\n"
                        + "  = "+ eta + "*" + e0 + "*" + h +  "/2-" + a + "\n"
                        + "  = "+ e + "mm\n"
                        + "e' = h/2-a'-η*e0\n"
                        + "   = "+ h + "/2-" + a_ + "-" + eta +  "*" + e0 + "\n"
                        + "   = "+ e_ + "mm\n"
                        + "远离受压端钢筋面积：\n"
                        + "As = (K*N*e'-fc*b*h*(h0'-h/2))/(fy'*(h0'-a))\n"
                        + "   = (" + k + "*" + n + "*1000*" + e_ + "-" + fc
                        + "*" + b + "*" + h + "*(" + h0_ + "-" + h + "/2))/(" + fy_ + "*(" + h0_ + "-" + a + "))\n"
                        + "   = " + As + "mm^2\n";
                if (As < rhomin * b * h0) {
                    As = Math.round(rhomin * b * h0);
                    s += "<ρmin*b*h0\n"
                            + " = " + rhomin + "*" + b + "*" + h0 + "=" + Math.round(rhomin * b * h0) + "mm^2\n"
                            + "故取As = ρmin*b*h0 = " + As + "mm^2\n";
                } else {
                    s += ">ρmin*b*h0\n"
                            + " = " + rhomin + "*" + b + "*" + h0 + "=" + Math.round(rhomin * b * h0) + "mm^2\n"
                            + "故取As = " + As + "mm^2\n";
                }
                float AA,BB,CC;
                AA = - 0.5f * fc * b * h0 * h0;
                BB = fc * b * h0 * h0 - fc * b* h0 * (h0 - a_) - fy * As *(h0-a_)/(0.8f-xib);
                CC = k * n * 1000 * (h0 - a_) + fy*As*0.8f*(h0-a_)/(0.8f-xib)-k*n*e*1000;
                xi = Math.round((-BB-Math.sqrt(BB*BB-4*AA*CC))/(2*AA)*1000)/1000f;
                s += "由下面式子：\n"
                        + "K*N = fc*b*h0*ξ+fy'*As'-fy*(0.8-ξ)/(0.8-ξb)*As\n"
                        + "K*N*e = fc*b*h0^2*ξ*(1-0.5*ξ)+fy'*As'*(h0-a')\n"
                        +"解得 ξ = " + xi + "\n";
                if(xi <= 1.6 - xib){
                    As_ = Math.round((k * n * 1000 + fy * As * (0.8f-xi)/(0.8f-xib)-fc*b*h0*xi)/fy_);
                    s += " < 1.6-ξb = " + (1.6f-xib) +"\n"
                            + "靠近受压端钢筋面积：\n"
                            + "As' = (K*N+fy*As*(0.8-ξ)/(0.8-ξb)-fc*b*h0*ξ)/fy'\n"
                            + "    = (" + k +"*"+ n + "*1000+" + fy + "*" + As + "*(0.8-" + xi+ ")/(0.8-"
                            + xib + ")-" + fc+ "*" + b+ "*" + h0+ "*" + xi+ ")/" + fy_ + "\n"
                            + "    = " + As_ + "mm^2\n";
                    if (As_ < rhomin_ * b * h0) {
                        As_ = Math.round(rhomin_ * b * h0);
                        s += "<ρmin*b*h0\n"
                                + " = " + rhomin_ + "*" + b + "*" + h0 + "=" + Math.round(rhomin_ * b * h0) + "mm^2\n"
                                + "故取As_ = ρmin*b*h0 = " + As_ + "mm^2\n";
                    } else {
                        s += ">=ρmin*b*h0\n"
                                + " = " + rhomin_ + "*" + b + "*" + h0 + "=" + Math.round(rhomin_ * b * h0) + "mm^2\n"
                                + "故取As_ = " + As_ + "mm^2\n";
                    }
                } else {
                    xi = 1.6f - xib;
                    As_ = Math.round((k*n*e*1000-fc*b*h0*h0*xi*(1-0.5f*xi))/(fy_*(h0-a_)));
                    s += " > 1.6-ξb = " + (1.6f-xib) +"\n"
                            + "则取ξ=1.6-ξb = " + (1.6f-xib) +"\n"
                            + "靠近受压端钢筋面积：\n"
                            + "As' = (K*N*e-fc*b*h0*h0*ξ*(1-0.5*ξ))/(fy'*(h0-a'))\n"
                            + "    = (" + k +"*"+ n + "*1000*" + e + "-" + fc + "*" + b+ "*"
                            + h0 + "*" + h0+ "*" + xi+ "*(1-0.5*" + xi+ "))/(" + fy_+ "*(" + h0 + "-" + a_ + "))\n"
                            + "    = " + As_ + "mm^2\n";
                    if (As_ < rhomin_ * b * h0) {
                        As_ = Math.round(rhomin_ * b * h0);
                        s += "<ρmin*b*h0\n"
                                + " = " + rhomin_ + "*" + b + "*" + h0 + "=" + Math.round(rhomin_ * b * h0) + "mm^2\n"
                                + "故取As_ = ρmin*b*h0 = " + As_ + "mm^2\n";
                    } else {
                        s += ">=ρmin*b*h0\n"
                                + " = " + rhomin_ + "*" + b + "*" + h0 + "=" + Math.round(rhomin_ * b * h0) + "mm^2\n"
                                + "故取As_ = " + As_ + "mm^2\n";
                    }
                    As = Math.round((k*n*1000-fc*b*h0*xi-fy_*As_)/fy_);
                    s += "重新计算As\n"
                            + "远离受压端钢筋面积：\n"
                            + "As = (K*N-fc*b*h0*ξ-fy'*As')/fy' = " + As;
                    if (As < rhomin * b * h0) {
                        As = Math.round(rhomin * b * h0);
                        s += "<ρmin*b*h0\n"
                                + " = " + rhomin + "*" + b + "*" + h0 + "=" + Math.round(rhomin * b * h0) + "mm^2\n"
                                + "故取As = ρmin*b*h0 = " + As + "mm^2\n";
                    } else {
                        s += ">=ρmin*b*h0\n"
                                + " = " + rhomin + "*" + b + "*" + h0 + "=" + Math.round(rhomin * b * h0) + "mm^2\n"
                                + "故取As = " + As + "mm^2\n";
                    }
                }
            }
            alertDialogBuilder.setMessage(s);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    };

}
