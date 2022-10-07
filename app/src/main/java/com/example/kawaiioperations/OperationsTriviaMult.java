package com.example.kawaiioperations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class OperationsTriviaMult extends AppCompatActivity {
    private TextView tv_factor1, tv_factor2, tv_result;
    private Integer factor1, factor2, result;
    private String resultEDT;
    private Button btnResultgo;
    private EditText etResult;
    Random randomNum = new Random();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations_trivia_mult);

        Intent intent = getIntent();
        ArrayList<Integer> arrayF11 = intent.getIntegerArrayListExtra("numFamily");
        tv_factor1 = findViewById(R.id.tv_factor1);
        tv_factor2 = findViewById(R.id.tv_factor2);
        tv_result = findViewById(R.id.tv_result);

        int numF1 = RandArray(arrayF11);


        //int numF1 = intent.getIntExtra("numFamily",0);

        factor1 = numF1;
        factor2 = randomNum.nextInt(10);
        result = factor1*factor2;

        tv_factor1.setText(factor1.toString());

        tv_factor2.setText(factor2.toString());

//        tv_result.setText(result.toString());
//        tv_result.setVisibility(View.INVISIBLE);

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

                            Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();

                            factor1 = RandArray(arrayF11);
                            factor2 = randomNum.nextInt(10);
                            result = factor1 * factor2;

                            tv_factor1.setText(factor1.toString());
                            tv_factor2.setText(factor2.toString());
                            etResult.getText().clear();

                        } else {

                            Toast.makeText(getApplicationContext(), "Try again", Toast.LENGTH_SHORT).show();
                            //factor1 = numF1;
                            factor1 = RandArray(arrayF11);
                            factor2 = randomNum.nextInt(10);
                            result = factor1 * factor2;

                            tv_factor1.setText(factor1.toString());
                            tv_factor2.setText(factor2.toString());
                            etResult.getText().clear();
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

}