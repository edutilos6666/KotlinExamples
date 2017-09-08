package com.edutilos.test5


object DestructingExample1  {
    @JvmStatic
    fun main(args: Array<String>) {
        test3()
    }



    data class NameComponents(val name:String , val ext:String)
    private fun test3() {
        fun splitFileName(fileName:String):NameComponents {
            val result = fileName.split(".", limit = 2)
            return NameComponents(result[0], result[1])
        }


        val (name , ext)  = splitFileName("foobar.txt")
        println("$name and $ext")

    }



    //custom class for destructing example
    data class Person(val id:Long , val name:String , val age:Int, val wage:Double)
    private fun test2() {
        val p1 = Person(1, "foo", 10, 100.0)
        val (id , name, age, wage) = p1
        println("$id , $name, $age, $wage")

        val people = arrayListOf<Person>(
                Person(1, "foo", 10, 100.0),
                Person(2, "bar", 20, 200.0),
                Person(3, "bim", 30, 300.0)
        )

        println()
        for(p in people) {
            val (id, name, age, wage) = p
            println("$id, $name, $age, $wage")
        }

    }

    private fun test1() {
        var map = mapOf("foo" to 10, "bar" to 20, "bim" to 30)
        for((k,v) in map) {
            println("$k => $v")
        }
    }
}
