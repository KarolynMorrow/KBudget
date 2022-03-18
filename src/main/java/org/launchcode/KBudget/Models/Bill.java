package org.launchcode.KBudget.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Bill {

    @Id
    @GeneratedValue
    private int id;

    @DateTimeFormat(pattern="MM-dd-yyyy")
    @Column(name="due_date")
    //@FutureOrPresent(message = "Cannot be a past date")
    @NotNull
    private Date dueDate;


    @NotEmpty(message = "Cannot be empty")
    @Column(name= "bill_name")
    private String billName;


    @Column(name="bill_amount")
    @DecimalMin("0.05")
    //@NotEmpty(message = "Need bill amount")
    private Float billAmount;

//    @Column(name="bill_total")
//    private Float billTotal;

    public Bill(String billName, Date dueDate, Float billAmount, Float billTotal) {
        this.billName = billName;
        this.dueDate = dueDate;
        this.billAmount = billAmount;
//        this.billTotal = billTotal;
    }

    public Bill(){

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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Float getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Float billAmount) {
        this.billAmount = billAmount;
    }

//    public Float getBillTotal() {
//        return billTotal;
//    }
//
//    public void setBillTotal(Float billTotal) {
//        this.billTotal = billTotal;
//    }
}
