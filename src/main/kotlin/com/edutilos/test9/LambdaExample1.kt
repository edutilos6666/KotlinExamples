package com.edutilos.test9


object LambdaExample1 {
    @JvmStatic
    fun main(args: Array<String>) {
        test4()
    }



    private fun test4() {
        val  map = mutableMapOf<Int, String> (1 to "foo")
        map.apply {
            this[1] = "bar"
        }

        with(map) {
            this[2] = "bim"
            this[3] = "pako"
        }

        for((k,v) in map)  {
            println("$k => $v")
        }
    }

    private fun test3() {
        val appendExcl:StringBuilder.()->Unit = {
            this.append("!")
        }

        val sb = StringBuilder("hello")
        sb.appendExcl()
        println(sb.toString())


        fun buildString(builderAction:StringBuilder.()->Unit):String {
            val sb = StringBuilder()
            builderAction(sb)
            return sb.toString()
        }

        println(buildString(appendExcl).toString())
    }

    private fun test2() {
        //lambda with receiver , we can give one parameter of lambda special status
        // => receiver status
        fun buildString(builderAction:StringBuilder.()->Unit):String {
            val sb = StringBuilder()
            builderAction(sb)
            return sb.toString()
        }

        var res = buildString {
            this.append("hello, ")
            append("world!")
        }

        println(res)
    }

    private fun test1() {
       fun buildString(builderAction:(StringBuilder)->Unit):String {
           val sb = StringBuilder()
           builderAction(sb)
           return sb.toString()
       }

      var res = buildString { sb->
          sb.append("hello, ")
          sb.append("world!")
      }

        println(res)
    }
}