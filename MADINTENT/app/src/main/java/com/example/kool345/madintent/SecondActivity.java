package com.example.kool345.madintent;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ToggleButton;

public class SecondActivity extends AppCompatActivity {
    ToggleButton tg1,tg2,tg3,tg4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tg1= (ToggleButton) findViewById(R.id.Englishbtn);
        tg2= (ToggleButton) findViewById(R.id.urdubtn);
        tg3= (ToggleButton) findViewById(R.id.madbtn);
        tg4= (ToggleButton) findViewById(R.id.webBtn);

        boolean istg1Checked = getIntent().getBooleanExtra("tg1",false);
        boolean istg2Checked = getIntent().getBooleanExtra("tg2",false);
        boolean istg3Checked = getIntent().getBooleanExtra("tg3",false);
        boolean istg4Checked = getIntent().getBooleanExtra("tg4",false);
        tg1.setChecked(istg1Checked);
        tg2.setChecked(istg2Checked);
        tg3.setChecked(istg3Checked);
        tg4.setChecked(istg4Checked);



    }
}
