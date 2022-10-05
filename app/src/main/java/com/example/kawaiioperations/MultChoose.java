package com.example.kawaiioperations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MultChoose extends AppCompatActivity {

    private Button btn_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mult_choose);

        btn_two = findViewById(R.id.btn_twomult);
        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OperationsTriviaMult.class);
                startActivity(intent);
            }
        });
    }
}