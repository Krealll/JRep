package com.krealll.restservice.model;

import java.util.List;

public class DivisionResultDT {
    private long totalAmount;
    private long uniqueRequests;
    private long badRequests;
    private int maximumQuotient;

    public int getMaximumQuotient() {
        return maximumQuotient;
    }

    public void setMaximumQuotient(int maximumQuotient) {
        this.maximumQuotient = maximumQuotient;
    }

    List<DivisionResult> divisionResultList;

    public List<DivisionResult> getDivisionResultList() {
        return divisionResultList;
    }

    public void setDivisionResultList(List<DivisionResult> divisionResultList) {
        this.divisionResultList = divisionResultList;
    }

    public DivisionResultDT(int maximumQuotient,long totalAmount, long uniqueRequests, long badRequests, List<DivisionResult> divisionResults){
        this.maximumQuotient=maximumQuotient;
        this.badRequests=badRequests;
        this.totalAmount=totalAmount;
        this.uniqueRequests=uniqueRequests;
        this.divisionResultList=divisionResults;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getUniqueRequests() {
        return uniqueRequests;
    }

    public void setUniqueRequests(long uniqueRequests) {
        this.uniqueRequests = uniqueRequests;
    }

    public long getBadRequests() {
        return badRequests;
    }

    public void setBadRequests(long badRequests) {
        this.badRequests = badRequests;
    }
}
