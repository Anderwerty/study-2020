package org.lesson11.example3;

public class Main {
    public static void main(String[] args) {
        final Rectangle rectangle = new Rectangle(1, 2);
        final Rectangle square = new Square(1);

        System.out.println("rectangle area: " + rectangle.calcArea());
        System.out.println("square area: " + square.calcArea());

        rectangle.setA(3);
        square.setA(3);

        System.out.println("rectangle area: " + rectangle.calcArea());
        System.out.println("square area: " + square.calcArea());
    }
}
