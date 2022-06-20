package com.example.monprojet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class List_adapter_reponse extends ArrayAdapter {
    private Activity mcontext;
    List<reponse> chatList;
    public List_adapter_reponse(Activity mcontext,List<reponse> chatList){
        super(mcontext,R.layout.activity_affiche_reponse,chatList);
        this.mcontext=mcontext;
        this.chatList=chatList; }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =mcontext.getLayoutInflater();
        View ListItemView =inflater.inflate(R.layout.activity_affiche_reponse,null,true);

        TextView message=ListItemView.findViewById(R.id.reponse);

        TextView sender=ListItemView.findViewById(R.id.envoi);


        reponse msg =chatList.get(position);

        message.setText(msg.getrep());
        sender.setText(msg.getenvoi());

        return ListItemView;





    }




}

