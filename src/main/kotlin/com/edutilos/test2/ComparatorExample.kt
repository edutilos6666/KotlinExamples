package com.edutilos.test2


object ComparatorExample {
    @JvmStatic fun main(args:Array<String>) {
        //test1()
        test2()
    }


   object NamesComparator: Comparator<String> {
       override fun compare(o1: String?, o2: String?): Int {
           return o1!!.compareTo(o2!!, ignoreCase = true)
       }
   }


    @JvmStatic fun test1() {
        var names = listOf("foo", "pako", "Foo", "Edu", "edu")
        var sortedNames = names.sortedWith(comparator= NamesComparator)
        println(names)
        println(sortedNames)
    }



    data class Person(val id:Long , val fname:String , val lname:String, val age:Int)
    object PersonComparatorById: Comparator<Person> {
        override fun compare(p1:Person?, p2:Person?):Int {
            return (p1!!.id - p2!!.id).toInt()
        }
    }

    object PersonComparatorByFname:Comparator<Person> {
        override fun compare(p1:Person?, p2:Person?):Int {
            return p1!!.fname.compareTo(p2!!.fname, ignoreCase=true)
        }
    }

    object PersonComparatorByLname:Comparator<Person> {
        override fun compare(p1:Person?, p2:Person?):Int {
            return p1!!.lname.compareTo(p2!!.lname, ignoreCase=true)
        }
    }

     object PersonComparatorByAge:Comparator<Person> {
         override fun compare(p1:Person?, p2:Person?):Int {
             return p1!!.age - p2!!.age
         }
     }


    @JvmStatic fun test2() {
        val p1 = Person(1L, "foo", "bar", 30)
        val p2 = Person(2L, "edu", "atilos", 20)
        val p3 = Person(3L, "leo", "deko", 25)
        val list = listOf(p1, p2, p3)
        val sortedbyId = list.sortedWith(comparator= PersonComparatorById)
        val sortedByFname = list.sortedWith(comparator=PersonComparatorByFname)
        val sortedByLname = list.sortedWith(comparator=PersonComparatorByLname)
        val sortedByAge = list.sortedWith(comparator=PersonComparatorByAge)

        println("<<normal list>>")
        println(list)
        println("<<sorted by id>>")
        println(sortedbyId)
        println("<<sorted by fname>>")
        println(sortedByFname)
        println("<<sorted by lname>>")
        println(sortedByLname)
        println("<<sorted by age>>")
        println(sortedByAge)
    }

}
