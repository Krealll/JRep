package com.krealll.restservice.service;

public class Division {
    private int dividend;
    private int divider;

    public Division(int dnd, int ddr){dividend=dnd; divider=ddr;}

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivider() {
        return divider;
    }

    public void setDivider(int divider) {
        this.divider = divider;
    }
}
