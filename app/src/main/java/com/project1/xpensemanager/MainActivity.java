package com.project1.xpensemanager;

import static com.project1.xpensemanager.R.drawable.category_select_bg;

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
import android.graphics.drawable.Drawable;
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
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab ;
    ArrayList<expenseModel> arrayList = new ArrayList<>();
    RecyclerView recyclerView ;
    TextView totalRSview ;
    ImageButton anaysisbtn ;
    LinearLayout entertainmentC, educationC, shoppingC, billsC ,foodC ,medicalC, maintenanceC, groceriesC,otherXC;

    String selectedCate = "";

    int totalrs = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anaysisbtn = findViewById(R.id.analysisbtn);
        totalRSview = findViewById(R.id.totalRS);
        recyclerView = findViewById(R.id.recycleviewExpense);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Calendar calendar = Calendar.getInstance();
//       setdata();
        Adapter adapter = new Adapter(MainActivity.this,arrayList);
        recyclerView.setAdapter(adapter);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main2,(LinearLayout)findViewById(R.id.sheet));
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        educationC = bottomSheetDialog.findViewById(R.id.education);
        entertainmentC = bottomSheetDialog.findViewById(R.id.entertainment);
        foodC = bottomSheetDialog.findViewById(R.id.food);
        groceriesC = bottomSheetDialog.findViewById(R.id.groceri);
        shoppingC = bottomSheetDialog.findViewById(R.id.shopping);
        medicalC = bottomSheetDialog.findViewById(R.id.medical);
        billsC = bottomSheetDialog.findViewById(R.id.bills);
        maintenanceC = bottomSheetDialog.findViewById(R.id.maintenance);
        otherXC = bottomSheetDialog.findViewById(R.id.other);

        anaysisbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int edu = getcategoryViseExpence("Education");
                int entertain = getcategoryViseExpence("Entertainment");
                int shopping = getcategoryViseExpence("Shopping");
                int bill = getcategoryViseExpence("Bills");
                int grocery = getcategoryViseExpence("Groceries");
                int medical = getcategoryViseExpence("Medical");
                int food = getcategoryViseExpence("Food");
                int maintenance = getcategoryViseExpence("Maintenance");
                int otherX = getcategoryViseExpence("Other Expenses");
                Intent ianaysis = new Intent(MainActivity.this, MainActivity_analysis.class);
                ianaysis.putExtra("Education",edu);
                ianaysis.putExtra("Entertainment",entertain);
                ianaysis.putExtra("Food",food);
                ianaysis.putExtra("Groceries",grocery);
                ianaysis.putExtra("Shopping",shopping);
                ianaysis.putExtra("Medical",medical);
                ianaysis.putExtra("Bills",bill);
                ianaysis.putExtra("Maintenance",maintenance);
                ianaysis.putExtra("Other Expenses",otherX);
                startActivity(ianaysis);
            }
        });

        fab = findViewById(R.id.fabutton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.show();
                removeAllselected_bg();
                Button add = bottomSheetDialog.findViewById(R.id.addExpense);
                EditText name = bottomSheetDialog.findViewById(R.id.name);
                EditText Expense = bottomSheetDialog.findViewById(R.id.Expense);
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String Name = name.getText().toString();
                        String expense = Expense.getText().toString();
                        if(!Objects.equals(Name, "")) {
                                if (!expense.equals("")) {
                                    if(!selectedCate.equals("")){
                                        name.getText().clear();
                                        Expense.getText().clear();
                                        Calendar calendar1 = Calendar.getInstance();
                                        switch (selectedCate){
                                            case "Entertainment":
                                                arrayList.add(0,new expenseModel(Name,"Entertainment",R.drawable.popcorn,expense, DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar1.getTime())));
                                                selectedCate = "";
                                                break;
                                            case "Education":
                                                arrayList.add(0,new expenseModel(Name,"Education",R.drawable.education,expense, DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar1.getTime())));
                                                selectedCate = "";
                                                break;
                                            case "Food":
                                                arrayList.add(0,new expenseModel(Name,"Food",R.drawable.ramen,expense, DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar1.getTime())));
                                                selectedCate = "";
                                                break;
                                            case "Groceries":
                                                arrayList.add(0,new expenseModel(Name,"Groceries",R.drawable.grocery,expense, DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar1.getTime())));
                                                selectedCate = "";
                                                break;
                                            case "Shopping":
                                                arrayList.add(0,new expenseModel(Name,"Shopping",R.drawable.shopping,expense, DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar1.getTime())));
                                                selectedCate = "";
                                                break;
                                            case "Medical":
                                                arrayList.add(0,new expenseModel(Name,"Medical",R.drawable.pills,expense, DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar1.getTime())));
                                                selectedCate = "";
                                                break;
                                            case "Bills":
                                                arrayList.add(0,new expenseModel(Name,"Bills",R.drawable.bill,expense, DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar1.getTime())));
                                                selectedCate = "";
                                                break;
                                            case "Maintenance":
                                                arrayList.add(0,new expenseModel(Name,"Maintenance",R.drawable.maintenance,expense, DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar1.getTime())));
                                                selectedCate = "";
                                                break;
                                            case "Other Expenses":
                                                arrayList.add(0,new expenseModel(Name,"Other Expenses",R.drawable.budget,expense, DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar1.getTime())));
                                                selectedCate = "";
                                                break;
                                        }
                                        Adapter adapter = new Adapter(MainActivity.this,arrayList);
                                        recyclerView.setAdapter(adapter);
                                        removeAllselected_bg();
                                        settotalExpence();
                                    }else {
                                        Toast.makeText(MainActivity.this, "Please Select Category!", Toast.LENGTH_SHORT).show();
                                    }

                                }
                                else {
                                    Toast.makeText(MainActivity.this, "Please Enter Expense ( Rs )!", Toast.LENGTH_SHORT).show();
                                }
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Please Enter Expense Name!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        entertainmentC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAllselected_bg();
                selectcategory(entertainmentC, "Entertainment");

            }
        });

        educationC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAllselected_bg();
                selectcategory(educationC, "Education");

            }
        });

        foodC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAllselected_bg();
                selectcategory(foodC, "Food");

            }
        });

        groceriesC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAllselected_bg();
                selectcategory(groceriesC, "Groceries");

            }
        });

        shoppingC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAllselected_bg();
                selectcategory(shoppingC, "Shopping");

            }
        });

        medicalC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAllselected_bg();
                selectcategory(medicalC, "Medical");

            }
        });

        billsC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAllselected_bg();
                selectcategory(billsC, "Bills");

            }
        });

        maintenanceC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAllselected_bg();
                selectcategory(maintenanceC, "Maintenance");

            }
        });

        otherXC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAllselected_bg();
                selectcategory(otherXC , "Other Expenses");

            }
        });

        settotalExpence();

    }


    private int getcategoryViseExpence(String C) {
        int total = 0 ;
        for (int i=0; i<arrayList.size();i++){
            if(Objects.equals(arrayList.get(i).SelectedCategory, C)){
                total += Integer.parseInt(arrayList.get(i).ExpenseMoney);
            }
        }
        return total;
    }

    private void selectcategory(LinearLayout selectedCategory, String str) {
        selectedCategory.setBackgroundResource(category_select_bg);
        selectedCate = str ;
    }
    private void removeAllselected_bg() {
        entertainmentC.setBackgroundResource(0);
        educationC.setBackgroundResource(0);
        foodC.setBackgroundResource(0);
        groceriesC.setBackgroundResource(0);
        shoppingC.setBackgroundResource(0);
        medicalC.setBackgroundResource(0);
        billsC.setBackgroundResource(0);
        maintenanceC.setBackgroundResource(0);
        otherXC.setBackgroundResource(0);
    }

    private void settotalExpence() {
        totalrs = 0 ;
        for (int i=0; i<arrayList.size();i++){
            totalrs += Integer.parseInt(arrayList.get(i).ExpenseMoney);
        }
        totalRSview.setText(String.valueOf(totalrs));
    }



    private void setdata() {
        arrayList.add(new expenseModel("Raju's College fee","Education",R.drawable.education,"1200", "Aug 10, 2023"));
        arrayList.add(new expenseModel("DDLJ Movies","Entertainment",R.drawable.popcorn,"1500", "Aug 9, 2023"));
        arrayList.add(new expenseModel("Recharge","Bills",R.drawable.bill,"299", "Aug 9, 2023"));
        arrayList.add(new expenseModel("chai cup","Groceries",R.drawable.grocery,"500", "Aug 6, 2023"));
        arrayList.add(new expenseModel("Salad","Food",R.drawable.ramen,"1000", "Aug 4, 2023"));
    }
}