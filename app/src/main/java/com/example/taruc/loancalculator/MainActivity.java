package com.example.taruc.loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MONTHLY_PAYMENT = "payment";
    public static final String LOAN_STATUS = "Status";

    private EditText editVehiclePrice, editDownpayment, editRepayment, editInterestRate, editSalary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editVehiclePrice = (EditText) findViewById(R.id.editVehiclePrice);
        editDownpayment = (EditText) findViewById(R.id.editDownpayment);
        editRepayment = (EditText) findViewById(R.id.editRepayment);
        editInterestRate = (EditText) findViewById(R.id.editInterestRate);
        editSalary = (EditText) findViewById(R.id.editSalary);
    }

    public void calculateLoad(View view)
    {
        // TODO: calculate monthly payment and determine the loan status
        double monthlyPayment = 0;
        String status = "Approved";

        Double vehiclePrice = Double.parseDouble(editVehiclePrice.getText().toString());
        Double downpayment = Double.parseDouble(editDownpayment.getText().toString());
        Double repayment = Double.parseDouble(editRepayment.getText().toString());
        Double interestRate = Double.parseDouble(editInterestRate.getText().toString());
        Double salary = Double.parseDouble(editSalary.getText().toString());

        Double totalInterest;
        Double totalLoan;
        Double totalMonthlyPayment;

        totalInterest = (vehiclePrice - downpayment) * (interestRate/100) * (repayment / 12);
        totalLoan = (vehiclePrice - downpayment) + totalInterest;
        totalMonthlyPayment = totalLoan / repayment;

        if(totalMonthlyPayment > (salary * 0.3))
        {
            status = "Rejected";
        }


        // Create an Explicit Intent
        Intent intent = new Intent(this, ActivityResult.class);

        // TODO: passing data using putExtra method
        // format : putExtra(TAG, value)
        intent.putExtra(MONTHLY_PAYMENT, totalMonthlyPayment);
        intent.putExtra(LOAN_STATUS, status);


        startActivity(intent);
    }

    public void reset(View view)
    {
        editVehiclePrice.setText("");
        editDownpayment.setText("");
        editInterestRate.setText("");
        editRepayment.setText("");
        editSalary.setText("");
    }

}
