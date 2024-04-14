package com.example.daburreporting;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class OutletDetails extends AppCompatActivity implements View.OnClickListener {

    //
    EditText name,address,personnme,mobileNo,town,beatName;



    RadioGroup radioGroup;
    RadioButton radioButton;
    Button submit;

// Get Location
    private static final int REQUEST_LOCATION=1;
    Button getLocation;
    TextView latiView,longiView;
    LocationManager locationManager;
    String latitude,longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outlet_details);

        //
        // 1 find input
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        personnme=findViewById(R.id.personName);
        mobileNo=findViewById(R.id.mobile);
        town=findViewById(R.id.town);





        // Add permisson for Latitude and Logitude
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);

        // find where location show
        latiView=findViewById(R.id.showLatitude);
        longiView=findViewById(R.id.showLongitude);
        getLocation=findViewById(R.id.getLocation);

        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);

                // check gps is on or not
                if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
                {
                    // write function to engable gps
                    onGPS();
                }
                else{
                    // GPS is already on then
                    getlocation();
                }

            }

            private void onGPS() {

                final AlertDialog.Builder builder=new AlertDialog.Builder(OutletDetails.this);
                builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                final AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }

            private void getlocation() {
                // check permission again
                if(ActivityCompat.checkSelfPermission(OutletDetails.this,Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(OutletDetails.this,Manifest.permission.ACCESS_COARSE_LOCATION)
                        !=PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(OutletDetails.this,new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION
                    },REQUEST_LOCATION);


                }
                else{
                    Location LocationGPS=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    Location LocationNetwork=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    Location LocationPassive=locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

                    if(LocationGPS !=null)
                    {
                        double lat=LocationGPS.getLatitude();
                        double longi=LocationGPS.getLongitude();

                        latitude=String.valueOf(lat);
                        longitude=String.valueOf(longi);

                        latiView.setText("Your Location "+"\n"+"Latitude"+latitude);
                        longiView.setText("Your Location "+"\n"+"Longitude"+longitude);
                    }
                    else

                    if(LocationGPS !=null)
                    {
                        double lat=LocationNetwork.getLatitude();
                        double longi=LocationNetwork.getLongitude();

                        latitude=String.valueOf(lat);
                        longitude=String.valueOf(longi);

                        latiView.setText("Your Location "+"\n"+"Latitude"+latitude);
                        longiView.setText("Your Location "+"\n"+"Longitude"+longitude);
                    }
                    else

                    if(LocationPassive !=null)
                    {
                        double lat=LocationPassive.getLatitude();
                        double longi=LocationPassive.getLongitude();

                        latitude=String.valueOf(lat);
                        longitude=String.valueOf(longi);

                        latiView.setText("Your Location "+"\n"+"Latitude"+latitude);
                        longiView.setText("Your Location "+"\n"+"Longitude"+longitude);
                    }
                    else {

                        Toast.makeText(OutletDetails.this,"Cant Get your location ",Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });


        radioGroup=findViewById(R.id.radiogroup);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int radioid=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(radioid);


            }
        });
    }

    // create a function for onclick method on radio button
    public void check(View view)
    {
        int radioid=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(radioid);
        Toast.makeText(this,"You have selected"+radioButton.getText(),Toast.LENGTH_SHORT).show();}

    @Override
    public void onClick(View view) {

    }
}