package com.edutilos.test7


object PassingVarargExample {
    @JvmStatic
    fun main(args: Array<String>) {
        test5()
    }



    private fun test5() {
        fun <T> printFirstAndLast(list:List<T>) {
            if(list.isNotEmpty()) {
                println("${list.first()}, ${list.last()}")
            }
        }

        printFirstAndLast(listOf("foo", 10, true))
    }
    private fun test4() {
        fun printFirstAndLast(list:List<*>) {
            if(list.isNotEmpty()) {
                println("${list.first()}, ${list.last()}")
            }
         }

        printFirstAndLast(listOf("foo", 10, true))
    }

    private fun test3() {
        fun <T> copyData(source:MutableList<out T>, target:MutableList<in T>) {
            for(el in source) target.add(el)
        }
        val src = mutableListOf(1, "foo", true)
        val target = mutableListOf<Any>()
        copyData(src, target)
        println(target)
    }

    //copy data
    private fun test2() {
        fun <T:R, R> copyData(source:MutableList<T>, target:MutableList<R>) {
            for(el in source) {
                target.add(el)
            }
        }

        val src = mutableListOf(1, "foo", true)
        val target = mutableListOf<Any>()
        copyData(src, target)
        println(target)
    }

    private fun test1() {
        fun printContents(list:List<Any>) {
            println(list.joinToString(separator = "; "))
        }

        printContents(listOf("foo", "bar", "bim"))
    }
}
