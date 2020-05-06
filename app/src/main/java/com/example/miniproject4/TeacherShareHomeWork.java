package com.example.miniproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TeacherShareHomeWork extends AppCompatActivity {
    EditText homeWork;
    Button share;
    FirebaseDatabase database;
    DatabaseReference reference;
    String str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_share_home_work);

        homeWork = findViewById(R.id.homeWork);
        share = findViewById(R.id.share);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                str = homeWork.getText().toString();

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("HomeWork");

                reference.setValue(str);

                Toast.makeText(TeacherShareHomeWork.this, "Home Work Shared", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
