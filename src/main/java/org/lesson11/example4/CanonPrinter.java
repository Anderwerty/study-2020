package org.lesson11.example4;

public class CanonPrinter implements Printer {
    @Override
    public String print(Document document) {
        return document.toString();
    }
}
