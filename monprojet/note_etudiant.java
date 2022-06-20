package com.example.monprojet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class note_etudiant extends AppCompatActivity {
    TextView name,matiere,note;
    DatabaseReference studentdbref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_etudiant2);
        this.name=(TextView)findViewById(R.id.name) ;
        this.matiere=(TextView)findViewById(R.id.matiere) ;
        this.note=(TextView)findViewById(R.id.note) ;
        String s=getIntent().getStringExtra("keyname2");
        matiere.setText(s);
        studentdbref= FirebaseDatabase.getInstance().getReference("student");
        note.setText(studentdbref.child("etusername").child("notes").toString());



    }
}