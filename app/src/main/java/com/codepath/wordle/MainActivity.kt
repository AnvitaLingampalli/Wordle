package com.codepath.wordle

//import android.R
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.codepath.wordle.FourLetterWordList.getRandomFourLetterWord


class MainActivity : AppCompatActivity() {

    lateinit var editText : EditText
    val wordToGuess = getRandomFourLetterWord()
    var counter = 0
    var res = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val guess1 = findViewById<TextView>(R.id.textView13) as TextView
        val guess1Check = findViewById<TextView>(R.id.guess1Check)
        val actual = findViewById<TextView>(R.id.actualWord)
        val guess2 = findViewById<TextView>(R.id.guessTwo)
        val guess2Check = findViewById<TextView>(R.id.guessTwoCheck)
        val guess3 = findViewById<TextView>(R.id.guessThree)
        val guess3Check = findViewById<TextView>(R.id.guessThreeCheck)
        actual.text = wordToGuess




        button.setOnClickListener {
            counter++
            val editText =  findViewById<EditText>(R.id.guessBlank) as EditText
            val playerGuess = editText.text.toString()


            if(counter == 1) {
                guess1.text = playerGuess
                res = checkGuess(playerGuess)
                guess1Check.text = res
            }
            if(counter == 2) {
                guess2.text = playerGuess
                res = checkGuess(playerGuess)
                guess2Check.text = res
            }

            if(counter == 3) {
                button.isEnabled = false
                actual.visibility = View.VISIBLE
                guess3.text = playerGuess
                res = checkGuess(playerGuess)
                guess3Check.text = res
            }



        }
    }

    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}