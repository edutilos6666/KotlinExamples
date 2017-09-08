package com.edutilos.test9

import java.time.LocalDate
import java.time.Period

object ExtensionPropertiesExample {
    @JvmStatic
    fun main(args: Array<String>) {
        test1()
    }

    val Int.days :Period
      get() = Period.ofDays(this)

    val Period.ago : LocalDate
     get() = LocalDate.now() - this

    val Period.fromNow :LocalDate
      get() = LocalDate.now() + this

    private fun test1() {
        println(2.days.ago)
        println(2.days.fromNow)
    }
}

