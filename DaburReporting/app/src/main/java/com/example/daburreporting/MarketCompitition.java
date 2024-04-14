package com.example.daburreporting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MarketCompitition extends AppCompatActivity implements View.OnClickListener {

    EditText ssmname,townname,companyname,brandname,skupacksize,productmrp,casesize,stockiestmargin,
    retailermargin,scheme,netrateperpcs,netratepercase,remark;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_compitition);

        ssmname = findViewById(R.id.ssmname);
        townname = findViewById(R.id.townname);
        companyname = findViewById(R.id.townname);
        brandname = findViewById(R.id.brandname);
        skupacksize = findViewById(R.id.skupacksize);
        productmrp = findViewById(R.id.mrp);
        casesize = findViewById(R.id.casesize);
        stockiestmargin = findViewById(R.id.stockiestmargin);
        retailermargin = findViewById(R.id.retailermargin);
        scheme = findViewById(R.id.scheme);
        netrateperpcs = findViewById(R.id.netrateperpc);
        netratepercase = findViewById(R.id.netratepercase);
        remark = findViewById(R.id.remark);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);

    }

    //This is the part where data is transafeered from Your Android phone to Sheet by using HTTP Rest API calls
    private void additemtosheet() {

        final ProgressDialog loading = ProgressDialog.show(this, "Adding Item", "Please wait");
        final String ssm_name = ssmname.getText().toString().trim();
        final String town_name = townname.getText().toString().trim();
        final String company_name = companyname.getText().toString().trim();
        final String brand_name = brandname.getText().toString().trim();
        final String skupack_size = skupacksize.getText().toString().trim();
        final String product_mrp = productmrp.getText().toString().trim();
        final String case_size = casesize.getText().toString().trim();
        final String stockiest_margin = stockiestmargin.getText().toString().trim();
        final String retailer_margin = retailermargin.getText().toString().trim();
        final String scheme_net = scheme.getText().toString().trim();
        final String netrateper_pcs = netrateperpcs.getText().toString().trim();
        final String netrateper_case = netratepercase.getText().toString().trim();
        final String remark_final = remark.getText().toString().trim();

        // Step 1 for Making Request-- http request create volley first make request queue

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://script.google.com/macros/s/AKfycbwAyV9gmg4ymynfM8sVe2ZLJGNsWSostKkEdG1LWiIAXf5m1ZMBQIHZb-GpsfvdNOCR/exec", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                Toast.makeText(MarketCompitition.this, "Response" + response, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MarketCompitition.this,"Error"+error.getMessage(),Toast.LENGTH_LONG).show();
            }
        })
        {

            @Override
            protected Map<String, String> getParams() {
                //Remove Below Line
                // return super.getParams();
                Map<String, String> params = new HashMap<>();
                // now we will put sting on our post parameter
                params.put("action","addReport");
                params.put("ssmname", ssm_name);
                params.put("townname", town_name);
                params.put("company", company_name);
                params.put("brandname",brand_name);
                params.put("skusize",skupack_size);
                params.put("productmrp", product_mrp);
                params.put("casesize", case_size);
                params.put("stockiestmargin",stockiest_margin);
                params.put("retailermargin", retailer_margin);
                params.put("scheme", scheme_net);
                params.put("netrateperpcs", netrateper_pcs);
                params.put("netratepercase", netrateper_case);
                params.put("remark", remark_final);

                return params;

            }
        };
        int socketTimeOut = 50000;// u can change this .. here it is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);
    }


    @Override
            public void onClick(View v) {
                if (v==submit){
                    additemtosheet();
                }

            }
}