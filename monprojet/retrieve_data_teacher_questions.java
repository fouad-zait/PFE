package com.example.monprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class retrieve_data_teacher_questions extends AppCompatActivity {
    ListView myListeView;
    DatabaseReference teacherdbref;
    List<teacher> teacherList;
    DatabaseReference databaseReference;
    private DatabaseReference reference2;
    private FirebaseDatabase rootNode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_data_teacher_questions);
        myListeView=findViewById(R.id.myListeView);
        teacherList=new ArrayList<>();

            Intent i =new Intent();
            String user=i.getStringExtra("etusername");

        teacherdbref= FirebaseDatabase.getInstance().getReference("teacher");
        teacherdbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                teacherList.clear();
                for(DataSnapshot teacherdata:snapshot.getChildren()){
                    teacher teacher=teacherdata.getValue(teacher.class);
                    teacherList.add(teacher);

                }
                question_teacher_adapter adapter =new question_teacher_adapter(retrieve_data_teacher_questions.this,teacherList);
                myListeView.setAdapter(adapter);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        myListeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final   teacher teacher1=teacherList.get(i);

                AlertDialog.Builder mDialog=new AlertDialog.Builder(retrieve_data_teacher_questions.this);
                mDialog.setTitle("posez votre question");
                LayoutInflater inflater=getLayoutInflater();
                View mDialogView=inflater.inflate(R.layout.envoiemsg,null);
                mDialog.setTitle("Question").setView(mDialogView).setPositiveButton("envoyer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText question;
                        Dialog f=(Dialog) dialogInterface;
                        question =(EditText)f.findViewById(R.id.etmsg);
                        String s=question.getText().toString();
                        rootNode = FirebaseDatabase.getInstance();
                        reference2 = rootNode.getReference("question");

                        databaseReference=FirebaseDatabase.getInstance().getReference("student").child("etusername");
                        databaseReference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for(DataSnapshot ds:snapshot.getChildren()){
                                    if(ds.child("etusername").getValue(String.class).equals(user)){
                                        chat c1=new chat(user,teacher1.getEtusername(),s);
                                        reference2.child(reference2.getDatabase().getReference().push().getKey()).setValue(c1);

                                    }

                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });



                     chat c1=new chat("fouadinho",teacher1.getEtusername(),s);
                        reference2.child(reference2.getDatabase().getReference().push().getKey()).setValue(c1);


                      //chat c1=new chat(user,teacher1.getEtusername(),s);
                    //  databaseReference.child(databaseReference.push().getKey()).setValue(c1);//
                        Toast.makeText(retrieve_data_teacher_questions.this,"message envoyé",Toast.LENGTH_SHORT).show();
                        f.dismiss();

                    }
                }).show();









            }
        });
    }
}