package com.edutilos.test4

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

//traditional way
class SimpleMathTest {
    private var simpleMath:SimpleMath? = null

    @Before fun setUp() {
        simpleMath = SimpleMath()
    }


    @Test fun test1() {
        val a = 10
        val b = 3
        assertEquals(13, simpleMath!!.add(a,b))
        assertEquals(7 , simpleMath!!.subtract(a,b))
        assertEquals(30, simpleMath!!.multiply(a,b))
    }
}
