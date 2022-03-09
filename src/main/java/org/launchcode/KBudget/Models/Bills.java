package org.launchcode.KBudget.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bills {

    @Id
    @GeneratedValue
    private int id;

    private String billName;
    private String dueDate;
    private Float billAmount;
    private Float billTotal;

    public Bills(String billName, String dueDate, Float billAmount, Float billTotal) {
        this.billName = billName;
        this.dueDate = dueDate;
        this.billAmount = billAmount;
        this.billTotal = billTotal;
    }

    public Bills(){

    }

    public int getId() {
        return id;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Float getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Float billAmount) {
        this.billAmount = billAmount;
    }

    public Float getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(Float billTotal) {
        this.billTotal = billTotal;
    }
}
