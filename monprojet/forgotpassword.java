package com.example.monprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import java.util.regex.Matcher;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpassword extends AppCompatActivity {
    private EditText email;
    private Button reset_pass;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        this.email=(EditText)findViewById(R.id.email);
        this.reset_pass=(Button)findViewById(R.id.reset_pass);
        auth=FirebaseAuth.getInstance();

        reset_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email2 = email.getText().toString();
                if (TextUtils.isEmpty(email2)) {
                    email.setError("please enter an email");
                    Toast.makeText(forgotpassword.this, "please enter an email", Toast.LENGTH_SHORT).show();
                } else {
                    auth.sendPasswordResetEmail(email2).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(forgotpassword.this, "please visit your email to reset your password", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(forgotpassword.this,MainActivity.class));
                        }
                            else{
                                String message=task.getException().getMessage();
                                Toast.makeText(forgotpassword.this, "Error: "+message , Toast.LENGTH_SHORT).show();


                            }
                        }
                    });

                }
            }
        });




    }
}