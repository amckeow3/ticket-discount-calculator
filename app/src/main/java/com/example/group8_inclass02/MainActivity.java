package com.example.group8_inclass02;

import static java.lang.String.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

//Adrianna Mckeown
//Group 8
//Class02
public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText valueTicketPrice = findViewById(R.id.editTextTicketPrice);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        Button buttonClear = findViewById(R.id.buttonClear);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        TextView showDiscountedPrice = findViewById(R.id.textViewDiscountedPrice);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valueTicketPrice.getText().toString().isEmpty() || isNotNumeric(valueTicketPrice.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Number should be a valid positive number", Toast.LENGTH_SHORT).show();
                }
                else {
                    int checkedId = radioGroup.getCheckedRadioButtonId();
                    Double Price = Double.parseDouble(valueTicketPrice.getText().toString());
                    Double discountedPrice = 0.00;
                        switch (checkedId) {
                            case R.id.radioButton_5:
                                discountedPrice = Price - (Price * 5 / 100);
                                break;
                            case R.id.radioButton_10:
                                discountedPrice = Price - (Price * 10 / 100);
                                break;
                            case R.id.radioButton_15:
                                discountedPrice = Price - (Price * 15 / 100);
                                break;
                            case R.id.radioButton_20:
                                discountedPrice = Price - (Price * 20 / 100);
                                break;
                            case R.id.radioButton_50:
                                discountedPrice = Price - (Price * 50 / 100);
                                break;
                        }

                        String totalPrice = String.valueOf(discountedPrice);
                        showDiscountedPrice.setText(totalPrice);
                    }
                }

            public boolean isNotNumeric(String str)
            {
                for (char c : str.toCharArray())
                {
                    if (!Character.isDigit(c)) return true;
                }
                return false;
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup.clearCheck();
                showDiscountedPrice.setText("");
                valueTicketPrice.setText("");
            }
        });
    }
}