package com.edutilos.test6;

import kotlin.jvm.functions.Function2;

/**
 * Created by edutilos on 08.09.17.
 */
public class FunctionTypeTest1 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        double x = 10 , y = 3;
        FunctionTypeExample1.binaryArithmeticOp(x, y, (a,b)->a+b);
        FunctionTypeExample1.binaryArithmeticOp(x, y, (a,b)->a-b);
        FunctionTypeExample1.binaryArithmeticOp(x, y, new Function2<Double, Double, Double>() {
            @Override
            public Double invoke(Double a, Double b) {
                return a*b;
            }
        });
    }
}
