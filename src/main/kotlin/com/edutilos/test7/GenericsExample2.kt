package com.edutilos.test7


object GenericsExample2 {
    @JvmStatic
    fun main(args: Array<String>) {
        test4()
    }

    private fun test4() {
        val items = listOf("foo", true , "bar", 10, 100.0, ArrayList<String>())
        println(items.filterIsInstance<String>())
    }


    inline fun <reified T> isA(value: Any) = value is T
    //reified
    private fun test3() {
        println(isA<String>("foobar"))
        println(isA<String>(123))
        println(isA<Number>(123))
    }

    //check and cast
    private fun test2() {
        fun collectionStatistics(c:Collection<Int>) {
            if(c is List<Int>) {
                val sum = c.sum()
                val max = c.max()
                val min = c.min()
                val avg = c.average()

                println("sum = $sum")
                println("max = $max")
                println("min = $min")
                println("avg = $avg")
            }
        }
        collectionStatistics(listOf(1, 2,3,4,5))

    }

    private fun test1() {
        fun collectionStatistics(c:Collection<*>) {
            val intList = c as List<Int> ?: throw IllegalArgumentException("List<Int> was expected.")
            val sum = intList.sum()
            val max = intList.max()
            val min = intList.min()
            val avg = intList.average()

            println("sum = $sum")
            println("max = $max")
            println("min = $min")
            println("avg = $avg")
        }

        collectionStatistics(listOf(1, 2,3,4,5))
     //   collectionStatistics(listOf("foo", "bar", "bim"))
      //  collectionStatistics(listOf(1.toDouble(), 2.toDouble(), 3.toDouble()))
    }
}
