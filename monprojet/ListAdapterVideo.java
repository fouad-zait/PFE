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

public class ListAdapterVideo extends ArrayAdapter {
    private Activity mcontext;
    List<pdf> cours_pdfList;

    public ListAdapterVideo(Activity mcontext,List<pdf> cours_pdfList){
        super(mcontext,R.layout.activity_video_list,cours_pdfList);
        this.mcontext=mcontext;
        this.cours_pdfList=cours_pdfList;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =mcontext.getLayoutInflater();

        View ListItemView =inflater.inflate(R.layout.activity_video_list,null,true);
        TextView tvname=ListItemView.findViewById(R.id.tvname_cours);
        TextView description_cours=ListItemView.findViewById(R.id.description_cours);
        pdf cours_pdf =cours_pdfList.get(position);
        tvname.setText(cours_pdf.getNom());
        description_cours.setText(cours_pdf.getDescription());


        return ListItemView;





    }


}
