package com.example.monprojet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class classes extends AppCompatActivity {
    CardView cours,coursvideo,notes,devoirs,questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        this.cours=(CardView)findViewById(R.id.cours);
        this.coursvideo=(CardView)findViewById(R.id.coursvideo);
        this.notes=(CardView)findViewById(R.id.notes);
        this.devoirs=(CardView)findViewById(R.id.devoirs);
        this.questions=(CardView)findViewById(R.id.questions) ;
        cours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(classes.this, cours_pdf.class));
            }
        });
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(classes.this, retrievedata.class));
            }
        });



        coursvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(classes.this, cours_video.class));

            }
        });
        devoirs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(classes.this, devoir_pdf.class));
            }
        });
        questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(classes.this, retrieve_questions_prof.class));

            }
        });

    }
}