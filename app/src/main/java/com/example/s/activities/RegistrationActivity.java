package com.example.s.activities;

import static com.example.s.R.id.button;

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

public class RegistrationActivity<RegisterActivity, RegisterationActivity> extends AppCompatActivity {

    Button btnRegister;
    EditText text_name,text_mail, text_password;
    TextView Already_registered, signIn,register, myFrtBasket;
    ImageView img1;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

       btnRegister = findViewById(R.id.button);
       text_mail = findViewById(R.id.text3);
       text_name = findViewById(R.id.text1);
       text_password = findViewById(R.id.editText);
       Already_registered = findViewById(R.id.textView7);
       signIn = findViewById(R.id.textview8);
       register = findViewById(R.id.textView6);
       myFrtBasket = findViewById(R.id.textView4);
       img1 = findViewById(R.id.imageView3);


        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(view ->{
            createUser();
        });

        signIn.setOnClickListener(view ->{
            startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
        });



    }

    private void createUser() {
        String email = text_mail.getText().toString();
        String password = text_password.getText().toString();

        if(TextUtils.isEmpty(email)){
            text_mail.setError("Please Enter Email");
            text_mail.requestFocus();
        }
        else if(TextUtils.isEmpty(password)){
            text_password.setError("Please Enter Password");
            text_password.requestFocus();
        }
        else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegistrationActivity.this,"User Registered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                    }
                    else{
                        Toast.makeText(RegistrationActivity.this,"Registration Error : " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    public void Login(View view) {
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
    }

    public void mainActivity(View view) {
        startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
    }
}