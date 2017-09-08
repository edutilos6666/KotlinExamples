package com.edutilos.test4

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class SimpleMathTest2 {
    private lateinit var simpleMath:SimpleMath

    @Before fun setUp() {
        simpleMath = SimpleMath()
    }

    @Test fun test1() {
        val a = 4
        val b = 3
        assertEquals(7 , simpleMath.add(a,b))
        assertEquals(1, simpleMath.subtract(a,b))
        assertEquals(12 , simpleMath.multiply(a,b))
    }
}
