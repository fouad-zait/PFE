package com.example.adminapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.monprojet.student;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter_classes extends ArrayAdapter {
    private Activity mcontext;
    List<classe> classeList;


    public  ListAdapter_classes(Activity mcontext,List<classe> classeList){
        super(mcontext,R.layout.activity_classes,classeList);
        this.mcontext=mcontext;
        this.classeList=classeList;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =mcontext.getLayoutInflater();
        View ListItemView =inflater.inflate(R.layout.activity_classes,null,true);
        TextView tvclasse=ListItemView.findViewById(R.id.tvclasse);

        classe classe1 =classeList.get(position);
        tvclasse.setText(classe1.getNom());
        return ListItemView;  }


}
