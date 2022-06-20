package com.example.monprojet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class prof extends AppCompatActivity {
    CardView classes,visioconf,paiment,notifications,Hbus,Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof);
        this.classes=(CardView)findViewById(R.id.classes);
        this.visioconf=(CardView)findViewById(R.id.visioconf);
        this.paiment=(CardView)findViewById(R.id.paiment);
        this.notifications=(CardView)findViewById(R.id.notifications);
        this.Hbus=(CardView)findViewById(R.id.prog) ;
        this.Logout=(CardView)findViewById(R.id.Logout) ;
        classes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(prof.this, retrieve_classes.class));

                //startActivity(new Intent(prof.this, retrievedata.class));//
            }
        });
        visioconf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(prof.this, cours_pdf.class));
                String s;
                s="visioconférence";
                Intent intent =new Intent(prof.this, visioprof.class);
                intent.putExtra("keyname",s);
                startActivity(intent);
            }
        });
        Hbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(prof.this, emploie_du_temps.class));
            }
        });
        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(prof.this, retrieve_questions_prof.class));
            }
        });
        paiment.setOnClickListener(new View.OnClickListener() {
            @Override
         public void onClick(View view) {
              startActivity(new Intent(prof.this, retrieve_1_note.class));
          }
       });


    }
}