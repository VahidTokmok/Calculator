package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Double first, second, summ;
    private TextView screen;
    private Boolean isOperationClick;
    private String operation;

    public void filling(String number) {
        if (screen.getText().toString().equals("0") || isOperationClick) {
            screen.setText(number);
        } else {
            screen.append(number);
        }
    }

    public void screenClear(){
        screen.setText("0");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.tv_screen);
    }

    @SuppressLint("NonConstantResourceId")
    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.bt_one:
                filling("1");
                break;
            case R.id.bt_two:
                filling("2");
                break;
            case R.id.bt_three:
                filling("3");
                break;
            case R.id.bt_four:
                filling("4");
                break;
            case R.id.bt_five:
                filling("5");
                break;
            case R.id.bt_six:
                filling("6");
                break;
            case R.id.bt_seven:
                filling("7");
                break;
            case R.id.bt_eight:
                filling("8");
                break;
            case R.id.bt_nine:
                filling("9");
                break;
            case R.id.bt_zero:
                filling("0");
                break;
            case R.id.bt_dot:
                filling(".");
                break;
        }
        isOperationClick = false;
    }

    @SuppressLint("NonConstantResourceId")
    public void onOperationClick(View view) {

        switch (view.getId()) {
            case R.id.bt_plus:
                first = Double.valueOf(screen.getText().toString());
                isOperationClick = true;
                operation = "+";
                break;
            case R.id.bt_minus:
                first = Double.valueOf(screen.getText().toString());
                isOperationClick = true;
                operation = "-";
                break;
            case R.id.bt_multiplication:
                first = Double.valueOf(screen.getText().toString());
                isOperationClick = true;
                operation = "*";
                break;
            case R.id.bt_division:
                first = Double.valueOf(screen.getText().toString());
                isOperationClick = true;
                operation = "/";
                break;
                case R.id.percent:
                first = Double.valueOf(screen.getText().toString());
                isOperationClick = true;
                operation = "%";
                break;
            case R.id.plus_minus:
                first = Double.valueOf(screen.getText().toString());
                isOperationClick = true;
                operation = "+/-";
                break;
            case R.id.bt_clear:
                screenClear();
                break;
            case R.id.bt_equals:
                if (isOperationClick){
                    second = Double.valueOf(screen.getText().toString());
                    switch (operation){
                        case "+":
                            summ = first + second;
                            break;
                        case "-":
                            summ = first - second;
                            break;
                        case "*":
                            summ = first * second;
                            break;
                        case "/":
                            summ = first / second;
                            break;
                        case "%":
                            summ = second / 100 * first;
                            break;
                        case "-/+":
                            screen.setText("-" + String.valueOf(screen));
                            break;
                        default:
                            summ = 0.0;
                            break;
                    }
                    screen.setText(String.valueOf(summ));
                }

        }
    isOperationClick = true;
    }
}
