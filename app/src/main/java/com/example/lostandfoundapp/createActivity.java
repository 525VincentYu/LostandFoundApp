package com.example.lostandfoundapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class createActivity extends AppCompatActivity {
    EditText name, phone, description, date, location;
    Button save;
    RadioButton lost, found;
    String item;
    Database DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DB = new Database(this);
        setContentView(R.layout.activity_create);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        description = findViewById(R.id.discription);
        date = findViewById(R.id.date);
        location = findViewById(R.id.location);
        save = findViewById(R.id.save);
        lost = findViewById(R.id.radioButton);
        found = findViewById(R.id.radioButton2);
        lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item = lost.getText().toString();
            }
        });
        found.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item = found.getText().toString();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean insert = DB.insertData(item,name.getText().toString(),phone.getText().toString(),description.getText().toString(),date.getText().toString(),location.getText().toString());
                if(insert == true){
                    Toast.makeText(createActivity.this, "data saved", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(createActivity.this, "Data notsaved", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}