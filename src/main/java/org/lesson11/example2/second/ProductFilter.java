package org.lesson11.example2.second;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class ProductFilter {
//    public List<Product> filterBySize(List<Product> products, Size size) {
//        return Optional.ofNullable(products).orElse(emptyList()).stream()
//                .filter(x -> x.getSize() == size)
//                .collect(Collectors.toList());
//    }
//
//    public List<Product> filterByColor(List<Product> products, Color color) {
//        return Optional.ofNullable(products).orElse(emptyList()).stream()
//                .filter(x -> x.getColor() == color)
//                .collect(Collectors.toList());
//    }
//
//    public List<Product> filterByColorAndSize(List<Product> products, Color color, Size size) {
//        return Optional.ofNullable(products).orElse(emptyList()).stream()
//                .filter(x -> x.getColor() == color)
//                .filter(x -> x.getSize() == size)
//                .collect(Collectors.toList());
//    }

    public List<Product> filterByCriterion(List<Product> products, Criterion criterion) {
        return Optional.ofNullable(products).orElse(emptyList()).stream()
                .filter(criterion::test)
                .collect(Collectors.toList());
    }
}

interface Criterion {
    boolean test(Product product);
}

class SizeCriterion implements Criterion {
    private final Size size;

    SizeCriterion(Size size) {
        this.size = size;
    }

    @Override
    public boolean test(Product product) {
        return product.getSize() == size;
    }
}

class ColorCriterion implements Criterion {
    private final Color color;

    ColorCriterion(Color color) {
        this.color = color;
    }

    @Override
    public boolean test(Product product) {
        return product.getColor() == color;
    }
}

class ColorAndSizeCriterion implements Criterion {
    private final Size size;
    private final Color color;

    ColorAndSizeCriterion(Size size, Color color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public boolean test(Product product) {
        return product.getColor() == color &&
                product.getSize() == size;
    }
}

class CombinationCriterion implements Criterion {
    private final List<Criterion> criteria;

    CombinationCriterion(Criterion... criteria) {
        this.criteria = Arrays.asList(criteria);
    }

    @Override
    public boolean test(Product product) {
        return criteria.stream().map(x -> x.test(product)).anyMatch(x -> !x);
    }
}
