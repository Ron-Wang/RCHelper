package com.example.ron_wang.rchelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnSingle,btnDouble,btnT,btnPre,btnJ,btnSingleJ,btnDoubleJ,btnTJ,btnPreJ,btnTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSingle = (Button)findViewById(R.id.btnSingle);
        btnDouble = (Button)findViewById(R.id.btnDouble);
        btnT = (Button)findViewById(R.id.btnT);
        btnPre = (Button)findViewById(R.id.btnPre);
        btnJ = (Button)findViewById(R.id.btnJ);
        btnSingleJ = (Button)findViewById(R.id.btnSingleJ);
        btnDoubleJ = (Button)findViewById(R.id.btnDoubleJ);
        btnTJ = (Button)findViewById(R.id.btnTJ);
        btnPreJ = (Button)findViewById(R.id.btnPreJ);
        btnTable = (Button)findViewById(R.id.btnTable);

        btnSingle.setOnClickListener(btnSingleOnclick);
        btnDouble.setOnClickListener(btnDoubleOnclick);
        btnT.setOnClickListener(btnDoubleOnclick);
        btnPre.setOnClickListener(btnDoubleOnclick);
        btnJ.setOnClickListener(btnDoubleOnclick);
        btnSingleJ.setOnClickListener(btnDoubleOnclick);
        btnDoubleJ.setOnClickListener(btnDoubleOnclick);
        btnTJ.setOnClickListener(btnDoubleOnclick);
        btnPreJ.setOnClickListener(btnDoubleOnclick);
        btnTable.setOnClickListener(btnDoubleOnclick);
    }
    private View.OnClickListener btnSingleOnclick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this,SingleActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btnDoubleOnclick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this,DoubleActivity.class);
            startActivity(intent);
        }
    };
}
