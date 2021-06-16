package com.cr.model;

import java.util.Date;

public class Payment {

    private int idPayment;
    private int idPassenger;
    private double amount;
    private String payMethod;
    private Date date;

    public Payment() {
    }

    public Payment(int idPassenger, double amount, String payMethod, Date date) {
        this.idPassenger = idPassenger;
        this.amount = amount;
        this.payMethod = payMethod;
        this.date = date;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public int getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(int idPassenger) {
        this.idPassenger = idPassenger;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("Payment: {id_payment:%d, id_passenger:%d, amount:%d, pay_method:%s, date:%s}", idPayment,
                idPassenger, amount, payMethod, date);
    }

}