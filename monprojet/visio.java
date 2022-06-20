package com.example.monprojet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class visio extends AppCompatActivity {
    TextView zoom,google_meet,skype,webex,dashboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visio);
        this.zoom=(TextView)findViewById(R.id.zoom);
        this.google_meet=(TextView)findViewById(R.id.google_meet);
        this.skype=(TextView)findViewById(R.id.skype);
        this.webex=(TextView)findViewById(R.id.webex);
        this.dashboard=(TextView)findViewById(R.id.dashboard);
        String s=getIntent().getStringExtra("keyname");
        dashboard.setText(s);
        zoom.setMovementMethod(LinkMovementMethod.getInstance());
        google_meet.setMovementMethod(LinkMovementMethod.getInstance());
        skype.setMovementMethod(LinkMovementMethod.getInstance());
        webex.setMovementMethod(LinkMovementMethod.getInstance());



    }
}