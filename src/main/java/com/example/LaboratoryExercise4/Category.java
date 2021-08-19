package com.example.LaboratoryExercise4;

public class Category {

    private String clientno;
    private String clientname;
    private String loanamount;
    private String years;
    private String loantype;

    public Category(String clientno, String clientname, String loanamount, String years, String loantype){
        this.clientno = clientno;
        this.clientname = clientname;
        this.loanamount = loanamount;
        this.years = years;
        this.loantype = loantype;

    }

    public String getClientno() {
        return clientno;
    }

    public void setClientno(String clientno) {
        this.clientno = clientno;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(String loanamount) {
        this.loanamount = loanamount;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getLoantype() {
        return loantype;
    }

    public void setLoantype(String loantype) {
        this.loantype = loantype;
    }

/*
    public String getCatcode() { return catcode; }
    public void setCatcode(String catcode) { this.catcode = catcode; }*/
}
