package com.example.monprojet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.monprojet.modules;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class modules2 extends AppCompatActivity {
    CardView cours,coursvideo,notes,devoirs,questions;
    TextView dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules2);
        this.cours=(CardView)findViewById(R.id.cours);
        this.coursvideo=(CardView)findViewById(R.id.coursvideo);
        this.notes=(CardView)findViewById(R.id.notes);
        this.devoirs=(CardView)findViewById(R.id.devoirs);
        this.questions=(CardView)findViewById(R.id.questions) ;
        this.devoirs=(CardView)findViewById(R.id.devoirs);
        this.dashboard= findViewById(R.id.dashboard);
        String s=getIntent().getStringExtra("keyname");
        dashboard.setText(s);

        cours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(modules2.this, retrieve_cours_pdf_student.class));

            }
        });
        coursvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(modules2.this, retrieve_video.class));
            }
        });
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(modules2.this, retrieve_1_note.class);
                intent.putExtra("keyname2",s);
                startActivity(intent);


            }
        });
        devoirs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(modules2.this, retrieve_devoirs.class));
            }
        });
        questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(modules2.this, questions_reponses.class));
            }
        });












    }
}