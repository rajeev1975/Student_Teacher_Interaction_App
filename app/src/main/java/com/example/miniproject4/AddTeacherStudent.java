package com.example.miniproject4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddTeacherStudent extends AppCompatActivity {

    CardView addTeacher, addStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher_student);

        addTeacher = findViewById(R.id.addTeacher);
        addStudent = findViewById(R.id.addStudent);

        addTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddTeacherStudent.this, TeacherSignUp.class);
                startActivity(intent);
            }
        });

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddTeacherStudent.this, StudentSignUp.class);
                startActivity(intent);
            }
        });


    }
}
