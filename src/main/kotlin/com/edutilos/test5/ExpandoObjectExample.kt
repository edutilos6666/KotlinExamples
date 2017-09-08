package com.edutilos.test5

object ExpandoObjectExample {
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


        val id:Long
          get()  = _attributes["id"]!!.toString().toLong()

        val name:String
          get() {
              val ret = _attributes["name"]!!.toString()
              return ret
          }


        val age:Int
          get() {
              return _attributes["age"]!!.toString().toInt()
          }


        val wage:Double
          get() {
              return _attributes["wage"]!!.toString().toDouble()
          }

        val active:Boolean
          get() {
              return _attributes["active"]!!.toString().toBoolean()
          }

    }
}


