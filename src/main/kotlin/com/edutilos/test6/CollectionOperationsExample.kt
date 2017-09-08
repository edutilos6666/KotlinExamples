package com.edutilos.test6

object CollectionOperationsExample {
    @JvmStatic
    fun main(args: Array<String>) {
        test4()
    }


    data class Person(val name:String, val age:Int)
    val people = listOf(
            Person("foo", 10),
            Person("bar", 20),
            Person("bim", 30)
    )


    //anonymous function
    private fun test4() {
        fun lookForName(people:List<Person>, name:String) {
            var flag = true

            people.forEach(fun (person:Person) {  //here anonymous function
                if(person.name == name) {
                    println("$name was found.")
                    flag = false
                    return
                }
            })

            if(flag)
            println("$name could not be found.")
        }

        lookForName(people, "foo")
        lookForName(people, "edu")
    }

    private fun test3() {
        fun lookForName(people:List<Person>, name:String) {
            people.forEach label@ {p ->
                if(p.name == name) {
                    println("$name was found.")
                    return@label
                }
            }

            println("$name could not be found.")
        }

        lookForName(people, "foo")
        lookForName(people, "pako")
    }



    private fun test2() {
        fun lookForName(people:List<Person>, name:String) {
            people.forEach {p ->
                if(p.name == name) {
                    println("$name was found.")
                    return
                }
            }

            println("$name could not be found.")
        }

        lookForName(people, "foo")
        lookForName(people, "pako")
    }

    private fun test1() {

        fun lookForName(people:List<Person>, name:String) {
            for(person in people) {
                if(person.name == name) {
                    println("found $name")
                    return
                }
            }

            println("$name could not be found.")
        }

        lookForName(people, "foo")
        lookForName(people, "edu")
    }
}
