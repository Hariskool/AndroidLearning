package com.example.kool345.listviewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int bad=0,avg=0,good=0,vgood=0;
    ListView simpleList;
    String[] questions;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questions = getResources().getStringArray(R.array.questions);
        // get the reference of ListView and Button
        simpleList = (ListView) findViewById(R.id.simpleListView);
        submit = (Button) findViewById(R.id.submit);
        // set the adapter to fill the data in the ListView
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), questions);
        simpleList.setAdapter(customAdapter);
        // perform setOnClickListerner event on Button

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "";
                // get the value of selected answers from custom adapter
                for (int i = 0; i < CustomAdapter.selectedAnswers.size(); i++) {
                    if(CustomAdapter.selectedAnswers.get(i).equals("bad"))
                    {
                        bad++;
                    }
                    if(CustomAdapter.selectedAnswers.get(i).equals("average"))
                    {
                        avg++;
                    }
                    if(CustomAdapter.selectedAnswers.get(i).equals("good"))
                    {
                        good++;
                    }
                    if(CustomAdapter.selectedAnswers.get(i).equals("v.good"))
                    {
                        vgood++;
                    }
                    message = message + "\n" + (i + 1) + " " + CustomAdapter.selectedAnswers.get(i);
                }
                // display the message on screen with the help of Toast.
                message+="\n"+"Bad skills:"+Integer.toString(bad);
                message+="\n"+"average skills:"+Integer.toString(avg);
                message+="\n"+"good skills:"+Integer.toString(good);
                message+="\n"+"vgood skills:"+Integer.toString(vgood);
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("tg1",Integer.toString(bad) );
                intent.putExtra("tg2", Integer.toString(avg));
                intent.putExtra("tg3", Integer.toString(good));
                intent.putExtra("tg4", Integer.toString(vgood));
                bad=0;
                avg=0;
                good=0;
                vgood=0;
                startActivity(intent);


            }
        });
    }

}
