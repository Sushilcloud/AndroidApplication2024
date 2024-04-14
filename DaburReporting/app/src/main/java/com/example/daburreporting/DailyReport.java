package com.example.daburreporting;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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

public class DailyReport extends AppCompatActivity implements View.OnClickListener {

    EditText ssmname, beatname, town,totalvalue,totalorder,totallines, realltr, real200ml, activefiberltr,
            coconutwater200ml, coconuttetra, milkshake, realmini, realdrinkkhoolerz, realpet250ml, realpet600ml,
             imlisauce, hommadechutneys,
            pickle, koolerpet250ml, koolerpet600ml, koolerpet1200ml,koolerpet2ltr,aloepetltr,aloepet250ml,fizz,
            magicmasala,gingergarlic25gm,gingergarlic100,gingergarlic200,tomotopuree,rgp,

    coconutwater200mleco,coconutwatertetraeco,milkshakeeco,realminieco,realdrinkkoolerzeco,pet250mleco,pet600mleco,
    imlieco,chutneyeco,pickleeco,koolerpet250mleco,koolerpet600mleco,koolerpet1200mleco,koolerpet2ltreco,aloepetltreco,
            aloepet250mleco,fizzeco,magicmasalaeco,gingergarlic25eco,
    gingergarlic100eco,gingergarlic200eco,tomotopureeeco,rgpeco,remark;

