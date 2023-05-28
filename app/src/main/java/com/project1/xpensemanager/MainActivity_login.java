package com.project1.xpensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity_login extends AppCompatActivity {

    LinearLayout signin, signpage , loginpage ;
    Button signinbtn, loginbtn ;
    TextView text ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        signin = findViewById(R.id.signin);
        signpage = findViewById(R.id.signinpage);
        loginpage = findViewById(R.id.loginpage);
        signinbtn = findViewById(R.id.signinbtn);
        loginbtn = findViewById(R.id.loginbtn);
        text = findViewById(R.id.textlogin) ;

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_login.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signpage.setVisibility(View.GONE);
                loginpage.setVisibility(View.VISIBLE);
                text.setText("Login");
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginpage.setVisibility(View.GONE);
                signpage.setVisibility(View.VISIBLE);
                text.setText("Sign in");
            }
        });
    }
}