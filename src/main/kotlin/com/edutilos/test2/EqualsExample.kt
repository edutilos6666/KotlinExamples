package com.edutilos.test2



object EqualsExample {

    @JvmStatic fun main(args:Array<String>) {
      var set = hashSetOf<Client>(Client("foo", "bar"), Client("edu", "tilos"))
        println("contains = ${set.contains(Client("foo", "bar"))}")
        println("contains = ${set.contains(Client("foo", "tilos"))}")

        val p1 = Person("foo", "bar")
        val p2 = p1.copy(lname = "new_bar")
        println(p1)
        println(p2)
    }


    class Client(val fname: String, val lname: String) {
        override fun equals(other: Any?): Boolean {
            if (other == null || other !is Client) return false
            return fname == other.fname && lname == other.lname
        }

        override fun hashCode(): Int {
            return (fname.hashCode() * 31 + lname.hashCode()) * 31
        }
    }



    data class Person(val fname:String , val lname:String)

}