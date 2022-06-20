package com.example.monprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


public class forgotpassword2 extends AppCompatActivity {
    Pinview pin;
    String etname, etfullname, etusername, etemail, pass,phone_number, usertype,whatToDo;
    String verificationCodeBySystem ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword2);
        pin=findViewById(R.id.pin);
        etfullname=getIntent().getStringExtra("etfullname");
        etname=getIntent().getStringExtra("etname");
        etusername=getIntent().getStringExtra("etusername");
        etemail=getIntent().getStringExtra("etemail");
        pass=getIntent().getStringExtra("pass");
        phone_number=getIntent().getStringExtra("phone_number");
        whatToDo=getIntent().getStringExtra("whatToDo");
        usertype=getIntent().getStringExtra("usertype");
        sendverification(phone_number);

    }

    private void sendverification(String phone_number) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber("+213"+phone_number,60,TimeUnit.SECONDS, (Activity) TaskExecutors.MAIN_THREAD,mCallbacks
      );



    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationCodeBySystem=s;
        }

        @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            String code= phoneAuthCredential.getSmsCode();
            if (code!=null){
            verifyCode(code);
            }}

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(forgotpassword2.this, e.getMessage(), Toast.LENGTH_SHORT).show();


        }


    };

    private void verifyCode(String codeByUser){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCodeBySystem,codeByUser);
        signInTheUserByCredentials(credential);





    }

    private void signInTheUserByCredentials(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(forgotpassword2.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);


                }
                else{
                Toast.makeText(forgotpassword2.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }
            }
        });






    }

}