package com.example.miniproject4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentNotice extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    TextView nView;

    String message1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_notice);

        nView = findViewById(R.id.nView);

        database = FirebaseDatabase.getInstance();

        reference = database.getReference("Notice");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                message1 = dataSnapshot.getValue().toString();
                nView.setText(message1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(StudentNotice.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });


    }


}
