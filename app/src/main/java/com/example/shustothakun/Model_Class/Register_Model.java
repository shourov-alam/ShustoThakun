package com.example.shustothakun.Model_Class;

public class Register_Model {

    String name,mail,pass,phn,key;

    public Register_Model() {

    }


    public Register_Model(String name, String mail, String pass, String phn,String key) {
        this.name = name;
        this.mail = mail;
        this.pass = pass;
        this.phn = phn;
        this.key=key;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
