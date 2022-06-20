package com.example.monprojet;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Listadapter_classes extends ArrayAdapter {
    private Activity mcontext;
    List<classe> classeList;
    public Listadapter_classes(Activity mcontext,List<classe> classeList){
        super(mcontext,R.layout.activity_affiche_classes,classeList);
        this.mcontext=mcontext;
        this.classeList=classeList;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =mcontext.getLayoutInflater();
        View ListItemView =inflater.inflate(R.layout.activity_affiche_classes,null,true);
        TextView name=ListItemView.findViewById(R.id.name);


        classe classe =classeList.get(position);

        name.setText(classe.getname());

        return ListItemView;





    }


}
