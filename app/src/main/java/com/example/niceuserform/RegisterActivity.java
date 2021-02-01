package com.example.niceuserform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputEditText username, password, rpassword, mail;
    TextInputLayout uLayout, pLayout, rpLayout, mLayout;
    MaterialButton logInButton, registerButton;
    CheckBox checkBox;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.register_username_edit_text);
        password = findViewById(R.id.register_password_edit_text);
        rpassword = findViewById(R.id.register_repeat_password_edit_text);
        mail = findViewById(R.id.email_edit_text);
        checkBox = findViewById(R.id.checbox);
        linearLayout = findViewById(R.id.linearLayout);

        uLayout = findViewById(R.id.register_username_layout);
        pLayout = findViewById(R.id.register_password_layout);
        rpLayout = findViewById(R.id.register_repeat_password_layout);
        mLayout = findViewById(R.id.email_layout);

        logInButton = findViewById(R.id.register_logButton);
        registerButton = findViewById(R.id.register_registerButton);

        linearLayout.setOnClickListener(this);
        registerButton.setOnClickListener(this);
        logInButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_registerButton:
                if (username.getText().toString().isEmpty()||password.getText().toString().isEmpty()||mail.getText().toString().isEmpty()||!checkBox.isChecked()){
                    if (username.getText().toString().isEmpty()){
                        uLayout.setError("RequiredField");
                    }else uLayout.setErrorEnabled(false);
                    if (password.getText().toString().isEmpty()){
                        pLayout.setError("Required Field");
                    }else  pLayout.setErrorEnabled(false);
                    if (mail.getText().toString().isEmpty()){
                        mLayout.setError("Required Field");
                    }else mLayout.setErrorEnabled(false);
                    if (!checkBox.isChecked()){
                        Toast.makeText(RegisterActivity.this,"You must acept the Terms to continue",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Intent intent = new Intent(RegisterActivity.this,WellcomeActivity.class);
                    intent.putExtra("Username",username.getText().toString());
                    startActivity(intent);
                }
                break;
            case R.id.register_logButton:
                Intent intent = new Intent(RegisterActivity.this,LogInActivity.class);
                startActivity(intent);

            default:
                uLayout.setErrorEnabled(false);
                pLayout.setErrorEnabled(false);
                rpLayout.setErrorEnabled(false);
                mLayout.setErrorEnabled(false);
                break;
        }
    }
}