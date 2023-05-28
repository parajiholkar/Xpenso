package com.project1.xpensemanager;

public class expenseModel {
    String expensename , discription ;
    int img ;
    String ExpenseMoney ;
    public expenseModel(String expensename, String discription , int img, String expenseMoney){
        this.expensename = expensename;
        this.discription = discription;
        this.img = img;
        this.ExpenseMoney = expenseMoney;
    }
}
