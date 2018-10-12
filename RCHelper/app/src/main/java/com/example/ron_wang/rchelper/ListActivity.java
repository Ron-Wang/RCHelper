package com.example.ron_wang.rchelper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListActivity extends AppCompatActivity {
    final Context context = this;
    private Button btnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btnCal = (Button)findViewById(R.id.Btncal1);
        btnCal.setOnClickListener(btnCalOnClick);
    }
    private View.OnClickListener btnCalOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ListActivity.this,LinkActivity.class);
            startActivity(intent);
        }
    };
}
