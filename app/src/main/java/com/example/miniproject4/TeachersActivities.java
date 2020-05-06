package com.example.miniproject4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TeachersActivities extends AppCompatActivity {
    CardView cNotice, cAttendance, cRoutine,cHomework;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_activities);

        cNotice = findViewById(R.id.cNotice);
        cAttendance = findViewById(R.id.cAttendance);
        cRoutine = findViewById(R.id.cRoutine);
        cHomework = findViewById(R.id.cHomework);

        cNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeachersActivities.this, ShareTeachersNotice.class);
                startActivity(intent);
            }
        });

        cAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeachersActivities.this, UploadAttendance.class);
                startActivity(intent);
            }
        });

        cRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeachersActivities.this, TShareRoutine.class);
                startActivity(intent);
            }
        });

        cHomework.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeachersActivities.this,TeacherShareHomeWork.class);
                startActivity(intent);
            }
        });
    }
}