    Button buttonAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_report);

        ssmname = findViewById(R.id.name);
        town = findViewById(R.id.town);
        beatname = findViewById(R.id.beatname);
        totalvalue=findViewById(R.id.totalval);
        totalorder=findViewById(R.id.totalorder);
        totallines=findViewById(R.id.totallines);
        realltr = findViewById(R.id.realltr);
        real200ml = findViewById(R.id.real200ml);
        activefiberltr = findViewById(R.id.realactivefiberltr);
        coconutwater200ml = findViewById(R.id.coconutwater200ml);
        coconuttetra = findViewById(R.id.coconutwatertetra);
        milkshake = findViewById(R.id.milkshake);
        realmini = findViewById(R.id.realmini);
        realdrinkkhoolerz = findViewById(R.id.realdrinkkooolerz);
        realpet250ml = findViewById(R.id.pet250ml);
        realpet600ml = findViewById(R.id.pet600ml);

        imlisauce = findViewById(R.id.imli);
        hommadechutneys = findViewById(R.id.chutney);
        pickle = findViewById(R.id.pickle);
        koolerpet250ml = findViewById(R.id.KoolerzPet250ml);
        koolerpet600ml = findViewById(R.id.KoolerzPet600ml);
        koolerpet1200ml = findViewById(R.id.KoolerzPet1200ml);
        koolerpet2ltr=findViewById(R.id.pet2ltr);

        aloepetltr=findViewById(R.id.apetltr);
        aloepet250ml=findViewById(R.id.apet250ml);
        fizz=findViewById(R.id.fizz);

        magicmasala = findViewById(R.id.magicmasal);
        gingergarlic25gm=findViewById(R.id.gg25gm);
        gingergarlic100=findViewById(R.id.gg100gm);
        gingergarlic200=findViewById(R.id.gg200gm);
        tomotopuree=findViewById(R.id.tomotopuree);
        rgp=findViewById(R.id.giftpack);

        coconutwater200mleco=findViewById(R.id.coconutwater200mleco);
        coconutwatertetraeco=findViewById(R.id.coconutwatertetraeco);
        milkshakeeco=findViewById(R.id.milkshakeeco);
        realminieco=findViewById(R.id.realminieco);
        realdrinkkoolerzeco=findViewById(R.id.realdrinkkooolerzeco);
        pet250mleco=findViewById(R.id.pet250mleco);
        pet600mleco=findViewById(R.id.pet600mleco);

        imlieco=findViewById(R.id.imlieco);
        chutneyeco=findViewById(R.id.chutneyeco);
        pickleeco=findViewById(R.id.pickleeco);
        koolerpet250mleco=findViewById(R.id.KoolerzPet250mleco);
        koolerpet600mleco=findViewById(R.id.KoolerzPet600mleco);
        koolerpet1200mleco=findViewById(R.id.KoolerzPet1200mleco);
        koolerpet2ltreco=findViewById(R.id.pet2leco);
        aloepetltreco=findViewById(R.id.apetltreco);
        aloepet250mleco=findViewById(R.id.apet250mleco);
        fizzeco=findViewById(R.id.fizzeco);




        magicmasalaeco=findViewById(R.id.magicmasalaeco);
        gingergarlic25eco=findViewById(R.id.gg25gmeco);
        gingergarlic100eco=findViewById(R.id.gg100gmeco);
        gingergarlic200eco=findViewById(R.id.gg200gmeco);
        tomotopureeeco=findViewById(R.id.tomotopureeeco);
        rgpeco=findViewById(R.id.giftpackeco);

        remark=findViewById(R.id.remark1);


        buttonAddItem = findViewById(R.id.add_item);
        buttonAddItem.setOnClickListener(this);
    }
    //This is the part where data is transafeered from Your Android phone to Sheet by using HTTP Rest API calls

    private void additemtosheet() {
        final ProgressDialog loading = ProgressDialog.show(this, "Adding Item", "Please wait");
        final String ssm_name = ssmname.getText().toString().trim();
        final String town_name = town.getText().toString().trim();
        final String beat_name = beatname.getText().toString().trim();
        final String total_value= totalvalue.getText().toString().trim();
        final String total_order=totalorder.getText().toString().trim();
        final String total_lines=totallines.getText().toString().trim();
        final String real_ltr = realltr.getText().toString().trim();
        final String real_200ml = real200ml.getText().toString().trim();
        final String active_fiber_ltr=activefiberltr.getText().toString().trim();
        final String coconutwater_200ml = coconutwater200ml.getText().toString().trim();
        final String coconutwater_tetra = coconuttetra.getText().toString().trim();
        final String milk_shake = milkshake.getText().toString().trim();
        final String real_mini = realmini.getText().toString().trim();
        final String drink_koolerz = realdrinkkhoolerz.getText().toString().trim();
        final String realpet_250ml = realpet250ml.getText().toString().trim();
        final String realpet_600ml = realpet600ml.getText().toString().trim();

        final String aloepet_ltr = aloepetltr.getText().toString().trim();
        final String aloepet_250ml = aloepet250ml.getText().toString().trim();
        final String fizz_qty = fizz.getText().toString().trim();



        final String imli_sauce = imlisauce.getText().toString().trim();
        final String hommade_chutney = hommadechutneys.getText().toString().trim();
        final String hommade_pickle = pickle.getText().toString().trim();
        final String koolerpet_250ml = koolerpet250ml.getText().toString().trim();
        final String koolerpet_600ml = koolerpet600ml.getText().toString().trim();
        final String koolerpet_1200ml = koolerpet1200ml.getText().toString().trim();
        final String koolerpet_2ltr=koolerpet2ltr.getText().toString().trim();
        final String magic_masala = magicmasala.getText().toString().trim();
        final String ginger_garlic25gm=gingergarlic25gm.getText().toString().trim();
        final String ginger_garlic100=gingergarlic100.getText().toString().trim();
        final String ginger_garlic200=gingergarlic200.getText().toString().trim();
        final String tomoto_puree=tomotopuree.getText().toString().trim();
        final String real_giftpack=rgp.getText().toString().trim();



        final String coconutwater200ml_eco=coconutwater200mleco.getText().toString().trim();
        final String coconutwatertetra_eco=coconutwatertetraeco.getText().toString().trim();
        final String milkshake_eco=milkshakeeco.getText().toString().trim();
        final String realmini_eco=realminieco.getText().toString().trim();
        final String realdrinkkoolerz_eco=realdrinkkoolerzeco.getText().toString().trim();
        final String pet250ml_eco=pet250mleco.getText().toString().trim();
        final String pet600ml_eco=pet600mleco.getText().toString().trim();

        final String aloepet_ltr_eco = aloepetltreco.getText().toString().trim();
        final String aloepet_250ml_eco = aloepet250mleco.getText().toString().trim();
        final String fizz_eco = fizzeco.getText().toString().trim();

        final String imli_eco=imlieco.getText().toString().trim();
        final String chutney_eco=chutneyeco.getText().toString().trim();
        final String pickle_eco=pickleeco.getText().toString().trim();
        final String koolerpet250ml_eco=koolerpet250mleco.getText().toString().trim();
        final String koolerpet600ml_eco=koolerpet600mleco.getText().toString().trim();
        final String koolerpet1200ml_eco=koolerpet1200mleco.getText().toString().trim();
        final String koolerpet2ltr_eco=koolerpet2ltreco.getText().toString().trim();
        final String magicmasala_eco=magicmasalaeco.getText().toString().trim();
        final String gg25gm_eco=gingergarlic25eco.getText().toString().trim();
        final String gg100gm_eco=gingergarlic100eco.getText().toString().trim();
        final String gg200gm_eco=gingergarlic200eco.getText().toString().trim();
        final String tomotopuree_eco=tomotopureeeco.getText().toString().trim();

        final String real_giftpack_eco=rgpeco.getText().toString().trim();
        final String remark_done=remark.getText().toString().trim();



        // Step 1 for Making Request-- http request create volley first make request queue




        // Step 2 create String Request
        // Request Type Method Post and Get Post having more securiy
        // next Parameter new Response Listener this is call when server sent something
        // Last Parameter is error listener when ever error occured
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbzVNtVtBCDPkKdbZhnIFzKSogboUjZVSSMkEQcrWCjHrGe4coLa9qYm2ence0jzboBFKA/exec", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                loading.dismiss();
                Toast.makeText(DailyReport.this, "Response"+ response, Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //For Error Message
                Toast.makeText(DailyReport.this,"Error:"+error.getMessage(),Toast.LENGTH_LONG).show();

            }
        })
             // implemented methond here get params
            // create an object of map key will be string anad value is also string
        {

            @Override
            protected Map<String, String> getParams() {
                //Remove Below Line
                // return super.getParams();
                Map<String, String> params = new HashMap<>();
                // now we will put sting on our post parameter
                params.put("action","addReport");
                params.put("ssmName", ssm_name);
                params.put("beatName", beat_name);
                params.put("town", town_name);
                params.put("totalvalue", total_value);
                params.put("totalorders",total_order);
                params.put("totallines",total_lines);
                params.put("realltr", real_ltr);
                params.put("real200ml", real_200ml);
                params.put("activefiberltr",active_fiber_ltr);
                params.put("coconutwater250ml", coconutwater_200ml);
                params.put("coconutwatertetra", coconutwater_tetra);
                params.put("milkshake", milk_shake);
                params.put("realmini", real_mini);
                params.put("drinkkoolerz", drink_koolerz);
                params.put("realpet250ml", realpet_250ml);
                params.put("realpet600ml", realpet_600ml);
                params.put("aloepetltr", aloepet_ltr);
                params.put("aloepet250ml", aloepet_250ml);
                params.put("fizz", fizz_qty);


                params.put("imlisauce", imli_sauce);
                params.put("hommadechutney", hommade_chutney);
                params.put("pickle", hommade_pickle);
                params.put("koolerpet250ml", koolerpet_250ml);
                params.put("koolerpet600ml", koolerpet_600ml);
                params.put("koolerpet1200ml", koolerpet_1200ml);
                params.put("koolerpet2ltr", koolerpet_2ltr);

                params.put("magicmasala", magic_masala);
                params.put("gingergarlic25gm",ginger_garlic25gm);
                params.put("gingergarlic100gm",ginger_garlic100);
                params.put("gingergarlic200gm",ginger_garlic200);
                params.put("tomotopuree",tomoto_puree);
                params.put("realgiftpack",real_giftpack);

                params.put("coconutwater200mleco",coconutwater200ml_eco);
                params.put("coconutwatertetraeco",coconutwatertetra_eco);
                params.put("milkshakeeco",milkshake_eco);
                params.put("realminieco",realmini_eco);
                params.put("realdrinkkoolerzeco",realdrinkkoolerz_eco);
                params.put("pet250mleco",pet250ml_eco);
                params.put("pet600mleco",pet600ml_eco);
                params.put("aloepetltreco", aloepet_ltr_eco);
                params.put("aloepet250mleco", aloepet_250ml_eco);
                params.put("fizzeco", fizz_eco);

                params.put("imlieco",imli_eco);
                params.put("chutneyeco",chutney_eco);

                params.put("pickleeco",pickle_eco);
                params.put("koolerpet250mleco",koolerpet250ml_eco);
                params.put("koolerpet600mleco",koolerpet600ml_eco);
                params.put("koolerpet1200mleco",koolerpet1200ml_eco);
                params.put("koolerpet2ltreco", koolerpet2ltr_eco);
                params.put("magicmasalaeco",magicmasala_eco);
                params.put("gingergarlic25gmeco",gg25gm_eco);
                params.put("gingergarlic100gmeco",gg100gm_eco);
                params.put("gingergarlic200gmeco",gg200gm_eco);
                params.put("tomotopureeeco",tomotopuree_eco);

                params.put("realgiftpackeco",real_giftpack_eco);
                params.put("remark",remark_done);

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
    if(v==buttonAddItem){
        additemtosheet();

    }

    }


}