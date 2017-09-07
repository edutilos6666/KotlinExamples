package com.edutilos.test2

object InterfaceExample1 {
    @JvmStatic fun main(args:Array<String>) {
        testMyFile()
    }

    @JvmStatic fun testMyFile() {
        var file = MyFile("foo.exe", "/home/edutilos/Desktop")
        println("is writable = ${file.isWritable()}")
        println("is executable = ${file.isExecutable()}")
        println("is readable = ${file.isReadable()}")

        file.write("dummy content")
        var temp = file.read()
        println("temp = $temp")
        file.execute()
    }



    interface Writable {
        fun write(str:String)
        fun isWritable():Boolean
    }

    interface Readable {
        fun read():String
        fun isReadable():Boolean
    }

    interface Executable {
        fun execute()
        fun isExecutable():Boolean
    }

    class MyFile(val name:String, val parent:String): Writable, Readable, Executable  {
        var temp:String? = null

        override fun write(str: String) {
            temp = str
            println("$str was written into $parent/$name")
        }

        override fun isWritable(): Boolean {
            return true
        }

        override fun read(): String {
            return temp!!
        }

        override fun isReadable(): Boolean {
            return true
        }

        override fun execute() {
            println("$parent/$name was executed successfully.")
        }

        override fun isExecutable(): Boolean {
            return true
        }
    }
}