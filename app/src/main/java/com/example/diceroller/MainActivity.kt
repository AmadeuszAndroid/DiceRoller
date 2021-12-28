package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Ta aktywność pozwala użytkownikowi rzucać kostkami i wyświetlać rezultat
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
     * Rzuć kostkami i wyświetl rezultat na ekranie.
     */
    private fun rollDice() {
        // Tworzenie dwóch kostek 6-ściennych i rzucenie nimi.
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val upDice = Dice(6)
        val upDiceRoll = upDice.roll()

        // Aktualizacja ekranu o rzut kostkami.
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
        val upTextView: TextView = findViewById(R.id.textView2)
        upTextView.text = upDiceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}