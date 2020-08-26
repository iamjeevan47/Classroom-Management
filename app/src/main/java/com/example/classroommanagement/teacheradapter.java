package com.example.classroommanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class teacheradapter extends RecyclerView.Adapter<teacheradapter.teacherdetailsViewHolder>
{
    private String[] name,desig;
    public teacheradapter(String[] teachername, String[] teacherdesig)
    {
        this.name = teachername;
        this.desig = teacherdesig;
    }

    @Override
    public teacherdetailsViewHolder onCreateViewHolder( ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.teacherlist,parent,false);
        return new teacherdetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(teacheradapter.teacherdetailsViewHolder holder, int position)
    {
        String tname = name[position];
        String tdesig = desig[position];
        holder.tname.setText(tname);
        holder.tdesig.setText(tdesig);
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Call", Toast.LENGTH_SHORT).show();
            }
        });
        holder.mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Mail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return name.length;
    }

    public class teacherdetailsViewHolder extends RecyclerView.ViewHolder
    {
        TextView tname, tdesig;
        ImageButton call, mail;
        public teacherdetailsViewHolder (View itemView)
        {
            super (itemView);
            tname = itemView.findViewById(R.id.tname);
            tdesig = itemView.findViewById(R.id.designation);
            call = itemView.findViewById(R.id.call);
            mail = itemView.findViewById(R.id.mail);

        }
    }
}
