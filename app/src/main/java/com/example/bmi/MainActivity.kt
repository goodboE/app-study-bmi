package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText: EditText = findViewById(R.id.heightEditText)
        val weightEditText: EditText = findViewById(R.id.weightEditText)
        val btnConfirm: Button = findViewById(R.id.btnConfirm)

        btnConfirm.setOnClickListener {

            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty()) {
                Toast.makeText(applicationContext, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // 리스너를 빠져나옴
            }

            val intent = Intent(this, ResultActivity::class.java)
            val height = heightEditText.text.toString().toInt()
            val weight = weightEditText.text.toString().toInt()
            intent.putExtra("height",height)
            intent.putExtra("weight",weight)
            startActivity(intent)
        }


    }
}