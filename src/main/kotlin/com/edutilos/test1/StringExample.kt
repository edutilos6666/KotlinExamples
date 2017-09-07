package com.edutilos.test1

fun main(args:Array<String>) {



    fun test11() {
        val str = "foo,bar;bim.pako"
        val splitted = str.split("\\.|,|;".toRegex())
        println(splitted)
    }


    fun test12() {
        val str = "foo,bar;bim.pako"
        val splitted = str.split(".",",",";")
        println(splitted)
    }

    fun test13() {
        var input = "/home/edutilos/Desktop/foo.bar"
        var dirName = input.substringBeforeLast("/")
        var fullName = input.substringAfterLast("/")
        var fileName = fullName.substringBeforeLast(".")
        var ext = fullName.substringAfterLast(".")
        println("dirName = $dirName")
        println("fullName = $fullName")
        println("fileName = $fileName")
        println("ext = $ext")
    }


    fun test14() {
        var input = "/home/edutilos/Desktop/bar.bim"
        var regex = """(.+)/(.+)\.(.+)""".toRegex()
        var matchResult = regex.matchEntire(input)
        if(matchResult != null) {
            val (dirName, fileName, ext) = matchResult.destructured
            println("dirName = $dirName")
            println("fileName = $fileName")
            println("ext = $ext")
        }
    }

    fun test15() {
        var input = """|foo
                      .|bar
                      .|bim"""

        println(input.trimMargin("."))
        println(input)
    }



    class User(val id:Long , val name:String , val address:String)

    fun saveUser(user:User) {
        fun validate(value:String , fieldName:String) {
            if(value.isEmpty()) {
                throw IllegalArgumentException("$fieldName of ${user.id} is empty.")
            }
        }

        validate(user.name, "Name")
        validate(user.address, "Address")

        //persist into database
        println("saved instance ${user.id} into database successfully.")
    }



    class User2(val id:Long, val name:String , val address:String)

    fun User2.validateBeforeSave() {
        fun validate(value:String , fieldName:String) {
            if(value.isEmpty()) {
               throw IllegalArgumentException("$fieldName of ${id} is empty.")
            }
        }

        validate(name, "Name")
        validate(address, "Address")

    }

    fun saveUser2(user2:User2) {
        user2.validateBeforeSave()
        println("saved instance ${user2.name} into db successfully.")
    }


    test11()
    test12()
    println()
    test13()
    println()
    test14()
    println()
    test15()
    println()
    saveUser(User(1L, "foo", "foo@yahoo.com"))
    // saveUser(User(2L, "bar", ""))
    println()
    saveUser2(User2(1L, "foo", "foo@yahoo.com"))
//    saveUser2(User2(1L, "foo", ""))
}
