package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT)
            toast.show()

            //val resultTextView: TextView = findViewById(R.id.textView)
            //resultTextView.text = "6"

            rolldice(findViewById(R.id.diceOne))
            rolldice(findViewById(R.id.diceTwo))

        }
    }

    private fun rolldice(diceImage: ImageView) {
        val dice = Dice(6)
        val diceRoll = dice.roll()
      //  val diceImage: ImageView =
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }
}

/**
 * Roll the dice and update the screen with the result.
 */
class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
