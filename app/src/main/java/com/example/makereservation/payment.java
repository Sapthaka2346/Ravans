package com.example.makereservation;

public class payment{

    private String Rid;
    private String Cno;
    private String Nam;
    private String Cvc;
    private String Exday;

    public payment() {
    }

    public String getRid() {
        return Rid;
    }

    public void setRid(String rid) {
        Rid = rid;
    }

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public String getNam() {
        return Nam;
    }

    public void setNam(String nam) {
        Nam = nam;
    }

    public String getCvc() {
        return Cvc;
    }

    public void setCvc(String cvc) {
        Cvc = cvc;
    }

    public String getExday() {
        return Exday;
    }

    public void setExday(String exday) {
        Exday = exday;
    }
}
