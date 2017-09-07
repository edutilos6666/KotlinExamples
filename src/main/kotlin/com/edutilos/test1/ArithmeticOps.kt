package com.edutilos.test1



object ArithmeticOps  {
    @JvmStatic fun main(args:Array<String>) {
        test2()
    }


    @JvmStatic fun test2()  {
        val ops = Arithmetics(10f, 3f)
        println("add = ${ops.add()}")
        println("subtract = ${ops.subtract()}")
        println("multiply = ${ops.multiply()}")
        println("divide = ${ops.divide()}")
    }

    @JvmStatic fun test1() {
        val x = 10.0
        val y = 3.0
        val resAdd = add(x, y)
        val resSubtract = subtract(x,y)
        val resMultiply = multiply(x,y)
        val resDivide = divide(x,y)
        println("add = $resAdd")
        println("subtract = $resSubtract")
        println("multiply = $resMultiply")
        println("divide = $resDivide")
    }
}




fun add(x:Double, y:Double): Double {
    return x +y
}

fun subtract(x:Double, y:Double):Double {
    return x - y
}

fun multiply(x:Double, y:Double):Double {
    return x*y
}

fun divide(x:Double, y:Double):Double {
    return x / y
}



class Arithmetics {
    var a:Float = 0f
    var b:Float = 0f

    constructor(a:Float, b:Float) {
        this.a = a
        this.b = b
    }

    fun add():Float {
        return a+ b
    }

    fun subtract():Float {
        return a - b
    }

    fun multiply():Float {
        return a*b
    }

    fun divide(): Float {
        return a / b
    }
}

/*
fun main(args:Array<String>) {
    val x = 10.0
    val y = 3.0
    val resAdd = add(x, y)
    val resSubtract = subtract(x,y)
    val resMultiply = multiply(x,y)
    val resDivide = divide(x,y)
    println("add = $resAdd")
    println("subtract = $resSubtract")
    println("multiply = $resMultiply")
    println("divide = $resDivide")

}*/


