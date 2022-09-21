package com.example.s.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.s.MainActivity;
import com.example.s.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button btnSignIn;
    EditText etPassword, etEmail;
    TextView tvMyFrtBasket, tvSignIn, tvDntHvAccount, tvRegister;
    ImageView imgview2;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignIn = findViewById(R.id.button);
        imgview2 = findViewById(R.id.imageView3);
        tvMyFrtBasket = findViewById(R.id.textView4);
        tvSignIn = findViewById(R.id.textView6);
        tvDntHvAccount = findViewById(R.id.textView7);
        tvRegister = findViewById(R.id.textView8);
        etPassword = findViewById(R.id.editText);
        etEmail = findViewById(R.id.editText5);

        mAuth = FirebaseAuth.getInstance();

        btnSignIn.setOnClickListener(view ->{
            loginUser();
        });

        tvRegister.setOnClickListener(view ->{
            startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
        });
    }

    private void loginUser() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            etEmail.setError("Please Enter Email");
            etEmail.requestFocus();
        }
        else if(TextUtils.isEmpty(password)){
            etPassword.setError("Please Enter Password");
            etPassword.requestFocus();
        }
        else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(LoginActivity.this,"User Logged in Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(LoginActivity.this,"Log in Error : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void Register(View view) {
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
    }

    public void mainActivity(View view) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }
}