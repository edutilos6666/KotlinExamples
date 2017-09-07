package com.edutilos.test3


object FunctionalInterfaceExample1 {
    @JvmStatic
    fun main(args: Array<String>) {
        test2()
    }

    fun runnable1(): Runnable  {
        return Runnable {println("hello world!")}
    }
    @JvmStatic private fun test1() {
        runnable1().run()
    }



    fun add(): AddInterface = AddInterface {a,b ->  a+ b}
    fun subtract():SubtractInterface = SubtractInterface {a,b-> a-b}
    fun multiply():MultiplyInterface = MultiplyInterface {a,b->a*b}
    fun divide():DivideInterface = DivideInterface{a,b->a/b}

    @JvmStatic private fun test2() {
        var a:Double = 10.0
        var b:Double = 3.toDouble()
        println("add = ${add().run(a,b)}")
        println("subtract = ${subtract().run(a,b)}")
        println("multiply = ${multiply().run(a,b)}")
        println("divide = ${divide().run(a,b)}")
    }
}
