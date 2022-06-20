package com.example.monprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class visioprof extends AppCompatActivity {
    TextView zoomprof,google_meetprof,skypeprof,webexprof,dashboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visioprof);
        this.zoomprof=(TextView)findViewById(R.id.zoomprof);
        this.google_meetprof=(TextView)findViewById(R.id.google_meetprof);
        this.skypeprof=(TextView)findViewById(R.id.skypeprof);
        this.webexprof=(TextView)findViewById(R.id.webexprof);
        this.dashboard=(TextView)findViewById(R.id.dashboard);
        String s=getIntent().getStringExtra("keyname");
        dashboard.setText(s);
        zoomprof.setMovementMethod(LinkMovementMethod.getInstance());
        google_meetprof.setMovementMethod(LinkMovementMethod.getInstance());
        skypeprof.setMovementMethod(LinkMovementMethod.getInstance());
        webexprof.setMovementMethod(LinkMovementMethod.getInstance());

    }
}