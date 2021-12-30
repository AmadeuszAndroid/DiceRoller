package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        rolledButton.setOnClickListener { rollDices() }

        // Rzuć kośćmi kiedy aplikacja zostanie uruchomiona
        rollDices()
    }

    /**
     * Rzuć kostkami i wyświetl rezultat na ekranie.
     */
    private fun rollDices() {
        // Tworzenie kości 6-ściennych i rzucenie nimi
        val downDice = Dice(6)
        val downDiceRoll = downDice.roll()
        val upDice = Dice(6)
        val upDiceRoll = upDice.roll()

        // Znajdź ImagView z pliku wartsw
        val downDiceImage: ImageView = findViewById(R.id.imageView)
        val upDiceImage: ImageView = findViewById(R.id.imageView2)

        // Ustaw któe identyfikatory obrazu będą wyświetlone w zależności od rzutu kośćmi
        val downDiceDrawableResource = when (downDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val upDiceDrawableResource = when (upDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Zaktualizuj ImageView poprawnym identyfikatorem obazu kości.
        downDiceImage.setImageResource(downDiceDrawableResource)
        upDiceImage.setImageResource(upDiceDrawableResource)

        // Zaktualizuj opis zawartości.
        downDiceImage.contentDescription = downDiceRoll.toString()
        upDiceImage.contentDescription = upDiceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}