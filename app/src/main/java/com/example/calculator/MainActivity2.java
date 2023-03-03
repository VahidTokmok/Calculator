package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
public class MainActivity2 extends AppCompatActivity {
    TextView result;
    MaterialButton close;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        close = findViewById(R.id.close_btn);
        result = findViewById(R.id.result_view);
        String text = getIntent().getStringExtra("key");
        result.setText(text);

        close.setOnClickListener(v -> {
            finishAffinity();
        });


    }


}