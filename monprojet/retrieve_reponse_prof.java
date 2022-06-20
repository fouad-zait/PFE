package com.example.monprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class retrieve_reponse_prof extends AppCompatActivity {
    ListView myListeView;
    DatabaseReference questionsdbref;
    List<reponse> chatList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_reponse_prof);
        myListeView=findViewById(R.id.myListeView);
        chatList=new ArrayList<>();
        questionsdbref= FirebaseDatabase.getInstance().getReference("reponse");
        questionsdbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                chatList.clear();
                for(DataSnapshot chatdatasnap:snapshot.getChildren()){
                    reponse reponse =chatdatasnap.getValue(reponse.class);
                    chatList.add(reponse);

                }
                List_adapter_reponse adapter =new List_adapter_reponse(retrieve_reponse_prof.this,chatList);
                myListeView.setAdapter(adapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}