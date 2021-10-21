package com.tests.testcombank.soal1

import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tests.testcombank.R

class Soal1Activity : AppCompatActivity() {

    private lateinit var tvOutput: TextView
    private lateinit var etInput: EditText
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal1)

        tvOutput = findViewById(R.id.tvOutput)
        etInput = findViewById(R.id.etInput)
        btnSubmit = findViewById(R.id.btnSubmit)

        tvOutput.typeface = Typeface.MONOSPACE

        btnSubmit.setOnClickListener {
            if (etInput.text.isNotEmpty()) {
                stairCase(etInput.text.toString().toInt())
                stairCaseLog(etInput.text.toString().toInt())
            } else {
                Toast.makeText(this, "Please, Insert!", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }

    private fun stairCase(n: Int) {
        tvOutput.text = ""
        if (n in 1..100) { // equivalent condition if 1 until 100
            for (x in 1..n) { // equivalent of 1 <= x && x <= n
                for (y in 1..n) {
                    val data = if ((x + y) > n) "*" else " "
                    tvOutput.append(data)
                }
                tvOutput.append("\n");
            }
        } else {
            Toast.makeText(this, "Error boys, data cant insert more than 100", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun stairCaseLog(n: Int): Unit {
        if (n in 1..100) { // equivalent condition if 1 until 100
            for (x in 1..n) { // equivalent of 1 <= x && x <= n
                for (y in 1..n) {
                    val data = if ((x + y) > n) '*' else ' '
                    print(data)
                }
                println()
            }
        } else {
            Toast.makeText(this, "Error boys, data cant insert more than 100", Toast.LENGTH_SHORT)
                .show()
        }
    }
}

