package com.example.demo;

import org.springframework.web.client.RestTemplate;

public class PressureScript {
    public static void main(String[] args) {
        new RestTemplate().getForObject("http://localhost:8080", String.class);
        int count = 30;
        long pre = System.currentTimeMillis();
        while (count-- > 0) {
            new RestTemplate().getForObject("http://localhost:8080", String.class);
        }
        System.out.println(System.currentTimeMillis() - pre);
    }
}
