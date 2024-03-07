package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {
    ImageButton btnPH, btnCL, btnSg;
    public static int catID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        btnPH = (ImageButton) findViewById(R.id.imageButton);
        btnCL = (ImageButton) findViewById(R.id.imageButton4);
        btnSg = (ImageButton) findViewById(R.id.imageButton5);

        btnPH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catID = 1;
                Intent i = new Intent(CategoryActivity.this, QuizActivity.class);
                startActivity(i);
            }
        });
        btnCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catID = 2;
                Intent i = new Intent(CategoryActivity.this, QuizActivity.class);
                startActivity(i);
            }
        });
        btnSg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catID = 3;
                Intent i = new Intent(CategoryActivity.this, QuizActivity.class);
                startActivity(i);
            }
        });
    }
}
