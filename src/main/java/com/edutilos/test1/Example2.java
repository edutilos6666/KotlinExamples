package com.edutilos.test1;

/**
 * Created by edutilos on 07.09.17.
 */
public class Example2 {
    public static void main(String[] args) {
//        testArithmetics();
        testWorker();
    }

    private static void testWorker() {
        Worker w1, w2 ;
        w1 = new Worker(1, "foo", 10, 100.0, true);
        w2 = new Worker(2, "bar", 20 , 200.0, false);
        System.out.println(w1);
        System.out.println(w2);
        long id ;
        String name;
        int age ;
        double wage;
        boolean active;
        id = w1.getId();
        name = w1.getName();
        age = w1.getAge();
        wage = w1.getWage();
        active = w1.getActive();
        System.out.println("id = "+ id);
        System.out.println("name = "+ name);
        System.out.println("age = "+ age);
        System.out.println("wage = "+ wage);
        System.out.println("active = "+ active);

    }

    private static void testArithmetics() {
        Arithmetics ops = new Arithmetics(20, 10);
        System.out.println("add = " + ops.add());
        System.out.println("multiply = "+ ops.multiply());
    }
}
