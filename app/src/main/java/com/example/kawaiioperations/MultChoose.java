package com.example.kawaiioperations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MultChoose extends AppCompatActivity {

    private Button btn_two;
    private CheckBox cbx1, cbx2,cbx3, cbx4, cbx5, cbx6, cbx7, cbx8, cbx9;
    ArrayList<Integer> numValuesFamily = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mult_choose);

        btn_two = findViewById(R.id.btn_twomult);
        cbx1 = findViewById(R.id.cbx_n1);
        cbx2 = findViewById(R.id.cbx_n2);
        cbx3 = findViewById(R.id.cbx_n3);
        cbx4 = findViewById(R.id.cbx_n4);
        cbx5 = findViewById(R.id.cbx_n5);
        cbx6 = findViewById(R.id.cbx_n6);
        cbx7 = findViewById(R.id.cbx_n7);
        cbx8 = findViewById(R.id.cbx_n8);
        cbx9 = findViewById(R.id.cbx_n9);

        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTrivia = new Intent(getApplicationContext(), OperationsTriviaMult.class);
                //numValuesFamily.add(8);
                numValuesFamily = checkBoxValidation();

                if(numValuesFamily.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please, select at least a number", Toast.LENGTH_SHORT).show();
                }else{
                intentTrivia.putExtra("numFamily", numValuesFamily);
                startActivity(intentTrivia);
                }
            }
        });
    }

    public ArrayList<Integer> checkBoxValidation(){
        ArrayList<Integer> array = new ArrayList<Integer>();
        if (cbx1.isChecked()){
            array.add(1);
        }
        if (cbx2.isChecked()){
            array.add(2);
        }
        if (cbx3.isChecked()){
            array.add(3);
        }
        if (cbx4.isChecked()){
            array.add(4);
        }
        if (cbx5.isChecked()){
            array.add(5);
        }
        if (cbx6.isChecked()){
            array.add(6);
        }
        if (cbx7.isChecked()){
            array.add(7);
        }
        if (cbx8.isChecked()){
            array.add(8);
        }
        if (cbx9.isChecked()){
            array.add(9);
        }
        return (array);
    }

    @Override
    public void onBackPressed(){
        Intent intentBack = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intentBack);
    }
}