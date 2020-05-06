package com.example.miniproject4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewHomeWork extends AppCompatActivity {
    TextView nHomeWork;
    DatabaseReference reference;
    FirebaseDatabase database;
    String assignment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_home_work);
        nHomeWork = findViewById(R.id.hView);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("HomeWork");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                assignment = dataSnapshot.getValue().toString();
                nHomeWork.setText(assignment);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ViewHomeWork.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
