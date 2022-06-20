 package com.example.monprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.Character;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class inscriptionActivity extends AppCompatActivity {
    private EditText name;
    private EditText fullname;
    private EditText username;
    private EditText password2;
    private EditText email;
    private EditText phone_N;
    private RadioButton btnstudent;
    private RadioButton btnteacher;
    private Button btn_signup;
    private FirebaseAuth mAuth;
    private DatabaseReference reference;
    private FirebaseDatabase rootNode;

    private String etname, etfullname, etusername, etemail, pass,phone_number, usertype,notes="0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        this.name = (EditText) findViewById(R.id.name);
        this.fullname = (EditText) findViewById(R.id.fullname);
        this.username = (EditText) findViewById(R.id.username);
        this.password2 = (EditText) findViewById(R.id.password2);
        this.email = (EditText) findViewById(R.id.email);
        this.phone_N= (EditText) findViewById(R.id.phone_N);
        this.btnstudent = (RadioButton) findViewById(R.id.btnstudent);
        this.btnteacher = (RadioButton) findViewById(R.id.btnteacher);
        this.btn_signup = (Button) findViewById(R.id.btn_signup);


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etname = name.getText().toString();
                String etfullname = fullname.getText().toString();
                String etusername = username.getText().toString();
                String pass = password2.getText().toString();
                String etemail = email.getText().toString();
                String phone_number=phone_N.getText().toString();
                if(!validateName()|!validatefullname()|!validatemail()|!validatepassword()|!validateusername()|!validatephonenumber()){
                    return;
                }


                if (btnstudent.isChecked()) {
                    usertype = "student";
                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("student");
                    student t = new student(etname, etfullname, etusername, pass, etemail,phone_number, usertype,notes);
                    reference.child(etusername).setValue(t);
                }
                if (btnteacher.isChecked()) {
                    usertype = "teacher";
                    rootNode = FirebaseDatabase.getInstance();
                    reference = rootNode.getReference("teacher");

                    teacher t = new teacher(etname, etfullname, etusername, pass, etemail,phone_number, usertype);
                    reference.child(etusername).setValue(t);

                }


            }
        });
    }

    private Boolean validateName() {
        String val=name.getText().toString();
        if(val.isEmpty()){
            name.setError("field cannot be empty");
            return false;
        }
        else{
            name.setError(null);
            return true;
        }


    }
    private Boolean validatefullname() {
        String val=fullname.getText().toString();
        if(val.isEmpty()){
            fullname.setError("field cannot be empty");
            return false;
        }
        else{
            fullname.setError(null);
            return true;
        }


    }
    private Boolean validatepassword() {
        String val=password2.getText().toString();
        if(val.isEmpty()){
            password2.setError("field cannot be empty");
            return false;
        }
        else if(val.length()<8|minchiffre(val)<1|minmaj(val)<1){
            password2.setError("invalid password");
            return false;
        }
        else{
            password2.setError(null);
            return true;
        }


    }
    private int minchiffre (String s){
            int nb=0;
            for (int j=0;j<s.length();j++){
                if(Character.isDigit(s.charAt(j))){
                    nb++;
                }
        }return nb++;  }

    private int minmaj (String s) {
        int nb = 0;
        for (int j = 0; j < s.length(); j++) {
            if (Character.isDigit(s.charAt(j))) {
                nb++;
            }
        }
        return nb++;}
        private Boolean validatemail () {
            String val = email.getText().toString();
            String emailpatern = "[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+";
            if (val.isEmpty()) {
                email.setError("field cannot be empty");
                return false;
            } else if (!val.matches(emailpatern)) {
                email.setError("invalid email adress");
                return false;
            } else {
                email.setError(null);
                return true;
            }


        }
        private Boolean validateusername () {
            String val = username.getText().toString();
            String nospace = "[a-zA-Z0-9.-_]*";
            if (val.isEmpty()) {
                username.setError("field cannot be empty");
                return false;
            } else if (val.length() >= 15) {
                username.setError("username too long");
                return false;
            } else if (!val.matches(nospace)) {
                username.setError("invalid username");
                return false;
            } else {
                username.setError(null);
                return true;
            }


        }
        private Boolean validatephonenumber(){
            String nb = phone_N.getText().toString();
            String phone = "[0-9]*";
            if (nb.isEmpty()) {
               phone_N.setError("field cannot be empty");
                return false;
            } else if (!nb.matches(phone)&nb.length()>10) {
                phone_N.setError("invalid number");
                return false;
            } else {
                phone_N.setError(null);
                return true;
            }





        }

    }













