package de.neuefische.java.hhjava243springweb.utils;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdService {

    public String randomId() {
        System.out.println("RANDOM ID");
        return UUID.randomUUID().toString();
    }
}
