package com.edutilos.test3
import java.io.File

object FilterAndMapExample1 {
    @JvmStatic fun main(args:Array<String>) {
        test13()
    }


    fun File.isInsideHiddenDirectory() =
       generateSequence(this) {
           it.parentFile
       }.any {it.isHidden}

    @JvmStatic private fun test13() {
        var filename = "/home/aku/.var/app"
        var file = File(filename)
        println("isInsideHiddenDirectory = ${file.isInsideHiddenDirectory()}")
        file = File("/home/aku/.var/app/MonoDevelop")
        println("isInsideHiddenDirectory = ${file.isInsideHiddenDirectory()}")
    }

    @JvmStatic private fun test12() {
        var f1 = generateSequence(0){ it + 1}
        var numbers = f1.takeWhile { it <= 100 }
        println(numbers.sum())
    }

    @JvmStatic private fun test11() {
        var numbers = listOf(1,2,3,4,5,6)
        var res = numbers.map {it*it}
                .filter {it%2 == 0}
        println(res)

        var res2 = numbers.map {it*it}
                .filter {it%2 == 0}
                .toList()

        println(res2)
    }


    data class Book(val title:String , val authors:List<String>)
    @JvmStatic private fun test10() {
        var books = listOf(Book("book1", listOf("foo", "bar")),
                Book("book2", listOf("edu", "tilos", "pako")),
                Book("book3", listOf("leo", "messi", "ronaldo", "foo", "pako")))

        var authors = books.flatMap { b -> b.authors }
        var authorsSet = authors.toSet()
        println(authors)
        println(authorsSet)
    }

    @JvmStatic private fun test9() {
        var strs = listOf("foo", "bar", "bim", "pako")
        var flatMap = strs.flatMap { it.toList() }
        println(flatMap)


        var l2 = listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))
        println(l2)
        println(l2.flatMap { it })
    }
    @JvmStatic private fun test8() {
        var strs = listOf("foo", "fii", "bim", "bor", "fap")
        var groupBy = strs.groupBy(String::first)
        println(groupBy)
    }

    @JvmStatic private fun test7() {
        var people = listOf(Person(1L, "foo", 10),
                Person(2L, "bar", 20),
                Person(1L, "bim", 30),
                Person(3L, "pako", 40))

        var groupBy = people.groupBy { it.id }

        println(groupBy)

    }

    @JvmStatic private fun test6() {
        var people = listOf(Person(1L, "foo", 10),
                Person(2L, "bar", 20),
                Person(3L, "bim", 30),
                Person(4L, "pako", 40))

        var all = people.all { it.age > 0 }
        var any = people.any {it.age > 30}
        var count = people.count {it.age > 20}
        var find = people.find {it.age > 20}
        println("all = $all")
        println("any = $any")
        println("count = $count")
        println("find = $find")
    }

    @JvmStatic private fun test5() {
       var m = mapOf(0 to "zero", 1 to "one", 2 to "two", 3 to "three")
        var mUpper = m.mapValues { it.value.toUpperCase()}
        var mKeys = m.mapKeys { Math.pow(it.key.toDouble(), 3.toDouble()) }
        println(mUpper)
        println(mKeys)

        var valuesUpper = m.map { it.value.toUpperCase()}
        var keys = m.map {Math.pow(it.key.toDouble(), 3.toDouble())}
        println(valuesUpper)
        println(keys)

    }

    @JvmStatic private fun test4() {
        var people = listOf(Person(1L, "foo", 10),
                Person(2L, "bar", 20),
                Person(3L, "bim", 30),
                Person(4L, "edu", 40),
                Person(5L, "tilos", 50),
                Person(6L, "pako", 60))

        var m1 = people.map {it.id}
        var m2 = people.map { it.name}
        var m3 = people.map {it.age}
        println(m1)
        println(m2)
        println(m3)
    }

    @JvmStatic private  fun test3() {
        var numbers = listOf(1, 2, 3, 4, 5, 6)
        var m1 = numbers.map { it*it }
        println(m1)
    }

    data class Person(val id:Long, val name:String , val age:Int)

    @JvmStatic private fun test2() {
        var people = listOf(Person(1L, "foo", 10),
                Person(2L, "bar", 20),
                Person(3L, "bim", 30),
                Person(4L, "edu", 40),
                Person(5L, "tilos", 50),
                Person(6L, "pako", 60))
        var f1 = people.filter { it.age > 0 && it.age < 40}
        println(f1)
        println()
        f1 = people.filter {it.name.startsWith("b")}
        println(f1)
        println()

        f1 = people.filter {it.name.startsWith("b") && it.age > 20}
        println(f1)
        println()
    }

    @JvmStatic private fun test1() {
        var numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        var oddNumbers = numbers.filter { it % 2 == 1 }
        var evenNumbers = numbers.filter { it % 2 == 0 }
        println("all numbers = $numbers")
        println("odd numbers = $oddNumbers")
        println("even numbers = $evenNumbers")
    }

}