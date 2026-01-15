package com.example.listycity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cityList = findViewById(R.id.city_list);

        String []cities = {"Edmonton"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        EditText city1 = findViewById(R.id.input_text);
        Button button = findViewById(R.id.button6); //add city
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cityAdapter.add(String.valueOf(city1.getText()));
                city1.setText("");

                Toast.makeText(getApplicationContext(), "text", Toast.LENGTH_SHORT).show();

            }



        });

        Button button2 = findViewById(R.id.button7); //delete city
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cityAdapter.remove(String.valueOf(city1.getText()));
                city1.setText("");

                Toast.makeText(getApplicationContext(), "text2", Toast.LENGTH_SHORT).show();

            }



        });



    }
}