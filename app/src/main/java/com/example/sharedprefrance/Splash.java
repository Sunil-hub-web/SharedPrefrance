package com.example.sharedprefrance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp = getSharedPreferences("details",MODE_PRIVATE);
                String s1=sp.getString("name",null);
                String s2=sp.getString("phone",null);
                String s3=sp.getString("email",null);

                if(s2==null) {
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(Splash.this,Welcome.class);
                    startActivity(intent);
                    finish();
                }
            }
        },5000);


    }
}
