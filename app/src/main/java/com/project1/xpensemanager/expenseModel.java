package com.project1.xpensemanager;

public class expenseModel {
    String expensename , SelectedCategory, Date ;
    int img ;
    String ExpenseMoney ;
    public expenseModel(String expensename, String selectedCategory , int img, String expenseMoney, String date){
        this.expensename = expensename;
        this.SelectedCategory = selectedCategory;
        this.img = img;
        this.ExpenseMoney = expenseMoney;
        this.Date = date;
    }
}
