package com.edutilos.test7


object GenericFunctionsExample {
    @JvmStatic
    fun main(args: Array<String>) {
        test5()
    }


    private fun test5() {
        fun <T> appendPeriod(seq:T) where T : CharSequence, T:Appendable {
            if(!seq.endsWith(".")) seq.append(".")
        }

        var sb = StringBuilder("foobar")
        appendPeriod(sb)
        println(sb.toString())

    }

    private fun test4() {
        fun <T: Comparable<T>> max(first:T , second:T):T{
            if(first > second) return first
            return second
        }

        println(max("foo", "bar"))
        println(max(10, 20))

        fun <T: Comparable<T>> min(first:T , second:T):T {
            if(first < second) return first
            return second
        }

        println(min("foo", "bar"))
        println(min(10,20))

    }

    private fun test3() {
        fun <T:Number> oneHalf(value:T):Double {
            return value.toDouble()/2
        }

        println(oneHalf(10))
        println(oneHalf(10.toDouble()))
        println(oneHalf(10).toLong())
    }


    val <T> List<T>.myFirst : T
        get() = this[0]

    val <T> List<T>.mySecond : T
      get() = this[1]

    val <T> List<T>.myThird : T
      get() = this[2]


    val <T> List<T>.myLast : T
      get() = this[size-1]

        private fun test2() {
            val names = listOf<String>("foo", "bar", "bim", "pako")
            println("myFirst = ${names.myFirst}")
            println("mySecond = ${names.mySecond}")
            println("myThird = ${names.myThird}")
            println("myLast = ${names.myLast}")
    }

    private fun test1()  {
        val letters = ('a'..'z').toList()
        println(letters.slice<Char>(0..2))
        println(letters.slice(10..15))
    }
}

