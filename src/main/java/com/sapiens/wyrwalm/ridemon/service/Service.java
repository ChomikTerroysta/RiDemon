package com.sapiens.wyrwalm.ridemon.service;

import lombok.extern.slf4j.Slf4j;

@org.springframework.stereotype.Service
@Slf4j
public class Service {
    private int counter = 0;

    public String getFromRest() {
        return null;
    }

    public <T> int toLog(T obj) {
        log.info(String.valueOf(obj), counter++);
        return counter;
    }
}
