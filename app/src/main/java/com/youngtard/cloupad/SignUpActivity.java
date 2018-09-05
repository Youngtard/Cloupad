package com.youngtard.cloupad;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Button signUp;
    private EditText emailAddressEntered;
    private EditText passwordEntered;
    private String emailAddress;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().setTitle("Create an Account");

        signUp = findViewById(R.id.btn_sign_up);
        emailAddressEntered = findViewById(R.id.et_email_address_entered);
        passwordEntered = findViewById(R.id.et_password_entered);
        mAuth = FirebaseAuth.getInstance();





    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();



        //I can put it inside onClick or define then in arguments holder
        //Handle valid and invalid inputs
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailAddress = emailAddressEntered.getText().toString();
                password = passwordEntered.getText().toString();
                createUser(emailAddress, password);

            }
        });
    }

    private void createUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Success", Toast.LENGTH_LONG).show();



                        } else {

                            Toast.makeText(SignUpActivity.this, "Failed", Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }
}
