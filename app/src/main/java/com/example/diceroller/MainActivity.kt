package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button);
        rollButton.setOnClickListener{
            rollDice()
        }

        val countUpButton: Button = findViewById(R.id.countup_button);
        countUpButton.setOnClickListener { countUp() }
    }

    private fun rollDice() {
        // Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show();
        val randomInt = Random.nextInt(6) + 1;
        val resultText: TextView = findViewById(R.id.result_text);
        resultText.text = randomInt.toString();
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text);
        val text = resultText.text.toString();
        try {
            if (text.toInt() < 6) {
                resultText.text = (text.toInt() + 1).toString();
            }
        } catch(e: NumberFormatException) {
            resultText.text = "1";
        }
    }
}
