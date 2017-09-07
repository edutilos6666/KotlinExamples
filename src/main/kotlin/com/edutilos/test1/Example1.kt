package com.edutilos.test1

/**
 * Created by edutilos on 07.09.17.
 */
object Example1 {
    @JvmStatic fun main(args: Array<String>) {
        val p1: Person
        val p2: Person
        p1 = Person(1L, "foo", 10)
        p2 = Person(2L, "bar", 20)
        println(p1)
        println(p2)
    }


    internal class Person {
        var id: Long = 0
        var name: String? = null
        var age: Int = 0

        constructor(id: Long, name: String, age: Int) {
            this.id = id
            this.name = name
            this.age = age
        }

        constructor() {

        }

        override fun toString(): String {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}'
        }
    }
}