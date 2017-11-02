package com.example.taruc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityResult extends AppCompatActivity {

    private TextView textViewMonthlyPayment, textViewStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewMonthlyPayment = (TextView) findViewById(R.id.textViewMonthlyPayment);
        textViewStatus = (TextView) findViewById(R.id.textViewStatus);

        // To receive data from another activity
        Intent intent = getIntent();
        double payment = intent.getDoubleExtra(MainActivity.MONTHLY_PAYMENT, 0);
        String status = intent.getStringExtra(MainActivity.LOAN_STATUS);

        // TODO: Display the output
        textViewMonthlyPayment.setText("Monthly Payment : " + String.format("%.2f",payment));
        textViewStatus.setText("Status : " + status);

    }

    public void closeActivity(View view)
    {
        // Terminate the current activity
        finish();
    }

}
