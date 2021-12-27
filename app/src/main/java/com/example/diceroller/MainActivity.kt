package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Ta aktywność pozwala użytkownikowi rzucać kostką i wyświetlać rezultat
 * na ekranie.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rolledButton: Button = findViewById(R.id.button)
        rolledButton.setOnClickListener { rollDice() }
    }

    /**
     * Rzuć kostką i wyświetl rezultat na ekranie.
     */
    private fun rollDice() {
        // Tworzenie kostki 6-ściennej i rzucenie nią.
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Aktualizacja ekranu o rzut kostką.
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}