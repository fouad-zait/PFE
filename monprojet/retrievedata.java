package com.example.monprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class retrievedata extends AppCompatActivity {
    ListView myListeView;
    DatabaseReference studentdbref;
    List<student> studentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrievedata);

        myListeView=findViewById(R.id.myListeView);
        studentList=new ArrayList<>();

        studentdbref= FirebaseDatabase.getInstance().getReference("student");
        studentdbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                studentList.clear();
                for(DataSnapshot studentdatasnap:snapshot.getChildren()){
                    student student=studentdatasnap.getValue(student.class);
                    studentList.add(student);

                }
                ListAdapter adapter =new ListAdapter(retrievedata.this,studentList);
                myListeView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        myListeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              final   student student1=studentList.get(i);

                AlertDialog.Builder mDialog=new AlertDialog.Builder(retrievedata.this);
                mDialog.setTitle("changer la note");
                LayoutInflater inflater=getLayoutInflater();
                View mDialogView=inflater.inflate(R.layout.updatedata,null);



                mDialog.setTitle("changer la note").setView(mDialogView).setPositiveButton("envoyer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText upname;
                        Dialog f=(Dialog) dialogInterface;
                        upname =(EditText)f.findViewById(R.id.etupdatenote);

                        DatabaseReference ref= FirebaseDatabase.getInstance().getReference("student");
                       ImageView img =(ImageView)f.findViewById(R.id.img);
                        img.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Drawable res= ResourcesCompat.getDrawable(getResources(),R.drawable.logo_p,null);
                                img.setImageDrawable(res);
                            }
                        });


                       ref.child(student1.getEtusername()).addListenerForSingleValueEvent(new ValueEventListener() {
                           @Override
                           public void onDataChange(@NonNull DataSnapshot snapshot) {


                               snapshot.getRef().child("notes").setValue(upname.getText().toString());
                           }

                           @Override
                           public void onCancelled(@NonNull DatabaseError error) {
                               Log.d("User", error.getMessage());

                           }
                       });



                    }
                }).show();

            }

        });


        }

    }
























