package com.cr.model;

import java.util.Date;

public class Payment extends Identity {
    private int idPassenger;
    private double mount;
    private PayMethod payMethod;
    private Date date;

    public Payment() {
    }

    public Payment setIdPassenger(int idPassenger) {
        this.idPassenger = idPassenger;
        return this;
    }

    public int getIdPassenger() {
        return this.idPassenger;
    }

    public Payment(int mount, PayMethod payMethod, Date date) {
        this.mount = mount;
        this.payMethod = payMethod;
        this.date = date;
    }

    public Payment setMount(double mount) {
        this.mount = mount;
        return this;
    }

    public double getMount() {
        return this.mount;
    }

    public Payment setPayMethod(int payMethod) {
        this.payMethod = PayMethod.valueOf(payMethod);
        return this;
    }

    public PayMethod getPayMethod() {
        return this.payMethod;
    }

    public Payment setDate(Date date) {
        this.date = date;
        return this;
    }

    public Date getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return String.format("Payment: {id_payment:%d, id_passenger:%d, mount:%d, pay_method:%s, date:%s}", getId(),
                idPassenger, mount, payMethod, date);
    }

}