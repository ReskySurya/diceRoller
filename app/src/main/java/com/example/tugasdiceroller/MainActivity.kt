package com.example.tugasdiceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kocokButton: Button = findViewById(R.id.button)
        kocokButton.setOnClickListener { kocokDadu() }
    }

    private fun kocokDadu() {
        val dadu = Dadu(6)
        val kocokan = dadu.kocok()
        val daduGambar : ImageView = findViewById(R.id.imageView)
        val kocokanResources = when (kocokan) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        daduGambar.setImageResource(kocokanResources)
        daduGambar.contentDescription = kocokan.toString()
    }
}

class Dadu(private val numSides: Int) {

    fun kocok(): Int {
        return (1..numSides).random()
    }
}