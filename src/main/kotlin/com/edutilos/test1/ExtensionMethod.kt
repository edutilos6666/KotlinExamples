package com.edutilos.test1


open class View {
    open fun click() = println("View was clicked.")
}


class Button:View() {
    override fun click() = println("Button was clicked.")
}


fun View.showOff()  = println("I'm a View instance")
fun Button.showOff() = println("I'm a Button instance")

fun main(args: Array<String>) {
    val v:View = Button()
    v.click()
    v.showOff()
    println(listOf(*args))
}
