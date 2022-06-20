package com.example.adminapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.monprojet.ListAdapter;
import com.example.monprojet.retrievedata;
import com.example.monprojet.student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class retrieve_data_classes extends AppCompatActivity {
    ListView myListeView;
    DatabaseReference classeref;
    List<classe> classeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_data_classes);
        myListeView=findViewById(com.example.monprojet.R.id.myListeView);
        classeList =new ArrayList<>();
        classeref= FirebaseDatabase.getInstance().getReference("classes");
        classeref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                classeList.clear();
                for(DataSnapshot classdatasnap:snapshot.getChildren()){
                    classe c1=classdatasnap.getValue(classe.class);
                    classeList.add(c1);

                }
                ListAdapter_classes adapter =new ListAdapter_classes(retrieve_data_classes.this,classeList);
                myListeView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}