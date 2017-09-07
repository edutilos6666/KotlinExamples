package com.edutilos.test1
import java.io.Console
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StringReader
import java.util.Scanner
import java.util.HashMap
import java.util.Map

fun main(args: Array<String>) {
    reader2()
}



//test Person1With
fun testPerson1WithBufferedReader() {
    val pDAO = Person1DAOWithBufferedReader()
    pDAO.save()
    pDAO.save()
    println("<<all people>>")
    val all = pDAO.findAll()
    for(p in all)
        println(p)

    pDAO.update()
    pDAO.remove()
    val p = pDAO.findById()
    println(p)

}


fun reader2() {
    var age:Int
    var name:String
    var wage:Double
    var active:Boolean
    var reader:BufferedReader
    try {
        reader = BufferedReader(StringReader("10"))
//        reader = BufferedReader(StringReader("10asas"))
        age = reader.readLine().toInt()
        reader = BufferedReader(StringReader("foo"))
        name = reader.readLine()
        reader = BufferedReader(StringReader("100.0"))
        wage = reader.readLine().toDouble()
        reader = BufferedReader(StringReader("true"))
        active = reader.readLine().toBoolean()
        println("age = $age")
        println("name = $name")
        println("wage = $wage")
        println("active = $active")
    } catch(ex:Exception) {
        println(ex.message)
    }

    println()
    try {
        reader = BufferedReader(StringReader("10\nfoobar\n100.0\nfalse"))
        age = reader.readLine().toInt()
        name = reader.readLine()
        wage = reader.readLine().toDouble()
        active = reader.readLine().toBoolean()
        println("age = $age")
        println("name = $name")
        println("wage = $wage")
        println("active = $active")
    } catch(ex:Exception) {
        println(ex.message)
    }
}

//test Person1
fun testPerson1DAOImpl() {
    val dao = Person1DAOImpl()
    dao.save(Person1(1, "foo", 10, 100.0, true))
    dao.save(Person1(2, "bim", 20, 200.0, false))
    var all = dao.findAll()
    for(p in all)
        println(p)


    dao.update(1, Person1(1, "new_foo", 66, 666.6, false))
    val p = dao.findById(1)
    println(p)

    dao.remove(1)
    all = dao.findAll()
    for(p in all)
        println(p)

}
//using Scanner
fun readWithScanner() {
    var scanner = Scanner(System.`in`)
    var age:Int? = null
    var name:String? = null
    var wage:Double? = null
    var active:Boolean? = null


    println("enter your age: ")
    age = scanner.nextInt()
    scanner.nextLine()
    println("enter your name: ")
    name = scanner.nextLine()
    println("enter your wage: ")
    wage = scanner.nextDouble()
    scanner.nextLine()
    println("enter your active: ")
    active = scanner.nextBoolean()
    scanner.nextLine()
    println("age = $age")
    println("name = $name")
    println("wage = $wage")
    println("active = $active")
}

//using BufferedReader and InputStreamReader
fun readWithBufferedReader() {
   val reader = BufferedReader(InputStreamReader(System.`in`))
    var age:Int? = null
    var name:String? = null
    var wage:Double? = null
    var active:Boolean? = null
    println("enter your age: ")
    var line = reader.readLine()
    age = line.toInt()

    println("enter your name: ")
    name = reader.readLine()

    println("enter your wage: ")
    line = reader.readLine()
    wage = line.toDouble()

    println("enter your active: ")
    line = reader.readLine()
    active = line.toBoolean()


    println("age = $age")
    println("name = $name")
    println("wage = $wage")
    println("active = $active")
}

//using Console class
//only works from Terminal
fun readWithConsole() {
    val console:Console? = System.console()
    if(console  == null) {
        println(console)
        println("console is null")
        System.exit(0)
    }

    var age:Int? = null
    var name:String? = null
    var wage:Double? = null
    var active:Boolean? = null
    println("enter your age: ")
    var line = console!!.readLine()
    age = line.toInt()

    println("enter your name: ")
    name = console!!.readLine()

    println("enter your wage: ")
    line = console!!.readLine()
    wage = line.toDouble()

    println("enter your active: ")
    line = console!!.readLine()
    active = line.toBoolean()


    println("age = $age")
    println("name = $name")
    println("wage = $wage")
    println("active = $active")
}


class Person1(var id:Long , var name:String , var age:Int , var wage:Double, var active:Boolean) {
    override fun toString(): String {
        return "Person1(id=$id, name='$name', age=$age, wage=$wage, active=$active)"
    }
}

interface Person1DAO {
    fun save(person:Person1)
    fun update(id:Long , newPerson:Person1)
    fun remove(id:Long)
    fun findById(id:Long):Person1
    fun findAll():List<Person1>
}

class Person1DAOImpl: Person1DAO  {
    private val container:HashMap<Long , Person1> = HashMap<Long, Person1>()

    override fun save(person: Person1) {
       container[person.id] = person
    }

    override fun update(id: Long, newPerson: Person1) {
        container.remove(id)
        container[id] = newPerson
    }

    override fun remove(id: Long) {
        container.remove(id)
    }

    override fun findById(id: Long): Person1 {
        return container[id]!!
    }

    override fun findAll(): List<Person1> {
        val res = ArrayList<Person1>()
        for((k,v) in container) {
            res.add(v)
        }

        return res
    }
}


class Person1DAOWithBufferedReader {
    val dao: Person1DAOImpl
    val reader: BufferedReader
    constructor() {
        dao = Person1DAOImpl()
        reader = BufferedReader(InputStreamReader(System.`in`))
    }

    fun save() {
        val id:Long
        val name:String
        val age:Int
        val wage:Double
        val active:Boolean
        var line:String

        println("enter id of person: ")
        line = reader.readLine()
        id = line.toLong()

        println("enter name of person: ")
        name = reader.readLine()

        println("enter age of person: ")
        age = reader.readLine().toInt()

        println("enter wage of person: ")
        wage = reader.readLine().toDouble()

        println("enter active of person: ")
        active = reader.readLine().toBoolean()

        val p = Person1(id , name, age, wage, active)
        dao.save(p)
    }


    fun update() {
        val id:Long
        val name:String
        val age:Int
        val wage:Double
        val active:Boolean


        println("enter id of the person to be updated: ")
        id = reader.readLine().toLong()
        println("enter name of person: ")
        name = reader.readLine()
        println("enter age of person:")
        age = reader.readLine().toInt()
        println("enter wage of person: ")
        wage = reader.readLine().toDouble()
        println("enter active of person:")
        active = reader.readLine().toBoolean()
        dao.update(id, Person1(id, name, age, wage, active))
    }


    fun remove() {
        var id:Long
        println("enter id of the person to be removed: ")
        id = reader.readLine().toLong()
        dao.remove(id)
    }

    fun findById():Person1 {
        var id:Long
        println("enter id of the person to be returned: ")
        id = reader.readLine().toLong()
        return dao.findById(id)
    }

    fun findAll():List<Person1> {
        return dao.findAll()
    }
}
