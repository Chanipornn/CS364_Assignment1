package com.example.bmicalculator;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText heightEditText;

    private TextView bmiResult;
    private TextView categoryResult;

    private DecimalFormat formatter =
            new DecimalFormat("#,###.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        // Find Views

        weightEditText =
                findViewById(R.id.weightEditText);

        heightEditText =
                findViewById(R.id.heightEditText);

        bmiResult =
                findViewById(R.id.bmiResult);

        categoryResult =
                findViewById(R.id.categoryResult);

        Button calculateButton =
                findViewById(R.id.calculateButton);


        // Input validation
        // Maximum 8 digits
        // Decimal places maximum 2

        weightEditText.setFilters(
                new InputFilter[]{
                        new DecimalDigitsInputFilter(8, 2)
                }
        );

        heightEditText.setFilters(
                new InputFilter[]{
                        new DecimalDigitsInputFilter(8, 2)
                }
        );


        // Calculate button

        calculateButton.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        calculateBMI();
                    }
                }
        );
    }


    private void calculateBMI() {

        String weightText =
                weightEditText.getText()
                        .toString()
                        .trim();

        String heightText =
                heightEditText.getText()
                        .toString()
                        .trim();


        // Check empty input

        if (weightText.isEmpty()
                || heightText.isEmpty()) {

            // Keep BMI result as placeholder
            bmiResult.setText("--");

            // Show error message in category area
            categoryResult.setText(
                    R.string.invalid_input
            );

            categoryResult.setTextColor(
                    getColor(R.color.text_primary)
            );

            return;
        }


        // Convert String to double

        double weight =
                Double.parseDouble(weightText);

        double heightCm =
                Double.parseDouble(heightText);


        // Check zero or negative

        if (weight <= 0
                || heightCm <= 0) {

            // Keep BMI result as placeholder
            bmiResult.setText("--");

            // Show error message in category area
            categoryResult.setText(
                    R.string.invalid_zero
            );

            categoryResult.setTextColor(
                    getColor(R.color.overweight_color)
            );

            return;
        }


        // Convert cm to meter

        double heightM =
                heightCm / 100.0;


        // BMI formula

        double bmi =
                weight / (heightM * heightM);


        // Format BMI

        String formattedBMI =
                formatter.format(bmi);


        bmiResult.setText(formattedBMI);


        // BMI category

        if (bmi < 18.5) {

            categoryResult.setText(
                    R.string.underweight
            );

            categoryResult.setTextColor(
                    getColor(
                            R.color.underweight_color
                    )
            );

        } else if (bmi < 25) {

            categoryResult.setText(
                    R.string.normal
            );

            categoryResult.setTextColor(
                    getColor(
                            R.color.normal_color
                    )
            );

        } else if (bmi < 30) {

            categoryResult.setText(
                    R.string.overweight
            );

            categoryResult.setTextColor(
                    getColor(
                            R.color.overweight_color
                    )
            );

        } else {

            categoryResult.setText(
                    R.string.obese
            );

            categoryResult.setTextColor(
                    getColor(
                            R.color.obese_color
                    )
            );
        }
    }


    // Decimal Input Filter

    static class DecimalDigitsInputFilter
            implements InputFilter {

        private final Pattern mPattern;


        DecimalDigitsInputFilter(
                int digits,
                int digitsAfterZero) {

            mPattern = Pattern.compile(
                    "[0-9]{0,"
                            + (digits - 1)
                            + "}+((\\.[0-9]{0,"
                            + (digitsAfterZero - 1)
                            + "})?)||(\\.)?"
            );
        }


        @Override
        public CharSequence filter(
                CharSequence source,
                int start,
                int end,
                Spanned dest,
                int dstart,
                int dend) {

            String newText =
                    dest.toString().substring(0, dstart)
                            + source
                            + dest.toString().substring(dend);


            Matcher matcher =
                    mPattern.matcher(newText);


            if (!matcher.matches()) {
                return "";
            }


            return null;
        }
    }
}