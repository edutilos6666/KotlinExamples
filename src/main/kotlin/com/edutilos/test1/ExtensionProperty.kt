package com.edutilos.test1


fun main(args: Array<String>) {
 val str = "foobar"
    println("first char = ${str.firstChar}")
    println("last char = ${str.lastChar}")
    val strBuilder = StringBuilder("edutilos")
    println("first char = ${strBuilder.firstChar}")
    strBuilder.firstChar = '#'
    println("first char(after modification) = ${strBuilder.firstChar}")
    println("last char = ${strBuilder.lastChar}")
    strBuilder.lastChar = '~'
    println("last char(after modification) = ${strBuilder.lastChar}")
    println(strBuilder.toString())
}

//string example
val String.firstChar:Char
   get() = get(0)

val String.lastChar:Char
   get() = get(length-1)

//StringBuilder example
var StringBuilder.firstChar:Char
  get() = get(0)
set(ch:Char) = setCharAt(0, ch)

var StringBuilder.lastChar:Char
  get() = get(length -1)
  set(ch:Char) = setCharAt(length-1, ch)


