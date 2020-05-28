package com.krealll.restservice.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class Counter {

    private AtomicInteger counter;

    public Counter(){counter=new AtomicInteger();}

    public synchronized void increment(){ counter.incrementAndGet();}

    public synchronized int getCounter(){return counter.get();}


}
