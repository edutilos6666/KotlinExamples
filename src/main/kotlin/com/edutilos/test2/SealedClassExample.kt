package com.edutilos.test2

object SealedClassExample {
    @JvmStatic
    fun main(args: Array<String>) {
        testExpr1()
    }


    @JvmStatic fun testExpr1() {
        val expr1 = Expr.Add(Expr.Multiply(Expr.Num(3.0), Expr.Num(3.0)),
                Expr.Multiply(Expr.Num(4.0), Expr.Num(4.0)))

        println(eval(expr1))


        val exprDivide = Expr.Divide(Expr.Multiply(Expr.Num(10.0),Expr.Num(6.0)), Expr.Num(4.0))
        val exprAdd = Expr.Add(exprDivide, Expr.Num(6.0))
        val exprSubtract = Expr.Subtract(exprAdd, Expr.Num(1.0))
        println(eval(exprSubtract))
    }


    sealed class Expr {
        class Num(val value:Double):Expr()
        class Add(val left:Expr, val right:Expr):Expr()
        class Subtract(val left:Expr, val right:Expr):Expr()
        class Multiply(val left:Expr, val right:Expr):Expr()
        class Divide(val left:Expr, val right:Expr):Expr()
    }


    @JvmStatic fun eval(expr:Expr):Double  =
        when(expr) {
            is Expr.Num -> expr.value
            is Expr.Add -> eval(expr.left)+ eval(expr.right)
            is Expr.Subtract -> eval(expr.left)- eval(expr.right)
            is Expr.Multiply -> eval(expr.left) * eval(expr.right)
            is Expr.Divide -> eval(expr.left) / eval(expr.right)
        }

}
