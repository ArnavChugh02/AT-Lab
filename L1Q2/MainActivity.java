package com.example.l1_q2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et1 = findViewById(R.id.editTextText);
        EditText et2 = findViewById(R.id.editTextText2);
        EditText et3 = findViewById(R.id.editTextText3);
        EditText et4 = findViewById(R.id.editTextText4);
        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et1.getText().toString().trim();
                String mail = et2.getText().toString().trim();
                String num = et3.getText().toString().trim();
                String pass = et4.getText().toString().trim();


                if(name.isEmpty() || mail.isEmpty() || num.isEmpty() || pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                    Toast.makeText(MainActivity.this, "Enter correct mail id", Toast.LENGTH_SHORT).show();
                }
                else if(!num.matches("^[0-9]{10}$")){
                    Toast.makeText(MainActivity.this, "Enter correct phone number", Toast.LENGTH_SHORT).show();
                }
                else{
                    String finalstring = "Name: "+name+"\n"+"Mail: "+mail+"\n"+"Phone: "+num+"\n"+"Password: "+pass;
                    Toast.makeText(MainActivity.this, "Welcome "+name , Toast.LENGTH_LONG).show();
                    new AlertDialog.Builder(MainActivity.this).setTitle("Registered").setMessage(finalstring).show();
                }
            }
        });
    }
}