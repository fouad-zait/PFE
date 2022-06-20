package com.example.monprojet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class questions_reponses extends AppCompatActivity {
    CardView poser_question,reponses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_reponses);
        this.poser_question=(CardView)findViewById(R.id.poser_question);
        this.reponses=(CardView)findViewById(R.id.reponses);
        poser_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(questions_reponses.this, retrieve_data_teacher_questions.class));
            }
        });
        reponses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(questions_reponses.this, retrieve_reponse_prof.class));
            }
        });
    }
}