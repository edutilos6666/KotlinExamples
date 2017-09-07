import com.edutilos.test1.Color
import com.edutilos.test1.Color.*

fun getColorString(color:Color): String {
    val res = when(color) {
        RED, GREEN -> "red or green"
        BLUE, YELLOW -> "blue or yelow"
    }

    return res
}

fun getColorsString(c1:Color, c2:Color):String {
    val res = when(setOf(c1, c2)) {
        setOf(RED, GREEN) -> "red and green"
        setOf(RED, BLUE) -> "red and blue"
        setOf(RED,YELLOW) -> "red and yellow"
        else -> throw Exception("Dirty color")
    }

    return res
}


fun whenWithoutArgument(c1:Color, c2:Color):String {
    val res = when {
        (c1 == RED && c2 == GREEN) ||
                (c1 == RED && c2 == BLUE) ||
                (c1 == RED && c2 == YELLOW) -> "red and something"

        (c1 == GREEN && c1 == RED) ||
                (c1 == GREEN && c2 == BLUE) ||
                (c1 == GREEN && c2 == YELLOW) -> "green and something"

        (c1 == BLUE && c2 == RED) ||
                (c1 == BLUE && c2 == GREEN) ||
                (c1 == BLUE && c2 == YELLOW) -> "blue and something"

        (c1 == YELLOW && c2 == RED) ||
                (c1 == YELLOW && c2 == GREEN) ||
                (c1 == YELLOW && c2 == BLUE) -> "yellow and something"

        else -> "unknown color combination"
    }

    return res
}



interface Expression
class Num(val value:Int): Expression
class Add(val left:Expression, val right:Expression): Expression
class Subtract(val left:Expression , val right:Expression): Expression
class Multiply(val left:Expression , val right:Expression): Expression

fun calculate(exp:Expression):Int {
   if(exp is Num) {
       val n = exp as Num
       return n.value
   }
    if(exp is Add) {
        return calculate(exp.left) + calculate(exp.right)
    }

    if(exp is Subtract) {
        return calculate(exp.left) - calculate(exp.right)
    }

    if(exp is Multiply) {
        return calculate(exp.left) * calculate(exp.right)
    }

    throw IllegalArgumentException("Unknown argument")
}


fun calculate2(exp:Expression):Int {
        if(exp is Num) {
            val n = exp as Num
            return n.value
        }
        else if(exp is Add) {
            return calculate(exp.left) + calculate(exp.right)
        }

        else if(exp is Subtract) {
            return calculate(exp.left) - calculate(exp.right)
        }

        else if(exp is Multiply) {
            return calculate(exp.left) * calculate(exp.right)
        }

        else throw IllegalArgumentException("Unknown argument")
    }


fun calculate3(exp:Expression):Int =
    when (exp) {
        is Num -> exp.value
        is Add -> calculate3(exp.left) + calculate3(exp.right)
        is Subtract -> calculate3(exp.left) - calculate3(exp.right)
        is Multiply -> calculate3(exp.left)* calculate3(exp.right)
        else -> throw IllegalArgumentException("unknown argument")
    }

fun calculate4(exp:Expression):Int =
        when (exp) {
            is Num -> {
                println("num value = ${exp.value}")
                exp.value
            }
            is Add -> {
                val left = calculate4(exp.left)
                val right = calculate4(exp.right)
                println("add = ${left + right}")
                left + right
            }
            is Subtract -> {
                val left = calculate4(exp.left)
                val right = calculate4(exp.right)
                println("subtract = ${left - right}")
                left - right
            }
            is Multiply -> {
                val left = calculate4(exp.left)
                val right = calculate4(exp.right)
                println("multiply = ${left * right}")
                left * right
            }
            else -> throw IllegalArgumentException("unknown argument")
        }



fun foobar(n:Int) = when {
    n% 3 == 0 -> "foo"
    n% 5 == 0 -> "bar"
    n% 15 == 0 -> "foobar"
    else -> "$n"
}

fun main(args:Array<String>) {
    println(getColorString(RED))
    println(getColorString(YELLOW))
    println("")
    println(getColorsString(RED, GREEN))
   // println(getColorsString(GREEN, YELLOW))
    println(getColorsString(RED, BLUE))
   // println(getColorsString(RED, RED))
    val expr = Add(Multiply(Num(3), Num(5)), Multiply(Num(10), Num(30)))
    println(calculate(expr))
    val expr2 = Subtract(Multiply(Num(5),Num(5)), Multiply(Num(4),Num(4)))
    println(calculate2(expr2))
    println(calculate3(expr2))
    println(calculate4(expr2))
    println(foobar(10))
    println(foobar(15))
}
