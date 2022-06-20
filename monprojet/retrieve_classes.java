package com.example.monprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class retrieve_classes extends AppCompatActivity {
    ListView myListeView;
    DatabaseReference classesdbref;
    List<classe> classesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_classes);
        myListeView=findViewById(R.id.myListeView);
        classesList=new ArrayList<>();
        classesdbref= FirebaseDatabase.getInstance().getReference("classe");
        classesdbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                classesList.clear();
                for(DataSnapshot classedatasnap:snapshot.getChildren()){
                    classe classe=classedatasnap.getValue(classe.class);
                    classesList.add(classe);

                }
                Listadapter_classes adapter =new Listadapter_classes(retrieve_classes.this,classesList);
                myListeView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        myListeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(retrieve_classes.this, classes.class));
            }
        });
    }
}