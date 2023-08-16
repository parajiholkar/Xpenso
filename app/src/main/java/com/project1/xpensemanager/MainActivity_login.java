package com.project1.xpensemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class MainActivity_login extends AppCompatActivity {

    LinearLayout goTosignin,goTologin, signpage , loginpage ;
    Button signinbtn, loginbtn ;
    TextView text ;
    EditText emll,pwl,emls,pws,userN ;
    ProgressBar progressBar ;
    private FirebaseAuth mAuth;

//    @Override
//    public void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            Intent intent = new Intent(MainActivity_login.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        }
//    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        goTosignin = findViewById(R.id.goToSignin);
        goTologin = findViewById(R.id.goTologin);
        signpage = findViewById(R.id.signinpage);
        loginpage = findViewById(R.id.loginpage);
        signinbtn = findViewById(R.id.signinbtn);
        loginbtn = findViewById(R.id.loginbtn);
        emll = findViewById(R.id.loginemail);
        pwl = findViewById(R.id.loginpassword);
        emls = findViewById(R.id.signinemail);
        pws = findViewById(R.id.signinpassword);
        userN = findViewById(R.id.username);
        text = findViewById(R.id.textlogin) ;
        progressBar = findViewById(R.id.progress_bar);
        mAuth = FirebaseAuth.getInstance();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String email = emll.getText().toString();
                String password = pwl.getText().toString();

                if (!Objects.equals(email, "")) {
                    if (!password.equals("")) {
                        mAuth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        progressBar.setVisibility(View.GONE);
                                        if (task.isSuccessful()) {
                                            emll.getText().clear();
                                            pwl.getText().clear();
                                            FirebaseUser user = mAuth.getCurrentUser();
                                            Intent intent = new Intent(MainActivity_login.this, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(MainActivity_login.this, "Authentication failed, Internet Connection Needed",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                    }
                    else {
                        Toast.makeText(MainActivity_login.this, "Please Enter Password!", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }
                else {
                    Toast.makeText(MainActivity_login.this, "Please Enter Email!", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String username = userN.getText().toString();
                String email = emls.getText().toString();
                String password = pws.getText().toString();

                if(!Objects.equals(username, "")) {
                    if (!Objects.equals(email, "")) {
                        if (!password.equals("")) {

                            mAuth.createUserWithEmailAndPassword(email, password)
                                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            progressBar.setVisibility(View.GONE);
                                            if (task.isSuccessful()) {
                                                userN.getText().clear();
                                                emll.getText().clear();
                                                pwl.getText().clear();
                                                FirebaseUser user = mAuth.getCurrentUser();
                                                signpage.setVisibility(View.GONE);
                                                loginpage.setVisibility(View.VISIBLE);
                                                text.setText("Login");
                                                Toast.makeText(MainActivity_login.this, "Signin Successful!",
                                                        Toast.LENGTH_SHORT).show();
                                            } else {
                                                Toast.makeText(MainActivity_login.this, "Authentication failed.",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });

                        } else {
                            Toast.makeText(MainActivity_login.this, "Please Enter Password!", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    } else {
                        Toast.makeText(MainActivity_login.this, "Please Enter Email!", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }

                } else {
                    Toast.makeText(MainActivity_login.this, "Please Enter Username!", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }

            }
        });

        goTosignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginpage.setVisibility(View.GONE);
                signpage.setVisibility(View.VISIBLE);
                text.setText("Sign in");
            }
        });
        goTologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginpage.setVisibility(View.VISIBLE);
                signpage.setVisibility(View.GONE);
                text.setText("Login");
            }
        });
    }
}