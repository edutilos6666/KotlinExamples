package com.edutilos.test2


object CompanionObjectExample {
    @JvmStatic fun main(args:Array<String>) {
        test2()
    }

    @JvmStatic fun test1()  {
       var x = 10.0
        var y = 3.0
        println("add = ${SimpleMath.add(x,y)}")
        println("subtract = ${SimpleMath.subtract(x,y)}")
        println("multiply = ${SimpleMath.multiply(x,y)}")
        println("divide = ${SimpleMath.divide(x,y)}")
    }

    class SimpleMath {
        companion object {
            fun add(x:Double, y:Double):Double = x + y
            fun subtract(x:Double, y:Double):Double = x -y
            fun multiply(x:Double, y:Double):Double = x*y
            fun divide(x:Double, y:Double):Double = x/y
        }
    }



    @JvmStatic fun test2() {
        val p1 = Person(2, "bar", 20 , 200.0)
        val p2 = Person.newDummyPerson()
        println(p1.toString())
        println(p2)
    }

    data class Person(var id:Long , var name:String , var age:Int , var wage:Double) {
        companion object {
            fun newDummyPerson():Person {
                return Person(1, "foo", 10 , 100.0)
            }
        }
    }
}

