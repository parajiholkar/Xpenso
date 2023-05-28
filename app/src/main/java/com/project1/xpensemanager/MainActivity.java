package com.project1.xpensemanager;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab ;
    ArrayList<expenseModel> arrayList = new ArrayList<>();
    RecyclerView recyclerView ;
    TextView totalRSview ;
    ImageButton anaysisbtn ;
    LinearLayout entertainmentC, educationC, shoppingC, billsC ,foodC ,medicalC, maintenanceC, groceriesC,otherXC;
    int totalrs = 0 , education = 0, shopping = 0, bills = 0, food = 0, medical = 0, maintenance = 0, groceries= 0;
    int entertainment=0, otherX= 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anaysisbtn = findViewById(R.id.analysisbtn);
        educationC = findViewById(R.id.education);
        entertainmentC = findViewById(R.id.entertainment);
        foodC = findViewById(R.id.food);
        groceriesC = findViewById(R.id.groceri);
        shoppingC = findViewById(R.id.shopping);
        medicalC = findViewById(R.id.medical);
        billsC = findViewById(R.id.bills);
        maintenanceC = findViewById(R.id.maintenance);
        otherXC = findViewById(R.id.other);
        totalRSview = findViewById(R.id.totalRS);
        recyclerView = findViewById(R.id.recycleviewExpense);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList.add(new expenseModel("Education","for Ramesh",R.drawable.education,"1200"));
        arrayList.add(new expenseModel("Medical","Rajesh",R.drawable.pills,"2000"));
        arrayList.add(new expenseModel("Entertainment","DDLJ",R.drawable.popcorn,"1500"));
        Adapter adapter = new Adapter(MainActivity.this,arrayList);
        recyclerView.setAdapter(adapter);

        anaysisbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ianaysis = new Intent(MainActivity.this, MainActivity_analysis.class);
                startActivity(ianaysis);
            }
        });

        fab = findViewById(R.id.fabutton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main2,(LinearLayout)findViewById(R.id.sheet));
                bottomSheetDialog.setContentView(view);
                bottomSheetDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                bottomSheetDialog.show();
                Button add = bottomSheetDialog.findViewById(R.id.addExpense);
                EditText name = bottomSheetDialog.findViewById(R.id.name);
                EditText discription = bottomSheetDialog.findViewById(R.id.discription);
                EditText Expense = bottomSheetDialog.findViewById(R.id.Expense);
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String Name = name.getText().toString();
                        String Discription = discription.getText().toString();
                        String expense = Expense.getText().toString();
                        if(!Objects.equals(Name, "")) {
                            if (!Objects.equals(Discription, "")) {
                                if (!expense.equals("")) {

                                    name.getText().clear();
                                    discription.getText().clear();
                                    Expense.getText().clear();
                                    arrayList.add(0,new expenseModel(Name,Discription,R.drawable.education,expense));
                                    Adapter adapter = new Adapter(MainActivity.this,arrayList);
                                    recyclerView.setAdapter(adapter);
                                    settotalExpence();
                                }
                                else {
                                    Toast.makeText(MainActivity.this, "Please Enter Expense ( Rs )!", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Please Enter Discription!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Please Enter Expense Name!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

//        educationC.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        settotalExpence();

    }



    private void settotalExpence() {
        totalrs = 0 ;
        for (int i=0; i<arrayList.size();i++){
            totalrs += Integer.parseInt(arrayList.get(i).ExpenseMoney);
        }
        totalRSview.setText(String.valueOf(totalrs));
    }
}