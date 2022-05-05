package com.example.appinkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculadora.setOnClickListener {
            val intent:Intent = Intent(this, Calculadora::class.java)
            startActivity(intent)
        }

        btnCronometro.setOnClickListener {
            val intent:Intent = Intent(this, cronometro::class.java)
            startActivity(intent)
        }
        btnSalir.setOnClickListener {
            finish()
        }
    }

}