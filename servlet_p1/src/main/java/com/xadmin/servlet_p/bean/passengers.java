package com.xadmin.servlet_p.bean;

public class passengers {
    protected int PI;
    protected String PName;
    protected String PNat;
    protected String PGen;
    protected String PPass;
    protected String PAdd;
    protected int Pphone;

    public passengers(String PName, String PNat, String PGen, String PPass, String PAdd, int Pphone) {
    	 this.PName = PName;
         this.PNat = PNat;
         this.PGen = PGen;
         this.PPass = PPass;
         this.PAdd = PAdd;
         this.Pphone = Pphone;
    }

    public passengers(int PI, String PName, String PNat, String PGen, String PPass, String PAdd, int Pphone) {
        this.PI = PI;
        this.PName = PName;
        this.PNat = PNat;
        this.PGen = PGen;
        this.PPass = PPass;
        this.PAdd = PAdd;
        this.Pphone = Pphone;
    }

    // Getters and Setters
    public int getPI() {
        return PI;
    }

    public void setPI(int PI) {
        this.PI = PI;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getPNat() {
        return PNat;
    }

    public void setPNat(String PNat) {
        this.PNat = PNat;
    }

    public String getPGen() {
        return PGen;
    }

    public void setPGen(String PGen) {
        this.PGen = PGen;
    }

    public String getPPass() {
        return PPass;
    }

    public void setPPass(String PPass) {
        this.PPass = PPass;
    }

    public String getPAdd() {
        return PAdd;
    }

    public void setPAdd(String PAdd) {
        this.PAdd = PAdd;
    }

    public int getPphone() {
        return Pphone;
    }

    public void setPphone(int Pphone) {
        this.Pphone = Pphone;
    }
}
