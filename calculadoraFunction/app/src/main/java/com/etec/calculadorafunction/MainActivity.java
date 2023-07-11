package com.etec.calculadorafunction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {






        private EditText editTextNumber1, editTextNumber2;
        private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;
        private TextView textViewResult;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            editTextNumber1 = findViewById(R.id.editTextNumber1);
            editTextNumber2 = findViewById(R.id.editTextNumber2);
            buttonAdd = findViewById(R.id.buttonAdd);
            buttonSubtract = findViewById(R.id.buttonSubtract);
            buttonMultiply = findViewById(R.id.buttonMultiply);
            buttonDivide = findViewById(R.id.buttonDivide);
            textViewResult = findViewById(R.id.textViewResult);

            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateResult('+');
                }
            });

            buttonSubtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateResult('-');
                }
            });

            buttonMultiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateResult('*');
                }
            });

            buttonDivide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateResult('/');
                }
            });
        }

        private void calculateResult(char operator) {
            String number1String = editTextNumber1.getText().toString();
            String number2String = editTextNumber2.getText().toString();

            if (!number1String.isEmpty() && !number2String.isEmpty()) {
                double number1 = Double.parseDouble(number1String);
                double number2 = Double.parseDouble(number2String);

                double result = 0;

                switch (operator) {
                    case '+':
                        result = number1 + number2;
                        break;
                    case '-':
                        result = number1 - number2;
                        break;
                    case '*':
                        result = number1 * number2;
                        break;
                    case '/':
                        if (number2 != 0) {
                            result = number1 / number2;
                        } else {
                            textViewResult.setText("Divisão por zero não é permitida");
                            return;
                        }
                        break;
                }

                textViewResult.setText("Resultado: " + result);
            } else {
                textViewResult.setText("Insira ambos os números");
            }
        }
    }