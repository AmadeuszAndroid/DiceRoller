package com.example.diceroller

import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun generates_number() {
        val dice  = Dice(6)
        val rolledResult = dice.roll()
        assertTrue("Wartość rollResult nie była pomiędzy 1 i 6", rolledResult in 1..6)
    }

}