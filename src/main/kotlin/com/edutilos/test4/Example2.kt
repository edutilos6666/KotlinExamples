package com.edutilos.test4


object Example2 {
    @JvmStatic fun main(args:Array<String>) {
        test6()
    }


   //nullable type extension methods
    private fun test6() {
       var str:String? = "foobar"
       println("isNullOrBlank = ${str.isNullOrBlank()}")
       println("isNullOrEmpty = ${str.isNullOrEmpty()}")
       str = null
       println("isNullOrBlank = ${str.isNullOrBlank()}")
       println("isNullOrEmpty = ${str.isNullOrEmpty()}")
   }

    //let function
    private fun showPerson(p:Person) {
        println(p)
    }

    private fun test5() {
        var p = Person(1, "foo", 10, 100.0)
        p.let { showPerson(it)}
    }


    //safe cast as?
    private fun printPerson(o:Any?) {
        val dummyPerson = Person(1, "dummy name", 10, 100.0)
        val person = o as? Person ?:  dummyPerson
        println(person)
        println()
    }

    private fun test4() {
        printPerson(Person(2, "bar", 20, 200.0))
        printPerson(null)
    }


    class Address(val street:String?, val postCode:Long?,
                  val city:String? , val country:String?)

    class Company(val name:String?, val address:Address?)
    class Worker(val name:String?, val company:Company?)


    private fun printAddress(worker:Worker?) {
        val dummyAddress = Address("dummy street", 1234, "dummy city", "dummy country")
        val address = worker?.company?.address ?: dummyAddress
        println("street = ${address.street}")
        println("postCode = ${address.postCode}")
        println("city = ${address.city}")
        println("country = ${address.country}")
        println()
    }

    private fun test3() {
        val a1 = Address("Sumperkamp", 44804, "Bochum", "Germany")
        val c1 = Company("Foobar", a1)
        val w1 = Worker("pako", c1)
        printAddress(w1)
        printAddress(Worker("pako", Company("Foobar", null)))
    }


    //elvis operator
    private fun test2() {
        var str:String? = "foo"
        var length = str?.length ?: 0
        println("length = $length")
        str = null
        length = str?.length ?:0
        println("length = $length")
    }

    private fun test1() {
        var p1:Person = Person(1, "foo", 10, 100.0)
        println(p1)
        p1.setId(2)
        p1.setName("new foo")
        p1.setAge(20)
        p1.setWage(200.0)
        println("new id = ${p1.getId()}")
        println("new name = ${p1.getName()}")
        println("new age = ${p1.getAge()}")
        println("new wage = ${p1.getWage()}")
        println(p1.toString())
    }


    class Person(var id:Long, var name:String , var age:Int, var wage:Double) {
        override open fun toString():String {
            return "[${this.id}, ${this.name}, ${this.age}, ${this.wage}]"
        }
    }

    fun Person.setId(id:Long) {
        this.id = id
    }

    fun Person.getId():Long {
        return this.id
    }

    fun Person.setName(name:String) {
        this.name = name
    }

    fun Person.getName():String {
        return this.name
    }

    fun Person.setAge(age:Int) {
        this.age = age
    }

    fun Person.getAge():Int {
        return this.age
    }

    fun Person.setWage(wage:Double){
        this.wage = wage
    }

    fun Person.getWage():Double  {
        return this.wage
    }



}
