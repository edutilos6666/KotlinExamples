package com.edutilos.test3



object LambdaExample1 {
    @JvmStatic fun main(args:Array<String>) {
        /*{ println("for fun") }()
        run {println("for fun2")}*/
        test3()
    }


    data class Person(val id:Long , val name:String , val age:Int)

    //old fashion way
     @JvmStatic fun findOldest() {
        val people = listOf(Person(1L, "foo", 10),
                 Person(2L, "bar", 30),
                 Person(3L, "bim", 20))
         var maxAge = 0
         var oldestPerson:Person? = null
         for(person in people) {
             if(person.age > maxAge) {
                 maxAge = person.age
                 oldestPerson = person
             }
         }

         println("oldestPerson = ${oldestPerson}")
    }



     @JvmStatic fun test2() {
         { println("for fun") }()
         var add = {x:Double, y:Double -> x + y}
         var subtract = {x:Double, y:Double -> x - y}
         var multiply = {x:Double, y:Double -> x * y}
         var divide = {x:Double , y:Double -> x / y}
         var x = 10.0
         var y = 3.0
         println("add(x,y) = ${add(x,y)}")
         println("subtract(x,y) = ${subtract(x,y)}")
         println("multiply(x,y) = ${multiply(x,y)}")
         println("divide(x,y) = ${divide(x,y)}")

     }



    @JvmStatic fun List<Person>.myJoinToString(separator:String,
                                                  transform: (Person)->String):String {
        val res = StringBuilder("people = [")
/*        for(p in this) {
            res.append(transform(p))
            res.append(separator)
        }*/

         for((index, p) in this.withIndex()) {
             if(index > 0 )
                 res.append(separator)
             res.append(transform(p))
         }


        res.append("]")
        return res.toString()
    }

    @JvmStatic fun test3() {
        val people = listOf(Person(1, "foo", 10),
                Person(2, "bar", 20),
                Person(3, "bim", 30))
        println(people.myJoinToString(separator = "; ", transform = {p:Person-> p.name}))
    }


}
