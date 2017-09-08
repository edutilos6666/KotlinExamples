package com.edutilos.test5


object LazyLoadingExample1  {
    @JvmStatic
    fun main(args: Array<String>) {
        test2()
    }

    private fun loadEmails2(person:Person2):List<Email> {
        println("loading emails of ${person.name}")
        return arrayListOf<Email>(
                Email("foo", "edu", "title1", "content1"),
                Email("bar", "edu", "title2", "content2"),
                Email("bim", "edu", "title3", "content3")
        )
    }

    data class Person2(val  name:String) {
        val emails  by lazy { loadEmails2(this)}
    }

    private fun test2() {
        val p = Person2("foo")
        for(e in p.emails) println(e)
        println()
        for(e in p.emails) println(e)
    }


    data class Email(val from:String , val to:String , val title:String , val content:String)
    private fun loadEmails(person:Person):List<Email> {
        println("loading emails of ${person.name}")
        return arrayListOf<Email>(
                Email("foo", "edu", "title1", "content1"),
                Email("bar", "edu", "title2", "content2"),
                Email("bim", "edu", "title3", "content3")
        )
    }
    data class Person(val name:String) {
        private var _emails:List<Email>? = null
        val emails:List<Email>
            get() {
                if(_emails == null) _emails = loadEmails(this)
                return _emails!!
            }
    }


    private fun test1() {
        val p = Person("foo")
        for(e in p.emails) println(e)
        println()
        for(e in p.emails) println(e)
    }
}

