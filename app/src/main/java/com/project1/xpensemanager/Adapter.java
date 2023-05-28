package com.project1.xpensemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
        holder.discription.setText(arrayList.get(position).discription);
        holder.img.setImageResource(arrayList.get(position).img);
        holder.expenseMoney.setText(arrayList.get(position).ExpenseMoney);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView expensename, discription, expenseMoney;
        ImageView img ;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            expensename = itemView.findViewById(R.id.expensename);
            discription = itemView.findViewById(R.id.Discription);
            img = itemView.findViewById(R.id.img);
            expenseMoney = itemView.findViewById(R.id.Ruppee);
        }
    }
}
