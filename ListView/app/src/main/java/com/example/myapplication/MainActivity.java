package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    ArrayList<String> arrayNames=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);

        arrayNames.add("Ram");
        arrayNames.add("Shyam");
        arrayNames.add("Ravi");
        arrayNames.add("Rajan");
        arrayNames.add("Ram");
        arrayNames.add("Shyam");
        arrayNames.add("Ravi");
        arrayNames.add("Rajan");
        arrayNames.add("Ram");
        arrayNames.add("Shyam");
        arrayNames.add("Ravi");
        arrayNames.add("Rajan");
        arrayNames.add("Ram");
        arrayNames.add("Shyam");
        arrayNames.add("Ravi");
        arrayNames.add("Rajan");
        arrayNames.add("Ram");
        arrayNames.add("Shyam");
        arrayNames.add("Ravi");
        arrayNames.add("Rajan");

        // we have list view and data , but now how to set data in list view
        // its set by adapter
        // array index start from zero

        // constructor
        // get ApplicationContext mean kahan se call ho raha hai you can write MainActivity.this
        // Second is Layout kahan call hona hai View
        // Third one is Data
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayNames);
        // we have set adapter here but isko kahan dikahana hai
        listView.setAdapter(arrayAdapter);

        // how to set operation on click of any item
        // we have to set click on list item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // position of an item indexing
            // kitne time par click hua long
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0){
                    Toast.makeText(MainActivity.this,"First Item",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}