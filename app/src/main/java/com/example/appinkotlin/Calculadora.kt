package com.example.appinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_calculadora.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat


class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        buttonLimpiar.setOnClickListener {
            sec.text = ""
            main.text = ""
        }

        buttonParentesisIzq.setOnClickListener {
            sec.text = addToInputText("(")
        }
        buttonParentesisDer.setOnClickListener {
            sec.text = addToInputText(")")
        }
        button_0.setOnClickListener {
            sec.text = addToInputText("0")
        }
        button_1.setOnClickListener {
            sec.text = addToInputText("1")
        }
        button_2.setOnClickListener {
            sec.text = addToInputText("2")
        }
        button_3.setOnClickListener {
            sec.text = addToInputText("3")
        }
        button_4.setOnClickListener {
            sec.text = addToInputText("4")
        }
        button_5.setOnClickListener {
            sec.text = addToInputText("5")
        }
        button_6.setOnClickListener {
            sec.text = addToInputText("6")
        }
        button_7.setOnClickListener {
            sec.text = addToInputText("7")
        }
        button_8.setOnClickListener {
            sec.text = addToInputText("8")
        }
        button_9.setOnClickListener {
            sec.text = addToInputText("9")
        }
        buttonPunto.setOnClickListener {
            sec.text = addToInputText(".")
        }
        buttonDivision.setOnClickListener {
            sec.text = addToInputText("÷") // ALT + 0247
        }
        buttonMultiplicacion.setOnClickListener {
            sec.text = addToInputText("×") // ALT + 0215
        }
        buttonResta.setOnClickListener {
            sec.text = addToInputText("-")
        }
        buttonSuma.setOnClickListener {
            sec.text = addToInputText("+")
        }

        buttonIgual.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {
        return "${sec.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = sec.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                main.text = "Error"
                main.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                main.text = DecimalFormat("0.######").format(result).toString()
                main.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            main.text = "Error"
            main.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}