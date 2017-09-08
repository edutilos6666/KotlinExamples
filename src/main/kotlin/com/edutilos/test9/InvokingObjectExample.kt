package com.edutilos.test9

object InvokingObjectExample {
    @JvmStatic
    fun main(args: Array<String>) {
        test2()
    }


    data class Person(val id:Long ,val name:String ,val age:Int)
    class PersonIdPredicate(val lowerBound:Long , val upperBound:Long):
            (Person)->Boolean {
        override fun invoke(p:Person):Boolean {
            return p.id >= lowerBound && p.id <= upperBound
        }
    }

    class PersonNamePredicate(val names:List<String>):
            (Person)->Boolean {
        override fun invoke(p:Person):Boolean {
            return p.name in names
        }
    }

    class PersonAgePredicate(val lowerBound:Int , val upperBound:Int):
            (Person)->Boolean {
        override fun invoke(p:Person):Boolean {
            return p.age >= lowerBound && p.age <= upperBound
        }
    }


    private fun test2() {
        val people = listOf(
                Person(1, "foo", 10),
                Person(2, "bar", 20),
                Person(3, "bim", 30)
        )

        val pred1 = PersonIdPredicate(1, 2)
        val pred2 = PersonNamePredicate(listOf("foo", "bar", "bim"))
        val pred3 = PersonAgePredicate(20, 30)
        val filtered = people.filter(pred1).filter(pred2).filter(pred3)
        println("filtered = $filtered")
    }


    class Greeter(val greeting:String) {
        operator fun invoke(name:String) {
            println("$greeting, $name!")
        }
    }
    private fun test1() {
        val greeter = Greeter("Hello")
        greeter("Pako")
        greeter("Edutilos")
    }
}
