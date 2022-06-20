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

public class noteAdapter extends ArrayAdapter {
      private Activity mcontext;
    List<note> noteList;

    public noteAdapter(Activity mcontext,List<note> noteList){
        super(mcontext,R.layout.activity_note_xml,noteList);
        this.mcontext=mcontext;
        this.noteList=noteList;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =mcontext.getLayoutInflater();
        View ListItemView =inflater.inflate(R.layout.activity_note_xml,null,true);
        TextView name=ListItemView.findViewById(R.id.note);
        TextView matiere=ListItemView.findViewById(R.id.matiere);

         note note =noteList.get(position);
        name.setText(note.getNom());
        matiere.setText(note.getmat());
        return ListItemView;





    }


}
