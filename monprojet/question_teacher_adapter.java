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

public class question_teacher_adapter extends ArrayAdapter {
    private Activity mcontext;
    List<teacher> teacherslist;

    public question_teacher_adapter(Activity mcontext,List<teacher> teacherslist){
        super(mcontext,R.layout.activity_teacher_adapter,teacherslist);
        this.mcontext=mcontext;
        this.teacherslist=teacherslist;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =mcontext.getLayoutInflater();
        View ListItemView =inflater.inflate(R.layout.activity_teacher_adapter,null,true);
        TextView tvname=ListItemView.findViewById(R.id.tvname);

        teacher teacher =teacherslist.get(position);
        tvname.setText(teacher.getEtname());

        return ListItemView;





    }
}






