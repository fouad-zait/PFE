package com.example.monprojet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class modules extends AppCompatActivity {
   CardView math,sciences,physique,chimie,histoire,geo,francais,anglais,arabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modules);
        this.math=(CardView)findViewById(R.id.math);
        this.sciences=(CardView)findViewById(R.id.sciences);
        this.physique=(CardView)findViewById(R.id.physique);
        this.chimie=(CardView)findViewById(R.id.chimie);
        this.histoire=(CardView)findViewById(R.id.histoire) ;
        this.geo=(CardView)findViewById(R.id.geo) ;
        this.francais=(CardView)findViewById(R.id.francais) ;
        this.anglais=(CardView)findViewById(R.id.anglais) ;
        this.arabe=(CardView)findViewById(R.id.arabe) ;
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                s="mathematiques";
                Intent intent =new Intent(modules.this, modules2.class);
                intent.putExtra("keyname",s);
                startActivity(intent);
                

                
            }
        });
        sciences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                s="sciences";
                Intent intent =new Intent(modules.this, modules2.class);
                intent.putExtra("keyname",s);
                startActivity(intent);
            }
        });
        physique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                s="physique";
                Intent intent =new Intent(modules.this, modules2.class);
                intent.putExtra("keyname",s);
                startActivity(intent);
            }
        });
        chimie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                s="chimie";
                Intent intent =new Intent(modules.this, modules2.class);
                intent.putExtra("keyname",s);
                startActivity(intent); }
        });
        histoire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                s="histoire";
                Intent intent =new Intent(modules.this, modules2.class);
                intent.putExtra("keyname",s);
                startActivity(intent);
            }
        });
        geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                s="geographie";
                Intent intent =new Intent(modules.this, modules2.class);
                intent.putExtra("keyname",s);
                startActivity(intent);  }
        });
        francais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                s="francais";
                Intent intent =new Intent(modules.this, modules2.class);
                intent.putExtra("keyname",s);
                startActivity(intent);}
        });
        anglais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                s="anglais";
                Intent intent =new Intent(modules.this, modules2.class);
                intent.putExtra("keyname",s);
                startActivity(intent); }
        });
        arabe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                s="arabe";
                Intent intent =new Intent(modules.this, modules2.class);
                intent.putExtra("keyname",s);
                startActivity(intent); }
        });







    }
}