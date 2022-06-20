package com.example.monprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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

public class retrieve_devoirs extends AppCompatActivity {
    ListView myListeView;
    DatabaseReference pdfref;
    List<pdf> pdfList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_devoirs);
        myListeView=findViewById(R.id.myListeView);

        pdfList  = new ArrayList<>();

        pdfref= FirebaseDatabase.getInstance().getReference("devoir");
        pdfref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                pdfList.clear();
                for(DataSnapshot pdfdatasnapshot:snapshot.getChildren()){
                    pdf pdf=pdfdatasnapshot.getValue(pdf.class);
                    pdfList.add(pdf);
                }
                ListAdapter_Cours adapter =new ListAdapter_Cours(retrieve_devoirs.this,pdfList);
                myListeView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        myListeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final   pdf Pdf=pdfList.get(i);
                Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse(Pdf.getUrl()));

                startActivity(intent);


            }
        });


    }



    }
