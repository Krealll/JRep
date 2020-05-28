package com.krealll.restservice.service;

public interface DivisionServiceInterface {
    public DivisionResult getDivisionResult(int dividend, int divider);

    public DivisionResult formResponse(int dividend, int divider);

    public int calculateQuotient(int dividend, int divider);

    public int calculateReminder(int dividend, int divider);
}
