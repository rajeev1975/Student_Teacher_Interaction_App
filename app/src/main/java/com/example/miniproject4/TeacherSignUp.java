package com.example.miniproject4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class TeacherSignUp extends AppCompatActivity {

    EditText email, password;
    Button add;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_sign_up);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        add = findViewById(R.id.add);

        mAuth = FirebaseAuth.getInstance();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();

                createAccount(email1, password1);
            }
        });
    }

    private void createAccount(String email1, final String password1) {

        mAuth.createUserWithEmailAndPassword(email1, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(TeacherSignUp.this, AddTeachersDetail.class);
                            intent.putExtra("password2", password1);
                            startActivity(intent);
                        } else {
                            Toast.makeText(TeacherSignUp.this, "UNSUCCESSFULL", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
