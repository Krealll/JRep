package com.krealll.restservice.model;

import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class DivisionResultComparator implements Comparator<DivisionResult> {

    @Override
    public int compare(DivisionResult o1, DivisionResult o2) {
        return o1.getQuotient().compareTo(o2.getQuotient());
    }
}
