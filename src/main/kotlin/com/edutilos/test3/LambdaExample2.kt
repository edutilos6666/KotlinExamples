package com.edutilos.test3


object LambdaExample2 {
    @JvmStatic fun main(args:Array<String>) {
       test4()
    }



    @JvmStatic fun test1() {
        var numbers = listOf(1, 2, 3, 4, 5)
        println("<<numbers>>")
        numbers.forEach {
            print("$it ; ")
        }
        println()
        var names = listOf("foo", "bar", "bim", "pako")
        println("<<names>>")
        names.forEach {
            print("$it; ")
        }
        println()
    }


    @JvmStatic fun test2()  {
        var serverInfos:Int = 0
        var oks:Int = 0
        var redirection:Int = 0
        var clientErrors:Int = 0
        var serverErrors:Int = 0

        var responses = listOf("100", "102", "200", "202", "300", "303", "401", "405", "500", "510", "511")
        responses.forEach {response ->
            val res = response.toInt()
            when {
                (res>=100 && res< 200) -> serverInfos++
                (res>=200 && res < 300) -> oks++
                (res>=300 && res < 400) -> redirection++
                (res>=400 && res < 500) -> clientErrors++
                (res>=500 && res < 600) -> serverErrors++
            }
        }

        println("<<response statistics>>")
        println("serverInfos = $serverInfos")
        println("oks = $oks")
        println("redirection = $redirection")
        println("clientErrors = $clientErrors")
        println("serverErrors = $serverErrors")
    }


    @JvmStatic fun combinedArithmetics(a:Double, b:Double,
                                       add:(Double,Double)->Double,
                                       subtract:(Double,Double)->Double,
                                       multiply:(Double,Double)->Double,
                                       divide:(Double,Double)->Double) {
        println("<<arithmetics>>")
        println("add = ${add(a,b)}")
        println("subtract = ${subtract(a,b)}")
        println("multiply = ${multiply(a,b)}")
        println("divide = ${divide(a,b)}")
    }




    @JvmStatic fun test3() {
        fun add(a:Double, b:Double):Double {
            return a+b
        }
        fun subtract(a:Double, b:Double):Double {
            return a - b
        }
        combinedArithmetics(10.0, 3.0,
                add = ::add,
                subtract = ::subtract,
                multiply = {x:Double,y:Double-> x*y},
                divide = {x:Double, y:Double-> x/y})
    }



    data class Person(val id:Long, val name:String , val age:Int)
    @JvmStatic fun test4() {
        val createPerson = ::Person
        val p1 = createPerson(1L, "foo", 10)
        println(p1)
    }
}

