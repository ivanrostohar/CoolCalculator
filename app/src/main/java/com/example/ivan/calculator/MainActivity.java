package com.example.ivan.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView txtResult;
    String currentNumber = "";
    String leftNumber, rightNumber;
    Operation currentOperation;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dohvaćeni widgeti
        Button btnOne = (Button) findViewById(R.id.btnOne);
        Button btnTwo = (Button) findViewById(R.id.btnTwo);
        Button btnThree = (Button) findViewById(R.id.btnThree);
        Button btnFour = (Button) findViewById(R.id.btnFive);
        Button btnFive = (Button) findViewById(R.id.btnFive);
        Button btnSix = (Button) findViewById(R.id.btnSix);
        Button btnSeven = (Button) findViewById(R.id.btnSeven);
        Button btnEight = (Button) findViewById(R.id.btnEight);
        Button btnNine = (Button) findViewById(R.id.btnNine);
        Button btnZero = (Button) findViewById(R.id.btnZero);
        Button btnResult = (Button) findViewById(R.id.btnResult);
        Button btnClear = (Button) findViewById(R.id.btnClearResult);

        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnPlus);
        ImageButton btnMinus = (ImageButton) findViewById(R.id.btnMinus);
        ImageButton btnMutiply = (ImageButton) findViewById(R.id.btnMultiply);
        ImageButton btnDivide = (ImageButton) findViewById(R.id.btnDivide);

        txtResult = (TextView) findViewById(R.id.txtShowOperations);

        txtResult.setText("");

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(1);

            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);

            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);

            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);

            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);

            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);

            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);

            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);

            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);

            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.ADD);

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.SUBTRACT);

            }
        });

        btnMutiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.MULTIPLY);

            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.DIVIDE);

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("0");
                leftNumber = "";
                rightNumber = "";
                result = 0;
                currentNumber = "";
                currentOperation = null;

            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.EQUAL);
            }
        });

    }

    /**
     * Funkcija koja zapisuje u txtResult brojeve koje smo pritisnuli
     *
     * @param number Uzima broj iz gumba i prikazuje ga u txtResult
     */
    void numberPressed(int number) {
        currentNumber += String.valueOf(number);
        txtResult.setText(currentNumber);
    }

    /**
     * Funkcija koja radi izračun na temelju operacije
     *
     * @param operation Operacija koju smo odabrali da se izvrši, a definirao sam ih kao enumeraciju
     */
    void processOperation(Operation operation) {
        if (currentOperation != null) {
            if (currentNumber != "") {
                rightNumber = currentNumber;
                currentNumber = "";

                switch (currentOperation) {
                    case ADD:
                        result = Integer.parseInt(leftNumber) + Integer.parseInt(rightNumber);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftNumber) * Integer.parseInt(rightNumber);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftNumber) / Integer.parseInt(rightNumber);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftNumber) - Integer.parseInt(rightNumber);
                        break;
                }

                leftNumber = String.valueOf(result);
                txtResult.setText(leftNumber);
            }

        } else {
            leftNumber = currentNumber;
            currentNumber = "";

        }

        currentOperation = operation;
    }

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }
}
