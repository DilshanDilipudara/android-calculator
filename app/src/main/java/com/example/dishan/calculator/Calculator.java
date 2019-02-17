package com.example.dishan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {
     EditText idEditText;
     Button  btnPl,btnSu,btnMu,btnDi,btnEq;
     double x  = 0.0;
     double y = 1.0;
     int clicked_btn = 0; //for find the click the button
     // hello, world
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        //asign the variable
        idEditText = (EditText) findViewById(R.id.editTextNumer);
        btnPl = (Button) findViewById(R.id.btnPlus);
        btnSu = (Button) findViewById(R.id.btnSub);
        btnMu = (Button) findViewById(R.id.btnMul);
        btnDi = (Button) findViewById(R.id.btnDiv);
        btnEq = (Button) findViewById(R.id.btnequal);

        //click the eqaul button
        btnEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked_btn == 1){

                    if(!TextUtils.isEmpty(idEditText.getText().toString())){
                        double value = Double.parseDouble(idEditText.getText().toString());
                        x += value;
                        idEditText.setText(String.valueOf(x));
                        x = 0.0;
                    }
                    else{
                        idEditText.setText(String.valueOf(x));
                    }

                }
                if(clicked_btn == 2){

                    if(!TextUtils.isEmpty(idEditText.getText().toString())){
                        double value = Double.parseDouble(idEditText.getText().toString());
                        x -= value;
                        idEditText.setText(String.valueOf(x));
                        x = 0.0;
                    }
                    else{
                        idEditText.setText(String.valueOf(x));
                    }

                }
                if(clicked_btn == 3){

                    if(!TextUtils.isEmpty(idEditText.getText().toString())){
                        double value = Double.parseDouble(idEditText.getText().toString());

                                y*= value;
                        idEditText.setText(String.valueOf(y));
                        y = 1.0;
                    }
                    else{
                        idEditText.setText(String.valueOf(y));
                    }

                }

                if(clicked_btn == 4){

                    if(!TextUtils.isEmpty(idEditText.getText().toString())){
                        double value = Double.parseDouble(idEditText.getText().toString());
                        y /= value;
                        idEditText.setText(String.valueOf(y));
                        y = 1.0;
                    }
                    else{
                        idEditText.setText(String.valueOf(y));
                    }

                }

            }
        });
        //click the + button
        btnPl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(idEditText.getText().toString())){ //find edit text is non empty
                    cal("+",idEditText.getText().toString());  // send the 2  string value

                }
                else {
                    Toast.makeText(Calculator.this, "No empty number allowed", Toast.LENGTH_SHORT).show();
                }

            }
        });

         btnSu.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(!TextUtils.isEmpty(idEditText.getText().toString())){ //find edit text is non empty
                     cal("-",idEditText.getText().toString());  // send the 2  string value

                 }
                 else {
                     Toast.makeText(Calculator.this, "No empty number allowed", Toast.LENGTH_SHORT).show();
                 }

             }
         });

         btnMu.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(!TextUtils.isEmpty(idEditText.getText().toString())){ //find edit text is non empty
                     cal("*",idEditText.getText().toString());  // send the 2  string value

                 }
                 else {
                     Toast.makeText(Calculator.this, "No empty number allowed", Toast.LENGTH_SHORT).show();
                 }

             }
         });

         btnDi.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(!TextUtils.isEmpty(idEditText.getText().toString())){ //find edit text is non empty
                     cal("/",idEditText.getText().toString());  // send the 2  string value

                 }
                 else {
                     Toast.makeText(Calculator.this, "No empty number allowed", Toast.LENGTH_SHORT).show();
                 }

             }
         });
    }

    public void cal(String type,String number){
        if(type.equals("+")){

            clicked_btn = 1;
            double num = Double.parseDouble(number);
            x += num;
           Toast.makeText(Calculator.this,String.valueOf(x),Toast.LENGTH_SHORT).show();
           idEditText.setText(""); //get next value in edit text
        }
        if(type.equals("-")){

            clicked_btn = 2;
            double num = Double.parseDouble(number);

             if(x==0){
               x =num;
             }
             else {
                 x -= num;
             }
            Toast.makeText(Calculator.this,String.valueOf(x),Toast.LENGTH_SHORT).show();
            idEditText.setText(""); //get next value in edit text
        }

        if(type.equals("*")){

            clicked_btn = 3;
            double num = Double.parseDouble(number);
            y *= num;
            Toast.makeText(Calculator.this,String.valueOf(y),Toast.LENGTH_SHORT).show();
            idEditText.setText(""); //get next value in edit text
        }

        if(type.equals("/")){

            clicked_btn = 4;
            double num = Double.parseDouble(number);
            if(y==1){
                y = num;
            }
            else {
                y /= num;
            }

            Toast.makeText(Calculator.this,String.valueOf(y),Toast.LENGTH_SHORT).show();
            idEditText.setText(""); //get next value in edit text
        }

    }
}
