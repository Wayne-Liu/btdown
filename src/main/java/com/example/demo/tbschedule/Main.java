package com.example.demo.tbschedule;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("classpath:spring-schedule.xml");
        context.start();
        System.out.println("Tbschedule is started!");
        System.in.read();
    }
}
