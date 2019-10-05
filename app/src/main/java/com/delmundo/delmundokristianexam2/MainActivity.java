package com.delmundo.delmundokristianexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox c1, c2, c3 , c4, c5, c6 , c7, c8;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1 = findViewById(R.id.checkBox);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        c4 = findViewById(R.id.checkBox4);
        c5 = findViewById(R.id.checkBox5);
        c6 = findViewById(R.id.checkBox6);
        c7 = findViewById(R.id.checkBox7);
        c8 = findViewById(R.id.checkBox8);
        e1 = findViewById(R.id.editText);
        setTitle("Activity Registration");
    }

    public void WriteData(View v){
        String ck = "";
        if(c1.isChecked()){
            ck = ck + "" + c1.getText().toString();
        }
        if(c2.isChecked()){
            ck = ck + "," + c2.getText().toString();
        }
        if(c3.isChecked()){
            ck = ck + "," + c3.getText().toString();
        }
        if(c4.isChecked()){
            ck = ck + "," + c4.getText().toString();
        }
        if(c5.isChecked()){
            ck = ck + "," + c5.getText().toString();
        }
        if(c6.isChecked()){
            ck = ck + "," + c6.getText().toString();
        }
        if(c7.isChecked()){
            ck = ck + "," + c7.getText().toString();
        }
        if(c8.isChecked()){
            ck = ck + "," + c8.getText().toString();

        }
        String comment =  e1.getText().toString();

        FileOutputStream writer = null;
        FileOutputStream writer1 = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer1 = openFileOutput("data2.txt", MODE_PRIVATE);
            writer.write(ck.getBytes());
            writer1.write(comment.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("error","no file fool");
        }
        finally {
            try {
                writer.close();
            }
            catch (IOException e) {
                Log.d("error","no file boi");
            }
        }

        Toast.makeText(this,"Data Saved....",Toast.LENGTH_LONG).show();
    }

    public void next(View v){
        Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(intent);

    }


}
