package com.example.kool345.listviewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         TextView bad=(TextView)findViewById(R.id.badc);
         TextView  average=(TextView)findViewById(R.id.averagec);
         TextView  good=(TextView)findViewById(R.id.goodc);
         TextView  vvgood=(TextView)findViewById(R.id.vgoodc);
       // CustomAdapter c1=new CustomAdapter();


        bad.setText(getIntent().getStringExtra("tg1"));
        average.setText(getIntent().getStringExtra("tg2"));
        good.setText(getIntent().getStringExtra("tg3"));
        vvgood.setText(getIntent().getStringExtra("tg4"));

     //   vgood.setText(Integer.toString(c));
    }
}
