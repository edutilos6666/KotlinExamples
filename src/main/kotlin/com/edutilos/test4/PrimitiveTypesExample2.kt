package com.edutilos.test4

import java.io.BufferedReader
import java.io.StringReader


object PrimitiveTypesExample2 {
    @JvmStatic
    fun main(args: Array<String>) {
        test5()
    }

    //arrays
    private fun test5() {
      val names = Array<String>(5) {"foo"}
        names.set(1, "bar")
        names.set(2, "bim")
        names.set(3, "edu")
        names.set(4, "tilos")
        println(names.joinToString("; "))
        val sliced = names.sliceArray(IntRange(0, 2))
        println(sliced.joinToString("; "))
        val sorted = names.sortedArray()
        println(sorted.joinToString("; "))
        val reversed = names.reversedArray()
        println(reversed.joinToString("; "))

        val letters = Array<String>(26) {i-> ('a'+i).toString()}
        println(letters.joinToString(""))
        val upperLetters = Array<String>(26) {i-> ('a'+i).toString().toUpperCase()}
        println(upperLetters.joinToString(""))

        for(i in names.indices) {
            print("$i ; ")
        }
        println()
        println("%s %s %s %s %s".format(*names))
        val squares = IntArray(5) { i->(i+1)*(i+1)}
        println(squares.joinToString("; "))

        names.forEachIndexed {index, el ->
            println("$index => $el")
        }
    }

    //upperCase all, and lowerCase all
    private fun test4() {
        fun upperCaseAll(source:List<String>):List<String> {
            val res = ArrayList<String>()
            for(str in source) {
                res.add(str.toUpperCase())
            }
            return res
        }


        fun lowerCaseAll(source:List<String>):List<String> {
            val res = ArrayList<String>()
            for(str in source) {
                res.add(str.toLowerCase())
            }
            return res
        }

        val source1 = arrayListOf<String>("foo", "bar", "bim")
        var source2 = arrayListOf<String>("FOO", "BAR", "BIM")
        val target1 = upperCaseAll(source1)
        val target2 = lowerCaseAll(source2)
        println("target1 = $target1")
        println("target2 = $target2")
    }


    //mutable and immutable collection
    private fun test3() {
        val source:Collection<Int> = arrayListOf(10, 20, 30)
        val target:MutableCollection<Int> = arrayListOf(1,2);
        for(n in source) {
            target.add(n)
        }

        println("source = $source")
        println("target = $target")
    }

    //filterNotNull in collection
    private fun numberStatistics2(list:List<Int?>) {
        val validNumbers = list.filterNotNull()
        println("sum of valid numbers = ${validNumbers.sum()}")
        println("count of invalid numbers = ${list.size - validNumbers.size}")
    }

    private fun test2() {
        val reader = BufferedReader(StringReader("foo\n10\nbar\n20\nbim\n30"))
        val list = readNumbers(reader)
        numberStatistics2(list)
    }


    private fun readNumbers(reader:BufferedReader):List<Int?> {
        val res = ArrayList<Int?>()
        for(line in reader.lineSequence()) {
            try {
               val n = line.toInt()
                res.add(n)
            } catch(ex:NumberFormatException) {
                res.add(null)
            }
        }

        return res
    }

    private fun numberStatistics(list:List<Int?>) {
        var sumOfLegalNumbers = 0
        var countOfIllegalNumbers = 0
        for(n in list) {
            if(n == null) countOfIllegalNumbers++
            else sumOfLegalNumbers += n
        }

        println("sumOfLegalNumbers = $sumOfLegalNumbers")
        println("countOfIllegalNumbers = $countOfIllegalNumbers")
    }

    private fun test1() {
        val reader = BufferedReader(StringReader("foo\n10\nbar\n20\nbim\n30"))
        val list = readNumbers(reader)
        numberStatistics(list)
    }
}
