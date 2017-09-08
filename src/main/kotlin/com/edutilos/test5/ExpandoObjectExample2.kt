package com.edutilos.test5

object ExpandoObjectExample2 {
    @JvmStatic
    fun main(args: Array<String>) {
        test1()
    }


    private fun test1() {
        val ep = ExpandablePerson()
        val map = hashMapOf<String, Any?>("id" to 1L, "name" to "foo",
                "age" to 10 , "wage" to 100.0, "active" to true)

        for((k,v) in map) {
            ep.setAttribute(k,v)
        }

        println("id = ${ep.id}")
        println("name = ${ep.name}")
        println("age = ${ep.age}")
        println("wage = ${ep.wage}")
        println("active = ${ep.active}")
    }

    class ExpandablePerson {
        private var _attributes  = hashMapOf<String, Any?>()

        fun setAttribute(attrName:String , attrValue:Any?) {
            _attributes[attrName] = attrValue
        }


        val id:Long by _attributes
        val name:String by _attributes
        val age:Int by _attributes
        val wage:Double by _attributes
        val active:Boolean by _attributes
    }
}


