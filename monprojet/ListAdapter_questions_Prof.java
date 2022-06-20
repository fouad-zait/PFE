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

public class ListAdapter_questions_Prof extends ArrayAdapter {
    private Activity mcontext;
    List<message> chatList;
    public ListAdapter_questions_Prof(Activity mcontext,List<message> chatList){
        super(mcontext,R.layout.activity_affiche_question_prof,chatList);
        this.mcontext=mcontext;
        this.chatList=chatList; }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =mcontext.getLayoutInflater();
        View ListItemView =inflater.inflate(R.layout.activity_affiche_question_prof,null,true);

        TextView message=ListItemView.findViewById(R.id.message);

         TextView sender=ListItemView.findViewById(R.id.sender);


        message msg =chatList.get(position);

         message.setText(msg.getmsg());
        sender.setText(msg.getsend());

        return ListItemView;





    }






}
