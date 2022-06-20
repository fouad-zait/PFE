package com.example.adminapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class admin_activity extends AppCompatActivity {
    CardView classes,notif,bus,paiement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_activity);
        this.classes=(CardView)findViewById(R.id.classes);
        this.notif=(CardView)findViewById(R.id.notif);
        this.bus=(CardView)findViewById(R.id.bus);
        this.paiement=(CardView)findViewById(R.id.paiement);

        classes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin_activity.this, retrieve_data_classes.class));
            }
        });
        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        paiement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}