package com.tuling.jucdemo.test;

import java.time.LocalDate;

public class JiJInData {
    LocalDate date ;
    int intdata;
    String code;
    double zhangdie;

    @Override
    public String toString() {
        return "JiJInData{" +
                "date=" + date +
                ", intdata=" + intdata +
                ", code='" + code + '\'' +
                ", zhangdie=" + zhangdie +
                '}';
    }

    public void setZhangdie(double zhangdie) {
        this.zhangdie = zhangdie;
    }

    public double getZhangdie() {
        return zhangdie;
    }

    public JiJInData(LocalDate date, int intdata, String code,  double zhangdie) {
        this.date = date;
        this.intdata = intdata;
        this.code = code;
        this.zhangdie = zhangdie;
    }


    public LocalDate getDate() {
        return date;
    }

    public int getIntdata() {
        return intdata;
    }

    public String getCode() {
        return code;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setIntdata(int intdata) {
        this.intdata = intdata;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
