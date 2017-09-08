package com.edutilos.test4


object PrimitiveTypesExample1 {
    @JvmStatic
    fun main(args: Array<String>) {
        test5()
    }

    //Nothing return type -> always throws Exception
    private fun test5():Nothing {
        println("hello world!")
        throw Exception("Unknown Exception occurred.")
    }

    //number conversion
    private fun test4() {
        var str = "100"
        val n1:Byte = str.toByte()
        val n2:Short = str.toShort()
        val n3:Int = str.toInt()
        val n4:Long = str.toLong()
        val n5:Float = str.toFloat()
        val n6:Double = str.toDouble()
        println("n1:Byte = $n1")
        println("n2:Short = $n2")
        println("n3:Int = $n3")
        println("n4:Long = $n4")
        println("n5:Float = $n5")
        println("n6:Double = $n6")
        println(1.toLong() in listOf(1L, 2L, 3L))
        println()
    }

    //nullable primitive types 2
    private fun printProps(id:Long? , name:String?, age:Int?, wage:Double?) {
        println("id = $id")
        println("name = $name")
        println("age = $age")
        println("wage = $wage")
        println()
    }
    private fun test3() {
        printProps(null, null, 10, 100.0)
        printProps(1, "foo", null, null)
        printProps(1, "foo", 10, 100.0)
    }

    //nullable primitive types
    data class Person(val id:Long , val name:String, val age:Int? = null) {
       fun isOlderThan(other:Person):Boolean? {
           if(this.age == null || other.age == null) return null
           return this.age > other.age
       }
    }

    private fun test2() {
        println(Person(1, "foo", 20).isOlderThan(Person(2, "bar", 10)))
        println(Person(1, "foo").isOlderThan(Person(2, "bar", 10)))
        println(Person(1, "foo", 20).isOlderThan(Person(2, "bar")))
        println(Person(1, "foo").isOlderThan(Person(2, "bar")))
    }


    //coerceIn
    private fun test1() {
        var number:Int = 123
        var res = number.coerceIn(0, 100)
        println("res = $res")
    }
}



