package com.edutilos.test1


fun max (a:Int , b:Int) :Int {
    return if(a > b) a else b
}

fun min(a:Int, b:Int) :Int = if(a>b) b else a
fun min2(a:Int, b:Int) = if(a>b) b else a

/*
fun main(args:Array<String>) {
    val a = 10
    val b = 20
    println("max = ${max(a,b)}")
    println("min = ${min(a,b)}")
    println("min2 = ${min2(a,b)}")
}*/

fun main(args:Array<String>) {
    val name = if(args.size > 0 ) args[0] else "Kotlin"
    println("Hello $name")
}



