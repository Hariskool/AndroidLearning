package com.example.kool345.listviewapp;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends BaseAdapter {
    private int badc=5;

    public  int getBadc() {
        return badc;
    }

    public int getAveragec() {
        return averagec;
    }

    public int getGoodc() {
        return goodc;
    }

    public int getVgoodc() {
        return vgoodc;
    }

    public static int averagec;
    public static int goodc;
    public static int vgoodc;
    Context context;
    String[] questionsList;
    LayoutInflater inflter;
    public static ArrayList<String> selectedAnswers;

    public CustomAdapter(){}
    public CustomAdapter(Context applicationContext, String[] questionsList) {
        this.context = context;
        this.questionsList = questionsList;

        selectedAnswers = new ArrayList<>();
        for (int i = 0; i < questionsList.length; i++) {
            selectedAnswers.add("Not Attempted");
        }
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return questionsList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.list_items, null);

        TextView question = (TextView) view.findViewById(R.id.question);
        RadioButton bad = (RadioButton) view.findViewById(R.id.bad);
        RadioButton average = (RadioButton) view.findViewById(R.id.average);
        RadioButton good = (RadioButton) view.findViewById(R.id.good);
        final RadioButton vgood = (RadioButton) view.findViewById(R.id.vgood);
        bad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    selectedAnswers.set(i, "bad");
                badc=+1;
            }
        });

        average.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    selectedAnswers.set(i, "average");
                averagec++;

            }
        });

        good.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    selectedAnswers.set(i, "good");
                goodc=+1;

            }
        });

        vgood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    selectedAnswers.set(i, "v.good");
                vgoodc++;

            }
        });

        question.setText(questionsList[i]);
        return view;
    }
}