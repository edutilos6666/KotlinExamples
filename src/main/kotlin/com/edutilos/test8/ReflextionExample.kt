package com.edutilos.test8


object ReflextionExample {
    @JvmStatic
    fun main(args: Array<String>) {
        test2()
    }


    fun printProps(id:Long , name:String , age:Int) {
        println("$id, $name, $age")
    }

    var counter = 0

    private fun test2() {
        val kFunction = ReflextionExample::printProps
        kFunction.call(1, "foo", 10)
        kFunction.invoke(2, "bar", 20)


        val kProperty = ReflextionExample::counter
        kProperty.setter.call(25)
        println(kProperty.getter.call())

        kProperty.set(12)
        println(kProperty.get())

        val person = Person(1, "foo", 10, 100.0)
        val idProperty = Person::id
        val nameProperty = Person::name
        val ageProperty = Person::age
        val wageProperty = Person::wage

        println("id = ${idProperty.get(person)}")
        println("name = ${nameProperty.get(person)}")
        println("age = ${ageProperty.get(person)}")
        println("wage = ${wageProperty.get(person)}")
    }

    class Person(val id:Long , val name:String , val age:Int, val wage:Double)

    private fun test1() {
        val person = Person(1, "foo", 10, 100.0)
        val kClass = person.javaClass.kotlin
        val simpleName = kClass.simpleName
        val qualifiedName = kClass.qualifiedName
        val isAbstract = kClass.isAbstract
        val isCompanion = kClass.isCompanion
        val isData = kClass.isData
        val isFinal = kClass.isFinal
        val isInner = kClass.isInner
        val isOpen = kClass.isOpen
        val isSealed = kClass.isSealed
        println("simpleName = $simpleName")
        println("qualifiedName = $qualifiedName")
        println("isAbstract = $isAbstract")
        println("isCompanion = $isCompanion")
        println("isData = $isData")
        println("isFinal = $isFinal")
        println("isInner = $isInner")
        println("isOpen = $isOpen")
        println("isSealed = $isSealed")
        println("\n<<members>>")
        kClass.members.forEach {println(it.name)
        }
    }
}