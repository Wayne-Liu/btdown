package com.example.demo.tbschedule.demain;

import java.io.Serializable;

public class BillRule implements Serializable {

    private int id;
    private String billName;
    private String isDel;

    public BillRule(int id, String billName, String isDel) {
        this.id = id;
        this.billName = billName;
        this.isDel = isDel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "BillRule{" +
                "id=" + id +
                ", billName='" + billName + '\'' +
                ", isDel='" + isDel + '\'' +
                '}';
    }
}
