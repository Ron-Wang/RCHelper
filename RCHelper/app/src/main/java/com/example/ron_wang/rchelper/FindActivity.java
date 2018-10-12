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

public class FindActivity extends AppCompatActivity {
    final Context context = this;
    private List<String> listType = new ArrayList<String>();
    private Spinner spinnerType;
    private ArrayAdapter<String> adapterType;
    private int type_no;
    private Button btnCal;
    private EditText edittxtA,edittxtMin,edittxtMax;
    float A,Min,Max,Min_,Max_;
    private float[][] areaAs = {
            {28.3f,57 ,85 ,113 ,142 ,170 ,198 ,226 ,255},
            {33.2f,66 ,100 ,133 ,166 ,199 ,232 ,265 ,299},
            {50.3f,101 ,151 ,201 ,252 ,302 ,352 ,402 ,453},
            {78.5f,157 ,236 ,314 ,393 ,471 ,550 ,628 ,707},
            {113.1f,226 ,339 ,452 ,565 ,678 ,791 ,904 ,1017},
            {153.9f,308 ,461 ,615 ,769 ,923 ,1077 ,1231 ,1385},
            {201.1f,402 ,603 ,804 ,1005 ,1206 ,1407 ,1608 ,1809},
            {254.5f,509 ,763 ,1017 ,1272 ,1527 ,1781 ,2036 ,2290},
            {314.2f,628 ,942 ,1256 ,1570 ,1884 ,2199 ,2513 ,2827},
            {380.1f,760 ,1140 ,1520 ,1900 ,2281 ,2661 ,3041 ,3421},
            {490.9f,982 ,1473 ,1964 ,2454 ,2945 ,3436 ,3927 ,4418},
            {615.8f,1232 ,1847 ,2463 ,3079 ,3695 ,4310 ,4926 ,5542},
            {804.2f,1609 ,2413 ,3217 ,4021 ,4826 ,5630 ,6434 ,7238},
            {1017.9f,2036 ,3054 ,4072 ,5089 ,6107 ,7125 ,8143 ,9161},
            {1256.6f,2513 ,3770 ,5027 ,6283 ,7540 ,8796 ,10053 ,11310},
            {1964.0f,3928 ,5892 ,7856 ,9820 ,11784 ,13748 ,15712 ,17676}
    };
    private float[] d1 = {6,6.5f,8,10,12,14,16,18,20,22,25,28,32,36,40,50};
    private float[][] areaAsv = {
            {404,561,718,920,1122,1369,1616,1907,2199,2536,2872,3254,3635,4488,5430,7012},
            {377,524,670,859,1047,1278,1508,1780,2053,2367,2681,3037,3393,4189,5068,6545},
            {353,491,628,805,982,1198,1414,1669,1924,2218,2513,2847,3181,3927,4752,6136},
            {333,462,591,758,924,1127,1331,1571,1811,2088,2365,2680,2994,3696,4472,5775},
            {314,436,559,716,873,1065,1257,1484,1710,1972,2234,2531,2827,3491,4224,5454},
            {298,413,529,678,827,1009,1190,1405,1620,1869,2116,2398,2679,3307,4001,5167},
            {283,393,503,644,785,958,1131,1335,1539,1775,2011,2278,2545,3142,3801,4909},
            {257,357,457,585,714,871,1028,1214,1399,1614,1828,2071,2313,2856,3456,4462},
            {236,327,419,537,654,798,942,1113,1283,1480,1676,1899,2121,2618,3168,4091},
            {226,314,402,515,628,767,905,1068,1232,1420,1608,1822,2036,2513,3041,3927},
            {217,302,387,495,604,737,870,1027,1184,1366,1547,1752,1957,2417,2924,3776},
            {202,280,359,460,561,684,808,954,1100,1268,1436,1627,1818,2244,2715,3506},
            {188,262,335,429,524,639,754,890,1026,1183,1340,1518,1696,2094,2534,3272},
            {177,245,314,403,491,599,707,834,962,1110,1257,1424,1590,1963,2376,3068},
            {166,231,296,379,462,564,665,785,906,1044,1183,1340,1497,1848,2236,2887},
            {157,218,279,358,436,532,628,742,855,985,1117,1266,1414,1745,2112,2727},
            {149,207,265,339,413,504,595,703,810,934,1058,1199,1339,1653,2001,2584},
            {141,196,251,322,393,479,565,668,770,888,1005,1139,1272,1571,1901,2454},
            {129,178,228,293,357,436,514,607,700,807,914,1036,1157,1428,1728,2231},
            {118,164,209,268,327,399,471,556,641,740,838,949,1060,1309,1584,2045},
            {113,157,201,258,314,383,452,534,616,710,804,911,1018,1257,1521,1963},
            {109,151,193,248,302,369,435,514,592,682,773,858,979,1208,1462,1888},
            {101,140,180,230,280,342,404,477,550,634,718,814,909,1122,1358,1753},
            {94,131,168,215,262,319,377,445,513,592,670,759,848,1047,1267,1636},
            {88,123,157,201,245,299,353,417,481,554,630,713,795,982,1188,1534},
            {86,119,152,195,238,290,343,405,466,538,609,690,771,952,1152,1487}
    };
    private String[] d2 = {"6","6/8","8","8/10","10","10/12","12","12/14",
            "14","14/16","16","16/18","18","20","22","25"};
    private int[] dis = {70,75,80,85,90,95,100,110,120,125,130,140,150,
            160,170,180,190,200,220,240,250,260,280,300,320,330};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        btnCal = (Button)findViewById(R.id.Btncal1);
        edittxtA = (EditText)findViewById(R.id.EditA);
        edittxtMin = (EditText)findViewById(R.id.EditMin);
        edittxtMax = (EditText)findViewById(R.id.EditMax);
        spinnerType = (Spinner)findViewById(R.id.SpinType);
        listType.add("As(mm^2)");
        listType.add("Asv/s(mm^2/mm)");

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
        btnCal.setOnClickListener(btnCalOnClick);
    }

    private View.OnClickListener btnCalOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            A = Float.valueOf(edittxtA.getText().toString());
            Min = Float.valueOf(edittxtMin.getText().toString());
            Max = Float.valueOf(edittxtMax.getText().toString());
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder
                    .setTitle("根据要求得到的配筋方案")
                    .setIcon(R.drawable.icon9)
                    .setCancelable(true)
                    .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    });
            String s;
            int sum = 0;
            if(type_no == 0)
            {
                s = "已知As = " + A +"mm^2,允许范围：-" + Min +"%~"+ Max +"%\n\n";
                for(int i_d = 0;i_d < 16;i_d ++)
                {
                    for(int i_num = 0;i_num < 9;i_num++)
                    {
                        if(areaAs[i_d][i_num] < A)
                        {
                            Min_ = (float)Math.round((A - areaAs[i_d][i_num])/A*10000)/100f;
                            if(Min_ < Min)
                            {
                                ++ sum;
                                s += "第"+sum+"种：根数"+(i_num+1)+";公称直径："+d1[i_d]+"mm;面积："+areaAs[i_d][i_num]+"mm^2;偏差：-"+Min_+"%\n\n";
                            }
                        }
                        else
                        {
                            Max_ = (float)Math.round((areaAs[i_d][i_num] - A)/A*10000)/100f;
                            if(Max_ < Max)
                            {
                                ++ sum;
                                s += "第"+sum+"种：根数"+(i_num+1)+";公称直径："+d1[i_d]+"mm;面积："+areaAs[i_d][i_num]+"mm^2;偏差：+"+Max_+"%\n\n";
                            }
                        }
                    }
                }
            }
            else
            {
                s = "已知Asv/s = " + A +"mm^2/mm,允许范围：-" + Min +"%~"+ Max +"%\n\n";
                for(int i_d = 0;i_d < 16;i_d ++)
                {
                    for(int i_dis = 0;i_dis < 26;i_dis++)
                    {
                        if(areaAsv[i_dis][i_d] < A)
                        {
                            Min_ = (float)Math.round((A - areaAsv[i_dis][i_d])/A*10000)/100f;
                            if(Min_ < Min)
                            {
                                ++ sum;
                                s += "第"+sum+"种：间距"+dis[i_dis]+"mm;公称直径："+d2[i_d]+"mm;面积："+areaAsv[i_dis][i_d]+"mm^2/mm;偏差：-"+Min_+"%\n\n";
                            }
                        }
                        else
                        {
                            Max_ = (float)Math.round((areaAsv[i_dis][i_d] - A)/A*10000)/100f;
                            if(Max_ < Max)
                            {
                                ++ sum;
                                s += "第"+sum+"种：间距"+dis[i_dis]+"mm;公称直径："+d2[i_d]+"mm;面积："+areaAsv[i_dis][i_d]+"mm^2/mm;偏差：+"+Max_+"%\n\n";
                            }
                        }
                    }
                }
            }
            s += "总共有" + sum +"种符合要求的配筋方案\n";
            alertDialogBuilder.setMessage(s);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
    };
}
