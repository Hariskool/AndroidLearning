package com.example.kool345.madintentactivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_LOCATION = 1;
    double latti=0 ;
    double longi=0 ;
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onBtnMapClicked(View v) {

       // Intent intent = null;
        Intent choice = null;
        Double longitude, latitude;
        EditText usernameEditText = (EditText) findViewById(R.id.LocMap);
        String sUsername = usernameEditText.getText().toString();
        if (TextUtils.isEmpty(sUsername)) {
            usernameEditText.setError("Location not Entered");
            return;

        }
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        getLocation();

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:"+Double.toString(latti)+","+Double.toString(longi)));
       choice=intent.createChooser(intent,"Launch Maps");
        startActivity(choice);
    }
    public void onBtnNavClicked(View v) {

        // Intent intent = null;
        Intent choice = null;
        Double longitude, latitude;
        EditText usernameEditText = (EditText) findViewById(R.id.LocMap);
        String sUsername = usernameEditText.getText().toString();
        if (TextUtils.isEmpty(sUsername)) {
            usernameEditText.setError("Location not Entered");
            return;

        }
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        getLocation();

        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr="+Double.toString(latti)+","+Double.toString(longi)+"&daddr="+33.617782+","+73.121127));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }
    void getLocation() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (location != null){
               latti = location.getLatitude();
                 longi = location.getLongitude();

                ((EditText)findViewById(R.id.Latitude)).setText(Double.toString(latti));
                ((EditText)findViewById(R.id.Longitude)).setText(Double.toString(longi));
            } else {
                ((EditText)findViewById(R.id.Latitude)).setText("Unable to find correct location.");
                ((EditText)findViewById(R.id.Longitude)).setText("Unable to find correct location. ");
            }
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_LOCATION:
                getLocation();
                break;
        }
    }
}
