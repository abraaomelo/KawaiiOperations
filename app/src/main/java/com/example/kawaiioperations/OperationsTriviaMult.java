package com.example.kawaiioperations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class OperationsTriviaMult extends AppCompatActivity {
    private TextView tv_factor1, tv_factor2, tv_score;
    private Integer factor1, factor2, result;
    private String resultEDT;
    private Button btnResultgo;
    private EditText etResult;
    Random randomNum = new Random();
    private Integer hearts=3, score=0,counter = 0;
    private ImageView h1,h2,h3;
    ProgressBar pb;
    //int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations_trivia_mult);

        Intent intent = getIntent();
        ArrayList<Integer> arrayF11 = intent.getIntegerArrayListExtra("numFamily");
        tv_factor1 = findViewById(R.id.tv_factor1);
        tv_factor2 = findViewById(R.id.tv_factor2);
        tv_score = findViewById(R.id.tv_score);
        h1 = findViewById(R.id.heart1);
        h2 = findViewById(R.id.heart2);
        h3 = findViewById(R.id.heart3);

        int numF1 = RandArray(arrayF11);
        tv_score.setText("0");

        factor1 = numF1;
        factor2 = randomNum.nextInt(10);
        result = factor1*factor2;

        tv_factor1.setText(factor1.toString());

        tv_factor2.setText(factor2.toString());

        etResult = findViewById(R.id.et_result);
        etResult.requestFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        btnResultgo = findViewById(R.id.btn_resultgo);

            btnResultgo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String edittext = etResult.getText().toString();

                    if (TextUtils.isEmpty(edittext)) {
                        etResult.setError("No Empty >.<'");
                        return;

                    } else {

                        resultEDT = etResult.getText().toString();

                        if (Integer.parseInt(resultEDT) == result) {
                            //  CORRECT ANSW =================================================================
                            Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                            score = score+10;
                            tv_score.setText(score.toString());
                            factor1 = RandArray(arrayF11);
                            factor2 = randomNum.nextInt(10);
                            result = factor1 * factor2;

                            tv_factor1.setText(factor1.toString());
                            tv_factor2.setText(factor2.toString());
                            etResult.getText().clear();


                        } else {
                            //  WRONG ANSW ====================================================================
                            hearts=hearts-1;
                            if (NoHearts(hearts)){
                                EndGame(score);
                            }else{

                                Toast.makeText(getApplicationContext(), "Try again", Toast.LENGTH_SHORT).show();
                                factor1 = RandArray(arrayF11);
                                factor2 = randomNum.nextInt(10);
                                result = factor1 * factor2;

                                tv_factor1.setText(factor1.toString());
                                tv_factor2.setText(factor2.toString());
                                etResult.getText().clear();
                            }
                            if (hearts==2){
                                h3.setVisibility(View.INVISIBLE);
                            }else if (hearts==1){
                                h2.setVisibility(View.INVISIBLE);
                            }

                        }

                    }
                } //END onClick
            }); //END SET ON CLICK LISTENER
        }


    public Integer RandArray(ArrayList<Integer> array){
        int rnd = new Random().nextInt(array.toArray().length);
        //Toast.makeText(this,""+array.size(),Toast.LENGTH_SHORT).show();
        return array.get(rnd);
    }

    public boolean NoHearts(int life_heart) {
        boolean resultcheck=false;
        if (life_heart == 0) {
            resultcheck = true;
        }
        return resultcheck;
    }
    public void EndGame(Integer score){
        Intent i = new Intent(getApplicationContext(), HighScore.class);
        i.putExtra("score", score);
        startActivity(i);

    }

    public void prog(){
        pb = findViewById(R.id.pb);

        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter= counter+5;
                pb.setProgress(counter);

                if (counter == 100)
                    t.cancel();
            }
        };
        t.schedule(tt,0,100);
    }

}