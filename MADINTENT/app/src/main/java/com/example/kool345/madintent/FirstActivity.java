package com.example.kool345.madintent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class FirstActivity extends AppCompatActivity {
ToggleButton tg1,tg2,tg3,tg4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        tg1= (ToggleButton) findViewById(R.id.Englishbtn);
        tg2= (ToggleButton) findViewById(R.id.urdubtn);
        tg3= (ToggleButton) findViewById(R.id.madbtn);
        tg4= (ToggleButton) findViewById(R.id.webBtn);


    }
    public void btnClicked(View v)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("tg1", tg1.isChecked());
        intent.putExtra("tg2", tg2.isChecked());
        intent.putExtra("tg3", tg3.isChecked());
        intent.putExtra("tg4", tg4.isChecked());
        startActivity(intent);

    }
    }

