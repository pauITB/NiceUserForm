package com.example.niceuserform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WellcomeActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        textView = findViewById(R.id.hello_text_view);
        Bundle bundle = getIntent().getExtras();
        if (!bundle.isEmpty()){

            textView.setText("Hello "+bundle.getString("Username"));
        }
    }
}