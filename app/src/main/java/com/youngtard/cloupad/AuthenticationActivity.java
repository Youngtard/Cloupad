package com.youngtard.cloupad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class AuthenticationActivity extends AppCompatActivity {
    Button signUp;
    Button testApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);


        testApp = findViewById(R.id.btn_test);
//        signUp = findViewById(R.id.btn_sign_up_with_google);
//
//        signUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(AuthenticationActivity.this, SignUpActivity.class);
//                startActivity(intent);
//            }
//        });
        testApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(AuthenticationActivity.this, TimelineActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
