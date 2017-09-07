package com.edutilos.test1

/**
 * Created by edutilos on 07.09.17.
 */
object Example2K {
    @JvmStatic fun main(args: Array<String>) {
        //        testArithmetics();
        testWorker()
    }

    private fun testWorker() {
        val w1: Worker
        val w2: Worker
        w1 = Worker(1, "foo", 10, 100.0, true)
        w2 = Worker(2, "bar", 20, 200.0, false)
        println(w1)
        println(w2)
        val id: Long
        val name: String
        val age: Int
        val wage: Double
        val active: Boolean
        id = w1.id!!
        name = w1.name!!
        age = w1.age!!
        wage = w1.wage!!
        active = w1.active!!
        println("id = " + id)
        println("name = " + name)
        println("age = " + age)
        println("wage = " + wage)
        println("active = " + active)

    }

    private fun testArithmetics() {
        val ops = Arithmetics(20f, 10f)
        println("add = " + ops.add())
        println("multiply = " + ops.multiply())
    }
}
