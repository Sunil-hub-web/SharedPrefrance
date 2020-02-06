package com.example.sharedprefrance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.sharedprefrance.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);

        binding.movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Welcome.class);
                startActivity(intent);
            }
        });

        binding.store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("details",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name",binding.name.getText().toString().trim());
                editor.putString("phone",binding.phone.getText().toString().trim());
                editor.putString("email",binding.email.getText().toString().trim());
                editor.commit();

                binding.name.setText("");
                binding.email.setText("");
                binding.phone.setText("");
            }
        });
    }
}
