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
public class Income {
    @Id
    @GeneratedValue
    private int id;

    @Column(name="pay_amount")
    @DecimalMin(value="0.05")
    private Float payAmount;

    @NotEmpty(message = "Enter an Income name")
    @Column(name="name")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="pay_date")
    @NotNull
    private Date payDate;



    public Income(Float payAmount, String name, Date payDate) {
        this.payAmount = payAmount;
        this.name = name;
        this.payDate = payDate;

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

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

}
