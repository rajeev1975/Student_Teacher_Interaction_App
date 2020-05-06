package com.example.miniproject4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class PayFee extends AppCompatActivity {
    EditText amount, name, upiId, note;
    Button pay;
    final int UPI_PAYMENT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_fee);

        amount = findViewById(R.id.amount);
        name = findViewById(R.id.name);
        upiId = findViewById(R.id.upiId);
        note = findViewById(R.id.note);
        pay = findViewById(R.id.pay);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountText = amount.getText().toString();
                String nameText = name.getText().toString();
                String upiIdText = upiId.getText().toString();
                String noteText = note.getText().toString();

                payUsingUpi(amountText, noteText, nameText, upiIdText);
            }
        });
    }

    private void payUsingUpi(String amountText, String noteText, String nameText, String upiIdText) {
        Uri uri = Uri.parse("upi://pay").buildUpon().appendQueryParameter("pa", upiIdText).appendQueryParameter("pa", nameText)
                .appendQueryParameter("tn", noteText)
                .appendQueryParameter("am", amountText)
                .appendQueryParameter("cu", "INR").build();
        Intent upi_payment = new Intent(Intent.ACTION_VIEW);
        upi_payment.setData(uri);
        Intent chooser = Intent.createChooser(upi_payment, "pay with");
        if (null != chooser.resolveActivity(getPackageManager())) {
            startActivityForResult(chooser, UPI_PAYMENT);
        } else {
            Toast.makeText(this, "No upi App Found", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case UPI_PAYMENT:
                if (RESULT_OK == resultCode || (requestCode == 11)) {
                    if (data != null) {
                        String txt = data.getStringExtra("response");
                        Log.d("UPI", "onActivityResult:" + txt);
                        ArrayList<String> dataLst = new ArrayList<>();
                        dataLst.add("Nothing");
                        upiPaymentDataOperation(dataLst);

                    } else {
                        Log.d("UPI", "onActivityResult:" + "Return data is null");
                        ArrayList<String> dataLst = new ArrayList<>();
                        dataLst.add("Nothing");
                        upiPaymentDataOperation(dataLst);
                    }
                } else {
                    Log.d("UPI", "onActivityResult:" + "Return data is null");
                    ArrayList<String> dataLst = new ArrayList<>();
                    dataLst.add("Nothing");
                    upiPaymentDataOperation(dataLst);
                }
                break;
        }
    }

    private void upiPaymentDataOperation(ArrayList<String> data) {
        if (isConnectionAvailable(PayFee.this)) {
            String str = data.get(0);
            Log.d("UPIPAY", "UpipaymentOperation:" + str);
            String paymentCancel = "";
            if (str == null) str = "discard";
            String status = "";
            String approvalref = "";
            String[] response = str.split("&");
            for (int i = 0; i < response.length; i++) {
                String[] equalStr = response[i].split("=");
                if (equalStr.length >= 2) {
                    if (equalStr[0].toLowerCase().equals("Status".toLowerCase())) {
                        status = equalStr[1].toLowerCase();
                    } else if (equalStr[0].toLowerCase().equals("approval Ref".toLowerCase()) ||
                            equalStr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                        approvalref = equalStr[1];
                    }
                } else {
                    paymentCancel = "payment cancel by user";
                    if (status.equals("success")) {
                        Toast.makeText(this, "Transaction successfull", Toast.LENGTH_SHORT).show();
                        Log.d("UPI", "responsestr:" + approvalref);
                    } else if ("payment cancel by user".equals(paymentCancel)) {
                        Toast.makeText(this, "payment cancel by user", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Transaction failed", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        } else {
            Toast.makeText(this, "No internet connection is not available", Toast.LENGTH_SHORT).show();
        }


    }

    private boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected() && networkInfo.isConnectedOrConnecting()
                    && networkInfo.isAvailable();
        }
        return false;
    }
}
