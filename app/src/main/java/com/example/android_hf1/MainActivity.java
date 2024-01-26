package com.example.android_hf1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText n1, n2;
    private Button plus, minus, multiply, divide;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        resultText = findViewById(R.id.result);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                szamol('+');
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                szamol('-');
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                szamol('*');
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                szamol('/');
            }
        });
    }

    private void szamol(char muvelet) {
        try {
            double num1 = Double.parseDouble(n1.getText().toString());
            double num2 = Double.parseDouble(n2.getText().toString());

            Log.d("szam","n1: "+num1);
            Log.d("szam","n2: "+num2);

            double eredmeny = 0;

            switch (muvelet) {
                case '+':
                    eredmeny = num1 + num2;
                    break;
                case '-':
                    eredmeny = num1 - num2;
                    break;
                case '*':
                    eredmeny = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        eredmeny = num1 / num2;
                    } else {
                        resultText.setText("CAnnot divide by zero");
                    }
                    break;
            }

            resultText.setText("= " + eredmeny);
        } catch (NumberFormatException e) {
            resultText.setText("Invalid number format");
        }
    }
}