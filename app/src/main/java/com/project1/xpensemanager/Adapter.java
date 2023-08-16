package com.project1.xpensemanager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {
    Context context;
    ArrayList<expenseModel> arrayList ;
    public Adapter(Context context, ArrayList<expenseModel> arrayList){
        this.context = context;
        this.arrayList = arrayList;

    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.expenseview,parent,false);
        viewHolder viewholder = new viewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewHolder holder, int position) {
        holder.expensename.setText(arrayList.get(position).expensename);
        holder.img.setImageResource(arrayList.get(position).img);
        holder.expenseMoney.setText(arrayList.get(position).ExpenseMoney);
        holder.date.setText(arrayList.get(position).Date);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView expensename, expenseMoney, date;
        ConstraintLayout constraintLayout ;
        ImageView img ;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            expensename = itemView.findViewById(R.id.expensename);
            date = itemView.findViewById(R.id.Date);
            img = itemView.findViewById(R.id.img);
            expenseMoney = itemView.findViewById(R.id.Ruppee);
            constraintLayout = itemView.findViewById(R.id.layout);
        }
    }
}
