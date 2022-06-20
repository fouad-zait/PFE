package com.example.monprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

public class forgotpassword_phone extends AppCompatActivity {

    private EditText phone_num;
    private Button btn;
    private CountryCodePicker country;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword_phone);
        this.phone_num=(EditText)findViewById(R.id.phone_num);
        this.btn=(Button)findViewById(R.id.btn);
        this.country=(CountryCodePicker) findViewById(R.id.country);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullnumber="+"+country.getFullNumber()+phone_num.toString();
                Query checkUser = FirebaseDatabase.getInstance().getReference("student").orderByChild("phone_number").equalTo(fullnumber);
                Query checkUser2  = FirebaseDatabase.getInstance().getReference("teacher").orderByChild("phone_number").equalTo(fullnumber);
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists() ){
                            phone_num.setError(null);
                            Intent intent =new Intent(getApplicationContext(),forgotpassword2.class);
                            intent.putExtra("phone_number",fullnumber);
                            intent.putExtra("whatToDo","update data");

                            startActivity(intent);
                            finish(); }
                        else{
                            phone_num.setError("no such user exists");
                            phone_num.requestFocus();




                    }}

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




            }
        });



    }
}