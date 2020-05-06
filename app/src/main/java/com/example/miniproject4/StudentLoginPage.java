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

public class StudentLoginPage extends AppCompatActivity {

    EditText email, password, regNo;
    Button login;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login_page);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        regNo = findViewById(R.id.regNo);

        mAuth = FirebaseAuth.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String regNo1 = regNo.getText().toString();
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();

                signIn(email1, password1, regNo1);

            }
        });
    }

    private void signIn(String email1, String password1, final String regNo1) {

        mAuth.signInWithEmailAndPassword(email1, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(StudentLoginPage.this, "Sign in successfull", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(StudentLoginPage.this, Student_Activities.class);
                            intent.putExtra("data", regNo1);
                            startActivity(intent);
                        } else {
                            Toast.makeText(StudentLoginPage.this, "UNSUCCESSFULL", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}
