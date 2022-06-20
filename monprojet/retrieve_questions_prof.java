package com.example.monprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class retrieve_questions_prof extends AppCompatActivity {
    ListView myListeView;
    DatabaseReference questionsdbref;
    List<message> chatList;
    private DatabaseReference reference2;
    private FirebaseDatabase rootNode;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_questions_prof);
        myListeView=findViewById(R.id.myListeView2);
        chatList=new ArrayList<>();
        questionsdbref= FirebaseDatabase.getInstance().getReference("message");
        questionsdbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                chatList.clear();
                for(DataSnapshot chatdatasnap:snapshot.getChildren()){
                    message message =chatdatasnap.getValue(message.class);
                    chatList.add(message);

                }
                ListAdapter_questions_Prof adapter =new ListAdapter_questions_Prof(retrieve_questions_prof.this,chatList);
                myListeView.setAdapter(adapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
    });
        myListeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder mDialog=new AlertDialog.Builder(retrieve_questions_prof.this);
                mDialog.setTitle("repondre a la question");
                LayoutInflater inflater=getLayoutInflater();
                View mDialogView=inflater.inflate(R.layout.reponsemsg,null);
                mDialog.setTitle("Reponse").setView(mDialogView).setPositiveButton("envoyer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Dialog f=(Dialog) dialogInterface;
                        Toast.makeText(retrieve_questions_prof.this,"message envoyé",Toast.LENGTH_SHORT).show();
                        f.dismiss();
                    }

        }).show();
    }

});}}


