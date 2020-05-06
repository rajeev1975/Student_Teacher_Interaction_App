package com.example.miniproject4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Student_Activities extends AppCompatActivity {

    CardView cNotice, cAttendance, cPay,cHomework;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__activities);

        cNotice = findViewById(R.id.cNotice);
        cAttendance = findViewById(R.id.cAttendance);
        cPay = findViewById(R.id.cPayFee);
        cHomework = findViewById(R.id.cHomework);

        final String regNo2 = getIntent().getStringExtra("data");

        cAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student_Activities.this, ViewAttendance.class);
                intent.putExtra("data", regNo2);
                startActivity(intent);
            }
        });

        cNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student_Activities.this, StudentNotice.class);
                startActivity(intent);
            }
        });

        cPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student_Activities.this, PayFee.class);
                startActivity(intent);
            }
        });

        cHomework.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student_Activities.this,ViewHomeWork.class);
                startActivity(intent);
            }
        });
    }
}
