package com.edutilos.test4


object NullableTypesExample1 {
    @JvmStatic
    fun main(args: Array<String>) {
        test4()
    }



    data class Address(val street:String? , val zipCode:Long?,
                       val city:String? , val country:String?)

    data class Company(val name:String, val address:Address?)
    data class Person(val name:String , val company:Company?)

    private fun test4() {
        val printAddress = {p:Person ->
            val street = p?.company?.address?.street
            val zipCode = p?.company?.address?.zipCode
            val city = p?.company?.address?.city
            val country = p?.company?.address?.country

            if(street != null && zipCode != null && city != null && country != null) {
                println("street = $street")
                println("zipCode = $zipCode")
                println("city = $city")
                println("country = $country")
            } else {
                println("some unknown errors in address of person ${p.name}")
            }
        }


        var a = Address("Sumperkamp 9", 44804L, "Bochum", "Germany")
        var c = Company("edutilos LTD", a)
        var p = Person("foo", c)
        printAddress(p)

         a = Address("Sumperkamp 9", 44804L, "Bochum", null)
        c = Company("edutilos LTD", a)
        p = Person("foo",c)
        printAddress(p)

    }

    data class Employee(val name:String , val manager:Employee?)
    private fun test3() {
      fun managerName(employee:Employee?) = employee?.manager?.name
        val ceo = Employee("foo", null)
        val developer = Employee("bar", ceo)
        println(managerName(developer))
        println(managerName(ceo))
    }

   private fun test2() {
       var str:String? = "foobar"
       var upperCase = str?.toUpperCase()
       var lowerCase = str?.toLowerCase()
       var first = str?.first()
       var last = str?.last()
       println("str = $str")
       println("upperCase = $upperCase")
       println("lowerCase = $lowerCase")
       println("first = $first")
       println("last = $last")
   }



    private fun printProps(id:Long? , name:String? , age:Int?, wage:Double?) {
        if(id != null && name != null && age != null && wage != null) {
            println("id = $id")
            println("name = $name")
            println("age = $age")
            println("wage = $wage")
            println()
        } else {
            println("something went wrong.")
        }
    }

    @JvmStatic private fun test1() {
        printProps(1, "foo", 10, 100.0)
        printProps(2, "bar", 20, null)
    }
}
