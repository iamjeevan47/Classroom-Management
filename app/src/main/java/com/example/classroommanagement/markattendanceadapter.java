package com.example.classroommanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class markattendanceadapter extends RecyclerView.Adapter<markattendanceadapter.markattendanceViewHolder>
{
    private String[] name,enroll;
    public markattendanceadapter(String[] attendancename, String[] attendanceroll)
    {
        this.name=attendancename;
        this.enroll=attendanceroll;
    }

    @Override
    public markattendanceViewHolder onCreateViewHolder( ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.attendancelist, parent, false);
        return new markattendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder( markattendanceViewHolder holder, int position)
    {
        String sname = name[position];
        String enrollmentnumber = enroll[position];
        holder.name.setText(sname);
        holder.roll.setText(enrollmentnumber);

    }

    @Override
    public int getItemCount()
    {
        return enroll.length;
    }

    public class markattendanceViewHolder extends RecyclerView.ViewHolder
    {
        TextView roll, name;
        RadioGroup radioGroup;
        RadioButton present, absent;
        public markattendanceViewHolder( View itemView)
        {
            super(itemView);
            roll = (TextView) itemView.findViewById(R.id.enrollmentnumber);
            name = (TextView) itemView.findViewById(R.id.attendancenames);
            radioGroup = (RadioGroup) itemView.findViewById(R.id.radiogroup);
            present = (RadioButton) itemView.findViewById(R.id.present);
            absent = (RadioButton) itemView.findViewById(R.id.absent);
        }
    }
}
