package org.lesson11.example2.second;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class Main {
    public static void main(String[] args) {
        final List<Product> products = Arrays.asList(
                new Product("One", Color.GREEN, Size.SMALL),
                new Product("Two", Color.GREEN, Size.BIG),
                new Product("Three", Color.BLUE, Size.BIG));

    }


}
