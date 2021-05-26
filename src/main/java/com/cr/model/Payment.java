package com.cr.model;

import java.util.Date;

public class Payment {

    private int idPayment;
    private int idPassenger;
    private double mount;
    private PayMethod payMethod;
    private Date date;

    public Payment() {
    }

    public Payment(int idPassenger, double mount, PayMethod payMethod, Date date) {
        this.idPassenger = idPassenger;
        this.mount = mount;
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

    public double getMount() {
        return mount;
    }

    public void setMount(double mount) {
        this.mount = mount;
    }

    public PayMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethod payMethod) {
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
        return String.format("Payment: {id_payment:%d, id_passenger:%d, mount:%d, pay_method:%s, date:%s}", idPayment,
                idPassenger, mount, payMethod, date);
    }

}