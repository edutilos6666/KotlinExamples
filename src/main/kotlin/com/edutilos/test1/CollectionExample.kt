package com.edutilos.test1

fun main(args:Array<String>) {
    println(joinCollectionToString(listOf(1,2,3,4), "(", ")", "; "))
    var list = listOf(10, 20, 30, 40)
    println(list.joinToString("(", ")", ";"))
    println()
    val str = "foobar"
    println("first char = ${str.firstChar()}")
    println("last char = ${str.lastChar()}")
}


fun String.firstChar(): Char  = this.get(0)
fun String.lastChar(): Char = this.get(this.length -1)


fun <T> joinCollectionToString(collection: Collection<T> ,
                               prefix:String ,
                               suffix:String ,
                               separator:String ):String  {
    val res = StringBuilder(prefix)
   for((index, el) in collection.withIndex()) {
       if(index > 0) res.append(separator)
       res.append(el)
   }

    res.append(suffix)
    return res.toString()
}

//extension method to Collection<T>
fun <T> Collection<T>.joinToString(prefix:String,
                                   suffix:String ,
                                   separator:String) :String {
    val res = StringBuilder(prefix)
    for((index, el) in this.withIndex()) {
        if(index > 0) res.append(separator)
        res.append(el)
    }

    res.append(suffix)
    return res.toString()
}


fun test1() {
    var set = hashSetOf<Int>(1, 10, 20, 30)
    var list = arrayListOf<Double>(10.0, 20.0, 30.0)
    var map = hashMapOf<Int, Boolean>(1 to true, 2 to false , 20 to true)

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
    println()

    println(set)
    println(list)
    println(map)
    println()

    println("set max = ${set.max()}")
    println("set min = ${set.min()}")
    println("set first = ${set.first()}")
    println("set last = ${set.last()}")
    println()

    println("list max = ${list.max()}")
    println("list min = ${list.min()}")
    println("list first = ${list.first()}")
    println("list last = ${list.last()}")

}



