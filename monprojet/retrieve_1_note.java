package com.example.monprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class retrieve_1_note extends AppCompatActivity {
    ListView myListeView;
    DatabaseReference classesdbref;
    List<note> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_1_note);
        myListeView=findViewById(R.id.myListeView);
        notesList=new ArrayList<>();

        classesdbref= FirebaseDatabase.getInstance().getReference("note");
        classesdbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                notesList.clear();
                for(DataSnapshot classedatasnap:snapshot.getChildren()){
                    note note=classedatasnap.getValue(note.class);
                    notesList.add(note);

                }
                noteAdapter adapter =new noteAdapter(retrieve_1_note.this,notesList);
                myListeView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        myListeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(retrieve_1_note .this, classes.class));
            }
        });
}}