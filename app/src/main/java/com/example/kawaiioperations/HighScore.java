package com.example.kawaiioperations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class HighScore extends AppCompatActivity {

    TextView tv_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        Intent intent = getIntent();
        Integer score = intent.getIntExtra("score",0);

        tv_score = findViewById(R.id.tv_points);
        tv_score.setText(score.toString());
    }
}