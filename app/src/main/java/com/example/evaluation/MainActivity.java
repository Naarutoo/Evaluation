package com.example.evaluation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText metEmail, metPassword;
    private CheckBox mcbRemember;
    private Button mbtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        boolean value = PreferenceHelper.getBooleanFromPreference(MainActivity.this, "check");
        if (value == true) {
            Intent intent = new Intent(MainActivity.this, HomeScreen.class);
            startActivity(intent);
        } else {
            mbtnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                    PreferenceHelper.writeStringToPreference(MainActivity.this, "Email", metEmail.getText().toString());
                    PreferenceHelper.writeStringToPreference(MainActivity.this, "password", metPassword.getText().toString());
                    startActivity(intent);
                }
            });

        }
        mcbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                PreferenceHelper.writeBooleanToPreference(MainActivity.this, "check", true);
                PreferenceHelper.writeStringToPreference(MainActivity.this, "Email", metEmail.getText().toString());
                PreferenceHelper.writeStringToPreference(MainActivity.this, "password", metPassword.getText().toString());
            }
        });
    }

    private void initviews() {
        metEmail = findViewById(R.id.etEmail);
        metPassword = findViewById(R.id.etPassword);
        mcbRemember = findViewById(R.id.cbRemember);
        mbtnLogin = findViewById(R.id.btnLogin);

    }
}
