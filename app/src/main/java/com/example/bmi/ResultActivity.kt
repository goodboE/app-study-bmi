package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //if (intent == null || intent.extras == null) return

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        val textHeight:TextView = findViewById(R.id.textHeight)
        val textWeight:TextView = findViewById(R.id.textWeight)
        val textBMI:TextView = findViewById(R.id.textBMI)
        val textInfo:TextView = findViewById(R.id.textInfo)

        val bmi = weight / (height / 100.0).pow(2.0)
        val bmiInfo = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과제충"
            bmi >= 18.0 -> "정상 체중"
            else -> "저체중"
        }


        textHeight.text = height.toString()
        textWeight.text = weight.toString()
        textBMI.text = bmi.toString()
        textInfo.text = bmiInfo


        val btnBack: Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
    }
}