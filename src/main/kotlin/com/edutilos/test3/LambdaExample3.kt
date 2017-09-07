package com.edutilos.test3

object LambdaExample3 {
    @JvmStatic
    fun main(args: Array<String>) {
        println(test4())
    }




    @JvmStatic private fun test4() = buildString {
        for(letter in 'A'..'Z')
            append(letter)
        append("\nNow I know the alphabet!")
    }

    @JvmStatic private fun test3() = StringBuilder().apply {
        for(letter in 'A'..'Z')
            append(letter)
        append("\nNow I know the alphabet!")
    }.toString()

    @JvmStatic private fun test2() =
        with(StringBuilder()) {
            for(letter in 'A'..'Z')
                this.append(letter)
            this.append("\nNow I know the alphabet!")
            this.toString()
        }


    @JvmStatic private fun test1() {
        var letters = StringBuilder()
        for(letter in 'A'..'Z')
            letters.append(letter)

        letters.append("\nNow I know the alphabet!")
        println(letters.toString())
    }
}

