package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {


    private Double first, second, summ;
    private TextView screen;
    private MaterialButton go_button;
    private Boolean isOperationClick;
    private String operation;

    public void filling(String number) {
        if (screen.getText().toString().equals("0") || isOperationClick) {
            screen.setText(number);
        } else {
            screen.append(number);
        }
    }
    private void  buttonVisibility(Boolean isEqualClick){
        if (isEqualClick){
            go_button.setVisibility(View.VISIBLE);
        }else {
            go_button.setVisibility(View.INVISIBLE);
        }
    }
    public void operationChoiсe(String choiсeOperation){
        buttonVisibility(false);
        first = Double.valueOf(screen.getText().toString());
        operation = choiсeOperation;
    }

    public void screenClear(){
        screen.setText("0");
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.tv_screen);
        go_button = findViewById(R.id.bt_go);


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
        buttonVisibility(false);
        isOperationClick = false;
    }

    @SuppressLint({"NonConstantResourceId",})
    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.bt_plus:
                operationChoiсe("+");
                break;
            case R.id.bt_minus:
                operationChoiсe("-");
                break;
            case R.id.bt_multiplication:
                operationChoiсe("*");
                break;
            case R.id.bt_division:
                operationChoiсe("/");
                break;
            case R.id.percent:
                operationChoiсe("%");
                break;
            case R.id.plus_minus:
                operationChoiсe("+/-");
                break;
            case R.id.bt_clear:
                buttonVisibility(false);
                screenClear();
                break;
            case R.id.bt_equals:
                summa();
        }
    isOperationClick = true;
    }

    @SuppressLint("SetTextI18n")
    public void summa(){
        buttonVisibility(true);
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
                    screen.setText("-"+ screen);
                    break;
                default:
                    summ = 0.0;
                    break;
            }
            screen.setText(String.valueOf(summ));
            go();
        }
    }
    public void go() {
        go_button.setOnClickListener(v -> {
            String res = screen.getText().toString();
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("key", res);
            startActivity(intent);
        });
    }
}
