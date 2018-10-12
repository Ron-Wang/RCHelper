package com.example.ron_wang.rchelper;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnSingle,btnDouble,btnT,btnPre,btnJ,btnSingleJ,btnDoubleJ,btnTJ,btnFind,btnList;

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
        btnFind = (Button)findViewById(R.id.btnFind);
        btnList = (Button)findViewById(R.id.btnList);

        btnSingle.setOnClickListener(btnSingleOnclick);
        btnDouble.setOnClickListener(btnDoubleOnclick);
        btnT.setOnClickListener(btnTOnclick);
        btnPre.setOnClickListener(btnPreOnclick);
        btnJ.setOnClickListener(btnJOnclick);
        btnSingleJ.setOnClickListener(btnSingleJOnclick);
        btnDoubleJ.setOnClickListener(btnDoubleJOnclick);
        btnTJ.setOnClickListener(btnTJOnclick);
        btnFind.setOnClickListener(btnFindOnclick);
        btnList.setOnClickListener(btnListOnclick);
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
    private View.OnClickListener btnTOnclick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this,TActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btnPreOnclick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this,PreActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btnJOnclick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this,JActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btnSingleJOnclick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this,SingleJActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btnDoubleJOnclick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this,DoubleJActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btnTJOnclick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this,TJActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btnFindOnclick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this,FindActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btnListOnclick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this,ListActivity.class);
            startActivity(intent);
        }
    };
}
