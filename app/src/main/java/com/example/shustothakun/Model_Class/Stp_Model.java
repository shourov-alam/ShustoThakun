package com.example.shustothakun.Model_Class;

public class Stp_Model {

    String date,kilo,step;

    public Stp_Model() {

    }

    public Stp_Model(String date,String kilo,String step) {
        this.date = date;
        this.kilo = kilo;
        this.step=step;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKilo() {
        return kilo;
    }

    public void setKilo(String kilo) {
        this.kilo = kilo;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }
}
