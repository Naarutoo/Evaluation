package com.example.evaluation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {
    private TextView mtvEmail, mtvPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mtvEmail = findViewById(R.id.tvEmail);
        mtvPassword = findViewById(R.id.tvPassword);
        String Email = PreferenceHelper.getStringFromPreference(HomeScreen.this, "Email");
        mtvEmail.setText(Email);
        String password = PreferenceHelper.getStringFromPreference(HomeScreen.this, "password");
        mtvPassword.setText(password);
    }
}