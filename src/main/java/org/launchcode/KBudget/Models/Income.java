package org.launchcode.KBudget.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Income {
    @Id
    @GeneratedValue
    private int id;

    private Float payAmount;
    private String name;
    private String payDate;
    private Float incomeTotal;


    public Income(Float payAmount, String name, String payDate, Float incomeTotal) {
        this.payAmount = payAmount;
        this.name = name;
        this.payDate = payDate;
        this.incomeTotal = incomeTotal;
    }
    public Income(){

    }

    public int getId() {
        return id;
    }

    public Float getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Float payAmount) {
        this.payAmount = payAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public Float getIncomeTotal() {
        return incomeTotal;
    }

    public void setIncomeTotal(Float incomeTotal) {
        this.incomeTotal = incomeTotal;
    }
}
