package com.bank.view;

import java.util.Scanner;

public class ApplicationView {
    private final Scanner scanner;

    public ApplicationView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessage(Object object){
        System.out.println(object);
    }

    public int readIntValue(){
        return scanner.nextInt();
    }

    public String readStringValue(){
        return scanner.next();
    }
}
