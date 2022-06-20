package com.example.monprojet;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.auth.User;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{
    public static final int MSG_TYPE_LEFT =0;
    public static final int MSG_TYPE_RIGHT =1;
    FirebaseUser fuser;
    private Context mcontext;
    private List<chat> chatList;
    private String imageurl;
    public MessageAdapter(Context mcontext,List<chat> chatList,String imageurl){
        this.mcontext= mcontext;
        this.chatList= chatList;
        this.imageurl= imageurl;

    }


    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==MSG_TYPE_RIGHT){
        View view = LayoutInflater.from(mcontext).inflate(R.layout.chat_item_right,parent,false);
        return new MessageAdapter.ViewHolder(view);}
        else{View view = LayoutInflater.from(mcontext).inflate(R.layout.chat_item_left,parent,false);
            return new MessageAdapter.ViewHolder(view);

        }

    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {
    chat c1=chatList.get(position);
    holder.showmsg.setText(c1.getMessage());
    if(imageurl.equals("default")){
        holder.profile_image.setImageResource(R.mipmap.ic_launcher);
    }
    else{
        Glide.with(mcontext).load(imageurl).into(holder.profile_image);
    }

    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView showmsg;
        public ImageView profile_image;
        public ViewHolder(View itemview){
            super(itemview);
            showmsg=itemview.findViewById(R.id.showmsg);
            profile_image=itemview.findViewById(R.id.profil_image);



        }



    }

    @Override
    public int getItemViewType(int position) {
        fuser= FirebaseAuth.getInstance().getCurrentUser();
        if(chatList.get(position).getSender().equals(fuser.getUid())){
            return MSG_TYPE_RIGHT;
   }
        else{
            return MSG_TYPE_LEFT;
        }
    }
}







