package com.demo.MyCategoryService.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product {
    private int pid;
    private String pname;
    private int qty;
    private double price;
    private LocalDate expdate;
    private int cid;

    public Product() {
    }

    public Product(int pid, String pname, int qty, double price, LocalDate expdata, int cid) {
        this.pid = pid;
        this.pname = pname;
        this.qty = qty;
        this.price = price;
        this.expdate = expdata;
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpdata() {
        return expdate;
    }

    public void setExpdata(LocalDate expdata) {
        this.expdate = expdata;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        String str= expdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", expdata=" + str+
                ", cid=" + cid +
                '}';
    }
}

