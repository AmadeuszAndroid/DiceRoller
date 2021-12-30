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
        rolledButton.setOnClickListener { rollDice() }

        // Rzuć kostką kiedy aplikacja zostanie uruchomiona
        rollDice()
    }

    /**
     * Rzuć kostkami i wyświetl rezultat na ekranie.
     */
    private fun rollDice() {
        // Tworzenie kostki 6-ściennej i rzucenie nią
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Znajdź ImagView z pliku wartsw
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Ustaw któe identyfikatory obrazu będą wyświetlone w zależności od rzutu kostką
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Zaktualizuj ImageView poprawnym identyfikatorem obazu kostki.
        diceImage.setImageResource(drawableResource)

        // Zaktualizuj opis zawartości.
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}