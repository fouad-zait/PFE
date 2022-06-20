package com.example.monprojet;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import java.util.List;

public class ListAdapter extends ArrayAdapter {
    private Activity mcontext;
    List<student> studentslist;

        public ListAdapter(Activity mcontext,List<student> studentslist){
            super(mcontext,R.layout.activity_notes_prof,studentslist);
            this.mcontext=mcontext;
            this.studentslist=studentslist;

        }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =mcontext.getLayoutInflater();
        View ListItemView =inflater.inflate(R.layout.activity_notes_prof,null,true);
        TextView tvname=ListItemView.findViewById(R.id.tvname);
        TextView tvnotes=ListItemView.findViewById(R.id.tvnotes);
        TextView tvfullname=ListItemView.findViewById(R.id.tvfullname);
        student student =studentslist.get(position);
        tvname.setText(student.getEtname());
        tvnotes.setText(student.getNotes());
        tvfullname.setText(student.getEtfullname());
        return ListItemView;
        




    }
}
