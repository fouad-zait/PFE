package com.example.monprojet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class home_Activity extends AppCompatActivity {
    CardView modules,visio,notif,paiement,emploie,bus,logout;
    ImageView photo;
    int SELECT_PICTURE = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        this.modules=(CardView)findViewById(R.id.modules);
        this.visio=(CardView)findViewById(R.id.visio);
        this.notif=(CardView)findViewById(R.id.notif);
        this.paiement=(CardView)findViewById(R.id.paiement);
        this.emploie=(CardView)findViewById(R.id.emploie) ;

        this.logout=(CardView)findViewById(R.id.logout) ;
        this.photo=(ImageView)findViewById(R.id.photo) ;
        modules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home_Activity.this, modules.class));
            }
        });
        visio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                s="visioconférence";
                Intent intent =new Intent(home_Activity.this, visio.class);
                intent.putExtra("keyname",s);
                startActivity(intent);
            }
        });
        paiement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home_Activity.this, retrieve_1_note.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home_Activity.this, MainActivity.class));
            }
        });
        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home_Activity.this, retrieve_questions_prof.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home_Activity.this, MainActivity.class));
            }
        });
        emploie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home_Activity.this, emploie_du_temps.class));
            }
        });

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();
            }

            private void imageChooser() {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);


                startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);

            }

        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) {


            if (requestCode == SELECT_PICTURE) {

                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {

                    photo.setImageURI(selectedImageUri);
                }
            }
        }
    }


}