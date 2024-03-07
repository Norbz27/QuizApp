package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {
    TextView res1, res2;
    Button btnTry;
    ImageButton btnHome;
    int cat = QuizActivity.catid2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        res1 = (TextView) findViewById(R.id.res1);
        res2 = (TextView) findViewById(R.id.res2);
        btnTry = (Button) findViewById(R.id.tryA);
        btnHome = (ImageButton) findViewById(R.id.btnhome);

        res1.setText(Integer.toString(QuizActivity.score) + " out of 10 Questions");
        res2.setText(Integer.toString(QuizActivity.score * 100/10));

        btnTry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizActivity.catid2 = cat;
                QuizActivity.score = 0;
                Intent i = new Intent(ResultActivity.this, QuizActivity.class);
                startActivity(i);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizActivity.score = 0;
                Intent i = new Intent(ResultActivity.this, CategoryActivity.class);
                startActivity(i);
            }
        });

    }
}
