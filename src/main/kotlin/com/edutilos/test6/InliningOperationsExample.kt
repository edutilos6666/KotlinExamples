package com.edutilos.test6

import java.io.BufferedReader
import java.io.FileReader


object InliningOperationsExample {
    @JvmStatic
    fun main(args: Array<String>) {
        test3()
    }


    data class Person(val id:Long , val name:String , val age:Int)


    private fun test3() {
        BufferedReader(FileReader("foo.txt")).use {br ->
            var line = br.readLine()
            while(line != null)  {
                println("line = $line")
                line = br.readLine()
            }
        }
    }

    private fun test2() {
        val people = listOf(
                Person(1, "foo", 10),
                Person(2, "bar", 20),
                Person(3, "bim", 30),
                Person(4, "pako", 40),
                Person(5, "edu", 50)
        )

        println(people.filter {it.age > 10 && it.age < 50}.map(Person::name))
    }

    private fun test1() {
        val people = listOf(
                Person(1, "foo", 10),
                Person(2, "bar", 20),
                Person(3, "bim", 30),
                Person(4, "pako", 40),
                Person(5, "edu", 50)
        )

        println(people.filter {it.age > 10 && it.age < 50}.map {it.name})
    }
}
