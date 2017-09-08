@file:JvmName("FunctionTypeExample1")
package com.edutilos.test6



object FunctionTypeExample1 {
    @JvmStatic
    fun main(args: Array<String>) {
        test7()
    }

    @JvmStatic
    fun binaryArithmeticOp(x:Double, y:Double, algo: (Double,Double)->Double) {
        val res = algo(x,y)
        println("res = $res")
    }


    data class Person(val id:Long , val name:String, val age:Int)
    //return function from function 2
    private fun test7() {
        fun getCompoundPersonFilter():
                (Person, Boolean, Boolean, Boolean)->Boolean {
            val resFn = { person: Person, activateF1:Boolean ,
                activateF2:Boolean, activateF3:Boolean ->
                val idFilter: (Person) -> Boolean = { p ->
                    p.id > 0 && p.id < 10
                }

                val nameFilter: (Person) -> Boolean = { p ->
                    p.name in listOf("foo", "bar", "bim") ||
                            p.name in listOf("FOO", "BAR", "BIM")
                }

                val ageFilter: (Person) -> Boolean = { p ->
                    p.age > 10 && p.age < 100
                }


                var res1 = idFilter.invoke(person) || !activateF1
                var res2 = nameFilter(person) || !activateF2
                var res3 = ageFilter(person) || !activateF3
                res1 && res2 && res3
            }

            return resFn
        }


        val people = listOf(
                Person(1, "foo", 10),
                Person(2, "FOO", 20),
                Person(10, "bar", 50),
                Person(3, "bim", 300),
                Person(20, "new_bim", 200)
        )

        var compoundFilter = getCompoundPersonFilter()
        var f1 = people.filter {p ->
             compoundFilter(p, true, true, true)
        }
        println(f1)

        f1 = people.filter {p ->
            compoundFilter(p, false, false, true)
        }
        println(f1)
    }



    enum class Delivery {STANDARD , EXPRESS}
    data class Order (val itemCount:Int)
    //return function from function
    private fun test6() {
        fun getShippingCalculator(delivery:Delivery) : (Order)-> Double {
            val res = when(delivery) {
                Delivery.STANDARD -> {order:Order -> 1.2*order.itemCount}
                Delivery.EXPRESS -> {order:Order -> 6 + 2.1*order.itemCount}
            }

            return res
        }

        val calcStandard = getShippingCalculator(Delivery.STANDARD)
        val calcExpress = getShippingCalculator(Delivery.EXPRESS)

        println("standard cost = ${calcStandard(Order(10))}")
        println("express cost = ${calcExpress(Order(10))}")
    }


    //default and null values for  function types
    private fun test5()  {
        fun <T> Collection<T>.joinToString(prefix:String = "[",
                                           suffix:String = "]",
                                           separator:String = " ",
                                           transform: ((T)->String)? = null):String {
            val sb = StringBuilder(prefix)
            this.forEachIndexed {index:Int, value:T ->
                if(index > 0 ) sb.append(separator)
                sb.append(transform?.invoke(value)?:"dummy")
            }

            sb.append(suffix)
            return sb.toString()
        }


        val names = arrayListOf<String>("foo", "bar", "bim", "pako")
        var res = names.joinToString(prefix = "{", suffix = "}", separator= "; ",
                transform = {str -> str.toUpperCase()})
        println(res)
        res = names.joinToString()
        println(res)
    }

    private fun test4() {
        fun <T> Collection<T>.joinToString(prefix:String = "[",
                                           suffix:String = "]",
                                           separator:String = " ",
                                           transform: (T)->String = {it.toString()}):String {
            val sb = StringBuilder(prefix)
            this.forEachIndexed {index:Int, value:T ->
                if(index > 0 ) sb.append(separator)
                sb.append(transform(value))
            }

            sb.append(suffix)
            return sb.toString()
        }


        val names = arrayListOf<String>("foo", "bar", "bim", "pako")
        val res = names.joinToString(prefix = "{", suffix = "}", separator= "; ",
                transform = {str -> str.toUpperCase()})
        println(res)

    }


    private fun test3() {
        fun String.customFilter(predicate:(ch:Char)->Boolean):String {
            val sb = StringBuilder()
            for(x in this) {
                if(predicate(x)) sb.append(x)
            }
            return sb.toString()
        }

        val str = "foo123BAR123"
        val res = str.customFilter {it in 'a'..'z' || it in 'A'..'Z'}
        println("str = $str")
        println("res = $res")
    }


    private fun test2() {
        fun binaryArithmeticOp(x:Double, y:Double, algo: (Double,Double)->Double) {
            val res = algo(x,y)
            println("res = $res")
        }

        val x:Double = 10.0
        val y:Double = 3.0
        binaryArithmeticOp(x,y , {x,y-> x+y})
        binaryArithmeticOp(x,y , {x,y-> x-y})
        binaryArithmeticOp(x,y , {x,y-> x*y})
        binaryArithmeticOp(x,y , {x,y-> x/y})
        binaryArithmeticOp(x,y , {x,y-> x%y})
    }

    private fun test1()  {
        performRequest("GET", "http://wwww.google.com/pictures") {
          responseMessage:String, responseCode:Int, content:String ->
            println("responseMessage = $responseMessage")
            println("responseCode = $responseCode")
            println("content = $content")
        }
    }

    private fun performRequest(method:String , url:String ,
                       callback: (responseMessage:String , responseCode:Int, content:String)->Unit) {
        println("$method : $url")
        callback("OK", 200, "<b>Hello World!</b>")
    }

}