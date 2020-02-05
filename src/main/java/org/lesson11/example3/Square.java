package org.lesson11.example3;

// class A extends SuperA, SuperB
public class Square extends Rectangle {
    public Square(int a) {
        super(a, a);
    }

    @Override
    public void setA(int a) {
        super.setA(a);
        super.setB(a);
    }

    @Override
    public void setB(int b) {
        setA(b);
    }
}
