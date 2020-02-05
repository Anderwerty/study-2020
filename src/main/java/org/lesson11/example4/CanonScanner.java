package org.lesson11.example4;

public class CanonScanner implements Scanner {
    @Override
    public String scan(Document document) {
        return "scanner";
    }

    @Override
    public Document copy(Document document) {
        throw new UnsupportedOperationException();
    }

}
