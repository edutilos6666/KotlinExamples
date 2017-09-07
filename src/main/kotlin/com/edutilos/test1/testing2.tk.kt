package com.edutilos.test1
import java.util.TreeMap

fun main(args: Array<String>) {
    for(i in 10 downTo 1 step 2) {
        println("number = $i")
    }

    println()
    for(i in 1 until 10 step 2) {
        println("number = $i")
    }

    println()
    testTreeMap()
    println()
    println("a isLetter ? ${isLetter('a')}")
    println("a is not digit? ${isNotDigit('a')}")
    println("1 isLetter ? ${isLetter('1')}")
    println("1 is not digit ? ${isNotDigit('1')}")
    println("recognize(a) = ${recognize('a')}")
    println("recognize(1) = ${recognize('1')}")
    //println("recognize(#) = ${recognize('#')}")
}


fun testTreeMap() {
    var map = TreeMap<Char, String>()
    for(letter in 'A'..'F'){
        val code = Integer.toBinaryString(letter.toInt())
        map[letter] = code
    }

    for((letter , code) in map) {
        println("$letter => $code")
    }
}

fun isLetter(x: Char) =  x in 'a'..'z' || x in 'A'..'Z'
fun isNotDigit(x:Char) = x !in '0'..'9'
fun recognize (x:Char) = when(x) {
    in '0'..'9'-> "digit"
    in 'a'..'z',  in 'A'..'Z' -> "letter"
    else -> throw Exception("not recognized")
}