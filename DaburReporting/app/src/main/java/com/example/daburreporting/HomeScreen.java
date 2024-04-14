package com.example.daburreporting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    Button dailyssmbrandsalesreport,marketcompitition,outletdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        dailyssmbrandsalesreport=findViewById(R.id.dailybrandwisesalesreport);
        outletdetails=findViewById(R.id.outletdetails);
        marketcompitition=findViewById(R.id.marketcompitition);

        dailyssmbrandsalesreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeScreen.this,DailyReport.class);
                startActivity(intent);
            }
        });

        outletdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeScreen.this,OutletDetails.class);
                startActivity(intent);
            }
        });

        marketcompitition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeScreen.this,MarketCompitition.class);
                startActivity(intent);
            }
        });
    }

}