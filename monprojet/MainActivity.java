package com.example.monprojet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
     private EditText login;
     private EditText password;
     private TextView forgotpass;
     private Button signin;

    private TextView signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.login=(EditText)findViewById(R.id.login);
        this.password=(EditText)findViewById(R.id.password);
        this.forgotpass=(TextView)findViewById(R.id.forgotpass);
        this.signin=(Button)findViewById(R.id.signin);
        this.signup=(TextView)findViewById(R.id.signup) ;

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                String user=login.getText().toString();
                String mdp=password .getText().toString();
                if(user.isEmpty()){login.setError("please enter a username");
                login.requestFocus();
                }
                else if (mdp.isEmpty()){password.setError("please enter a password");
                    password.requestFocus();
                }
                else if(user.isEmpty() && mdp.isEmpty()){
                    Toast.makeText(MainActivity.this,"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else if(!(user.isEmpty() && mdp.isEmpty())){
                    DatabaseReference reference=FirebaseDatabase.getInstance().getReference("student");
                    Query checkUser=reference.orderByChild("etusername").equalTo(user);
                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                login.setError(null);

                                String passwordfromDB=snapshot.child(user).child("pass").getValue(String.class);
                                if(passwordfromDB.equals(mdp)){
                                    login.setError(null);
                                    String namefromDB=snapshot.child(user).child("etname").getValue(String.class);
                                    String fullnamefromDB=snapshot.child(user).child("etfullname").getValue(String.class);
                                    String usertypefromDB=snapshot.child(user).child("usertype").getValue(String.class);
                                    String usernamefromDB=snapshot.child(user).child("etusername").getValue(String.class);
                                    String emailfromDB=snapshot.child(user).child("etemail").getValue(String.class);
                                    String phoneNfromDB=snapshot.child(user).child("phone_number").getValue(String.class);
                                    startActivity(new Intent(MainActivity.this, home_Activity.class));


                                }}
                               /*else{
                                 password.setError("wrong password");
                                  password.requestFocus();
                                }
                            else{login.setError("No such user exist");
                             login.requestFocus();}*/

                                

                            }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    DatabaseReference reference2=FirebaseDatabase.getInstance().getReference("teacher");
                    Query checkUser2=reference2.orderByChild("etusername").equalTo(user);
                    checkUser2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                login.setError(null);

                                String passwordfromDB=snapshot.child(user).child("pass").getValue(String.class);
                                if(passwordfromDB.equals(mdp)){
                                    login.setError(null);
                                    String namefromDB=snapshot.child(user).child("etname").getValue(String.class);
                                    String fullnamefromDB=snapshot.child(user).child("etfullname").getValue(String.class);
                                    String usertypefromDB=snapshot.child(user).child("usertype").getValue(String.class);
                                    String usernamefromDB=snapshot.child(user).child("etusername").getValue(String.class);
                                    String emailfromDB=snapshot.child(user).child("etemail").getValue(String.class);
                                    String phoneNfromDB=snapshot.child(user).child("phone_number").getValue(String.class);
                                    startActivity(new Intent(MainActivity.this, prof.class));


                                }}
                               /* else{
                                    password.setError("wrong password");
                                    password.requestFocus();
                                }}

                            else{login.setError("No such user exist");
                                login.requestFocus();}*/


                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                     }
                else{
                    Toast.makeText(MainActivity.this,"Error Occured",Toast.LENGTH_SHORT).show();
                }

            }  });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, inscriptionActivity.class));
            }});
        forgotpass.setOnClickListener(new View.OnClickListener(){
            @Override
             public void onClick(View v) {
              startActivity(new Intent(MainActivity.this, forgotpassword_phone.class));
              }});



    }
       }