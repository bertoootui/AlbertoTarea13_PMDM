package com.example.albertotarea13_pmdm;

public class Parking {
    private int total = 50;
    private int disc = 10;
    private int abon = 15;
    private int plazasdisp = total - disc - abon;
    private int dispabon = abon;
    private int dispdisc = disc;


    public Parking(){};

    public int getPlazasdisp() {
        return plazasdisp;
    }

    public void setPlazasdisp(int plazasdisp) {
        this.plazasdisp = plazasdisp;
    }

    public int getDispabon() {
        return dispabon;
    }

    public void setDispabon(int dispabon) {
        this.dispabon = dispabon;
    }

    public int getDispdisc() {
        return dispdisc;
    }

    public void setDispdisc(int dispdisc) {
        this.dispdisc = dispdisc;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDisc() {
        return disc;
    }

    public void setDisc(int disc) {
        this.disc = disc;
    }

    public int getAbon() {
        return abon;
    }

    public void setAbon(int abon) {
        this.abon = abon;
    }
}
