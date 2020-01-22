package org.lesson4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;

public class Calculator {
    private static final Map<String, ToIntBiFunction<Integer, Integer>> OPERATOR_TO_OPERATION
            = new HashMap<>();

    static {
        OPERATOR_TO_OPERATION.put("+", Integer::sum);
        OPERATOR_TO_OPERATION.put("-", (a, b) -> a - b);
    }

    public int calculate(int a, String operator, int b) {
        return OPERATOR_TO_OPERATION.get(operator).applyAsInt(a, b);
    }
}

