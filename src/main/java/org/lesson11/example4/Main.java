package org.lesson11.example4;

public class Main {
    public static void main(String[] args) {
        final Printer printer = new CanonPrinter();

        final String print = printer.print(new Document());
    }
}
