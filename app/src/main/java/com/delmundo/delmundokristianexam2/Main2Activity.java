package com.delmundo.delmundokristianexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    EditText e1, e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        e1 = findViewById(R.id.editText3);
        e2 = findViewById(R.id.editText4);
        setTitle("Confirmation");
        FileInputStream reader = null;
        FileInputStream reader1 = null;
        String data = "";
        String data1 = "";
        try{
            reader = openFileInput("data1.txt");
            reader1 = openFileInput("data2.txt");

            int token;
            int token2;
            while((token = reader.read()) != -1){
                data = data + (char)token;
            }
            while((token2 = reader1.read()) != -1){
                data1 = data1 + (char)token2;
            }
        }
        catch(
                FileNotFoundException e){
            Log.d("Error","no file");
        }
        catch(IOException e){
            Log.d("Error","IO error");
        }
        String arr[] = data.split(",");
        for(int i =0;i < arr.length;i++)
        {
            e2.append("\n" + arr[i]);
        }
        e1.setText(data1);
    }

    public void send(View v){
        Toast.makeText(this,"Data Sent...",Toast.LENGTH_LONG).show();
        setTitle("Summary");
    }
    public void next(View v){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }

}

