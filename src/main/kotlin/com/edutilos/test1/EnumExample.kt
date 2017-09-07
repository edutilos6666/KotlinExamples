package com.edutilos.test1


enum class Color(val r:Int , val g:Int, val b:Int){
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    YELLOW(255, 255, 0);

    fun rgb():Int {
        return  (r*256 + g)*256 + b ;
    }

    override fun toString(): String {
        return "Color(r=$r, g=$g, b=$b)"
    }


}




fun main(args:Array<String>) {
    val cRed = Color.RED
    val cGreen = Color.GREEN
    val cBlue = Color.BLUE
    println(cRed)
    println(cGreen)
    println(cBlue)
    println(Color.YELLOW)

    var res =
            when (cRed) {
                Color.RED -> "red"
                Color.GREEN -> "green"
                Color.BLUE -> "blue"
                Color.YELLOW -> "yellow"
            }


    println(res)


    res =  when (cRed)  {
        Color.RED, Color.GREEN -> "red or green"
        Color.BLUE , Color.YELLOW -> "blue or yellow"
    }

    println(res)
}
