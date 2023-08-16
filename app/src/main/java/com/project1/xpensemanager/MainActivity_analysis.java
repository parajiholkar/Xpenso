package com.project1.xpensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Color;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity_analysis extends AppCompatActivity {

    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_analysis);

        Intent intent = getIntent();
        TextView EDU = findViewById(R.id.Ruppee2);
        TextView shop = findViewById(R.id.Ruppee1);
        TextView Enter = findViewById(R.id.Ruppee3);
        TextView bill = findViewById(R.id.Ruppee4);
        TextView groc = findViewById(R.id.Ruppee5);
        TextView medi = findViewById(R.id.Ruppee6);
        TextView food = findViewById(R.id.Ruppee7);
        TextView mainte = findViewById(R.id.Ruppee8);
        TextView otherX = findViewById(R.id.Ruppee9);
        int edu = intent.getIntExtra("Education",-1);
        int shopping = intent.getIntExtra("Shopping",-1);
        int enter = intent.getIntExtra("Entertainment",-1);
        int billr = intent.getIntExtra("Bills",-1);
        int grocr = intent.getIntExtra("Groceries",-1);
        int medic = intent.getIntExtra("Medical",-1);
        int foodr = intent.getIntExtra("Food",-1);
        int mainter = intent.getIntExtra("Maintenance",-1);
        int otherxr = intent.getIntExtra("Other Expenses",-1);
        EDU.setText(String.valueOf(edu+" Rs"));
        shop.setText(String.valueOf(shopping+" Rs"));
        Enter.setText(String.valueOf(enter+" Rs"));
        bill.setText(String.valueOf(billr+" Rs"));
        groc.setText(String.valueOf(grocr+" Rs"));
        medi.setText(String.valueOf(medic+" Rs"));
        food.setText(String.valueOf(foodr+" Rs"));
        mainte.setText(String.valueOf(mainter+" Rs"));
        otherX.setText(String.valueOf(otherxr+" Rs"));

        pieChart = findViewById(R.id.pieChart);

        ArrayList<PieEntry> entries = new ArrayList<>();
        if(edu>0){
            entries.add(new PieEntry(edu, "Education"));
        }
        if (shopping>0) {
            entries.add(new PieEntry(shopping, "Shopping"));
        }
        if (enter>0) {
            entries.add(new PieEntry(enter, "Entertainment"));
        }
        if (billr>0) {
            entries.add(new PieEntry(billr, "Bills"));
        }
        if (grocr>0) {
            entries.add(new PieEntry(grocr, "Groceries"));
        }
        if (medic>0) {
            entries.add(new PieEntry(medic, "Medical"));
        }
        if (foodr>0) {
            entries.add(new PieEntry(foodr, "Food"));
        }
        if (mainter>0) {
            entries.add(new PieEntry(mainter, "Maintenance"));
        }
        if (otherxr>0) {
            entries.add(new PieEntry(otherxr, "OtherX"));
        }
        if(entries.size()<1){
            entries.add(new PieEntry(1, "Empty"));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Expense Analysis");
        dataSet.setColors(Color.parseColor("#252B48"),Color.parseColor("#5B9A8B"),Color.parseColor("#65451F"),Color.parseColor("#FBD85D"),Color.parseColor("#FD8D14"),Color.parseColor("#898121"),Color.RED,Color.GREEN,Color.BLUE);
        dataSet.setValueTextSize(0f);

        PieData data = new PieData(dataSet);

        pieChart.setData(data);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Expenses");
        pieChart.animateY(1000);
        pieChart.invalidate();

    }
}