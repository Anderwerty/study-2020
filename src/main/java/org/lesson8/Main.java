package org.lesson8;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Comparator<String> comparator = (first, second) -> first.length() - second.length();
        Map<A, String> map = new HashMap<>();
        final A a = new A(10);
        map.put(a, "try to find");
        System.out.println(map.get(a));
        a.code = 100;

        System.out.println(map.get(a));
        final Set<Map.Entry<A, String>> entries = map.entrySet();
        final String value = entries.stream().filter(x -> x.getKey().equals(a)).findAny().get().getValue();
        System.out.println(value);
    }
}

class A {
    public int code;

    public A(int code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        A a = (A) o;
        return code == a.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}