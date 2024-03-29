package com.example.kawaiioperations;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class HighScore extends AppCompatActivity {

    TextView tv_score;
    Button btn_backmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        Intent intent = getIntent();
        Integer score = intent.getIntExtra("score",0);

        tv_score = findViewById(R.id.tv_points);
        tv_score.setText(score.toString());
        btn_backmenu = findViewById(R.id.btn_backtomenugameover);
        btn_backmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBackMenu = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentBackMenu);
            }
        });
    }

    @Override
    public void onBackPressed(){
        Intent intentBack = new Intent(getApplicationContext(), MultChoose.class);
        startActivity(intentBack);
    }


}