package com.priscilla.budgetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textview.MaterialTextView;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        AppCompatButton loginbtn = findViewById(R.id.loginbtn);
        MaterialTextView textInputEditText = findViewById(R.id.inputtextedit);
        MaterialTextView textInputPassword = findViewById(R.id.textInputPassword);
        TextView forgotPassword = findViewById(R.id.textViewforgotpassword);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = textInputEditText.getText().toString();
                String password = textInputPassword.getText().toString();

                if (email.isEmpty()){
                    textInputEditText.setError("Enter valid email");
                    textInputPassword.setError("Enter valid password");
                }
            }
        });

////        forgotPassword.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
//
//
//            }
//        });

    }


}