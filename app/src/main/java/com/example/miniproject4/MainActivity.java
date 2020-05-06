package com.example.miniproject4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView cAdmin, cTeacher, cStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cAdmin = findViewById(R.id.cAdmin);
        cTeacher = findViewById(R.id.cTeacher);
        cStudent = findViewById(R.id.cStudent);

        cAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdminLoginPage.class);
                startActivity(intent);
            }
        });

        cStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentLoginPage.class);
                startActivity(intent);
            }
        });

        cTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TeacherLoginPage.class);
                startActivity(intent);
            }
        });
    }
}
