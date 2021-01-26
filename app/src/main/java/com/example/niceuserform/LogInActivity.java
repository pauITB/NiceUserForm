package com.example.niceuserform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText usernameEditText, passwordEditText;
    MaterialButton logInButton, registerButton;
    TextInputLayout textInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        usernameEditText = findViewById(R.id.logIn_username_edit_text);
        passwordEditText = findViewById(R.id.logIn_password_edit_text);
        logInButton = findViewById(R.id.logIn_logButton);
        registerButton = findViewById(R.id.logIn_registerButton);

        textInputLayout = findViewById(R.id.login_username_layout);
        logInButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.logIn_logButton:
                if (usernameEditText.getText().toString().length()==0){
                    textInputLayout.setError("Required field");
                    break;
                }
                intent = new Intent(LogInActivity.this,WellcomeActivity.class);
                intent.putExtra("Username",usernameEditText.getText().toString());
                startActivity(intent);

                break;
            case R.id.logIn_registerButton:
                intent = new Intent(LogInActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}