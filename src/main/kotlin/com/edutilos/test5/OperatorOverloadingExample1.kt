package com.edutilos.test5

object OperatorOverloadingExample1  {
    @JvmStatic
    fun main(args: Array<String>) {
        test7()
    }




    //range priority
    fun test7() {
        val n = 9
        println(0..n)
        (0..n).forEach {print(it)}
        println()
    }

    data class Point2(var x:Int, var y:Int)
    data class Rectangle2(val upperLeft:Point2 , val lowerRight: Point2) {
        operator fun contains(p:Point2):Boolean {
            return p.x in upperLeft.x until lowerRight.x  &&
                    p.y in upperLeft.y until lowerRight.y
        }
    }

    //contains test
    private fun test6() {
        val rect = Rectangle2(Point2(10, 20), Point2(50, 50))
        val p1 = Point2(20, 40)
        val p2 = Point2(8, 30)
        val p3 = Point2(3, 3)
        println("p1 in rect = ${p1 in rect}")
        println("p2 in rect = ${p2 in rect}")
        println("p3 in rect = ${p3 in rect}")
    }

    //index operator
    private fun test5() {
        val p1 = Point(1.0, 3.0)
        println("p1[0] = ${p1[0]}")
        println("p1[1] = ${p1[1]}")
       // println("p1[2] = ${p1[2]}")
        println()
        p1[0] = 20.0
        p1[1] = 40.0
        println("p1[0] = ${p1[0]}")
        println("p1[1] = ${p1[1]}")
        println()
    }

    //unary operators
    private fun test4() {
        val p = Point(1.0, 1.0)
        val pUnaryMinus = -p
        val pUnaryPlus = +pUnaryMinus
        val pNot = !p
        var pInc = p
        pInc++
        var pDec = p
        pDec--
        println("p = $p")
        println("pUnaryMinus = $pUnaryMinus")
        println("pUnaryPlus = $pUnaryPlus")
        println("pNot = $pNot")
        println("pInc = $pInc")
        println("pDec = $pDec")
    }

    //compound assignment
    private fun test3() {
        var p1 = Point(1.0, 1.0)
        p1 += Point(2.0, 2.0)
        println(p1)

        //ArrayList example
        val numbers = ArrayList<Int>()
        numbers += 10
        numbers += 20
        numbers += 30
        numbers += listOf(40, 50)
        println(numbers)
    }

    //binary operators
    private fun test2() {
        println(0x0F and 0xF0)
        println(0x0F or 0xF0)
        println(0x1 shl 4)
        println(0x10 shr 4)
    }

    /*
    https://kotlinlang.org/docs/reference/operator-overloading.html
    a + b	a.plus(b)
a - b	a.minus(b)
a * b	a.times(b)
a / b	a.div(b)
a % b	a.rem(b), a.mod(b) (deprecated)
a..b	a.rangeTo(b)


a > b	a.compareTo(b) > 0
a < b	a.compareTo(b) < 0
a >= b	a.compareTo(b) >= 0
a <= b	a.compareTo(b) <= 0
     */
    data class Point(var x:Double, var y:Double) {
        operator fun plus(other:Point):Point {
            return Point(x + other.x, y + other.y)
        }

        operator fun minus(other:Point):Point {
            return Point(x-other.x , y-other.y)
        }
        operator fun times(other:Point):Point {
            return Point(x*other.x, y*other.y)
        }
        operator fun div(other:Point):Point {
            return Point(x/other.x, y/other.y)
        }

        operator fun rem(other:Point):Point {
            return Point(x%other.x, y%other.y)
        }


        //unary operators
        operator fun unaryMinus():Point {
            return Point(-x, -y)
        }

        operator fun unaryPlus():Point {
            return Point(+x, +y)
        }

        operator fun not():Point {
            val _x = x-1.0
            val _y = y -1.0
            return Point(_x, _y)
        }

        // inc() , dec()
        operator fun inc():Point {
            val _x = x+1.0
            val _y = y +1.0
            return Point(_x, _y)
        }

        operator fun dec():Point {
            val _x = x-1.0
            val _y = y-1.0
            return Point(_x, _y)
        }


        //index operator
        operator fun get(index:Int):Double {
            return when (index) {
                0 -> x
                1 -> y
                else -> throw IndexOutOfBoundsException("$index is out of bound")
            }
        }

        operator fun set(index:Int, value:Double) {
            when(index) {
                0-> x = value
                1 -> y = value
                else -> throw IndexOutOfBoundsException("$index is out of bound")
            }
        }

    }


    data class Rectangle(val width:Double, val height:Double) {
        fun area():Double {
            return width*height
        }
        operator fun compareTo(other:Rectangle):Int {
            val a1 = area()
            val a2 = other.area()
            var res = 0
            if(a1 > a2) res = 1
            else if(a1 < a2) res = -1
            return res
        }

        operator override fun equals(other:Any?):Boolean {
            if(other == null || other !is Rectangle) return false
            val otherRect = other as Rectangle
            if(width == otherRect.width && height == otherRect.height) return true
            return false
        }
    }



    private fun test1() {
        val p1 = Point(3.0, 3.0)
        val p2 = Point(2.0, 2.0)
        val pPlus = p1 + p2
        val pMinus = p1 - p2
        val pTimes = p1*p2
        val pDiv = p1/p2
        val pRem = p1%p2
        println("p1 = $p1")
        println("p2 = $p2")
        println("pPlus = $pPlus")
        println("pMinus = $pMinus")
        println("pTimes = $pTimes")
        println("pDiv = $pDiv")
        println("pRem = $pRem")
        println()

        val r1 = Rectangle(10.0, 10.0)
        val r2 = Rectangle(15.0, 15.0)
        val lt = r1 < r2
        val le = r1 <= r2
        val gt = r1 > r2
        val ge = r1 >= r2
        val eq = r1 == r2
        val ne = r1 != r2
        println("r1 = $r1")
        println("r2 = $r2")
        println("lt = $lt")
        println("le = $le")
        println("gt = $gt")
        println("ge = $ge")
        println("eq = $eq")
        println("ne = $ne")
    }

}
