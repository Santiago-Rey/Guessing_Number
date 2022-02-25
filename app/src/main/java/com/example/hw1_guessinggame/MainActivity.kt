package com.example.hw1_guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    var randomNumber = 0
    lateinit var numberUser : EditText
    lateinit var textCounts : TextView
    var cont = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberUser = findViewById(R.id.textNumber)
        textCounts = findViewById(R.id.textCount)
        val button = findViewById<Button>(R.id.btnAccept)
        val btnAgain = findViewById<Button>(R.id.btnAgain)
        generateRandom()
        button.setOnClickListener {
            guessNumber()
        }
        btnAgain.setOnClickListener {
            againGame()
        }
    }


    fun guessNumber (){
        val number = numberUser.text.toString().toIntOrNull() //El text es como capturar el texto que ingrese despues de oprimir el boton, convierte a texto con el toString
        textCounts.setTextColor(resources.getColor(android.R.color.holo_red_dark)) //Trae un recurso de un color que tiene android
        when {
            number == null -> {
                textCounts.text = "No es un número"
                //Toast.makeText(this, "No es un número" , Toast.LENGTH_SHORT).show()
            }

            number > randomNumber -> {
                textCounts.text = "Estuvo cerca pero, el valor es menor"
            }

            number < randomNumber -> {
                textCounts.text = "Estuvo cerca pero, el valor es mayor"
            }

            number == randomNumber -> {
                textCounts.text = "Es el número y realizaste $cont intentos"
                textCounts.setTextColor(resources.getColor(android.R.color.holo_green_light))


            }

        }

        numberUser.text.clear()

        cont ++

    }

    fun againGame (){

        cont = 0
        numberUser.text.clear()
        generateRandom()


    }

    fun generateRandom(){
        randomNumber = (1..1000).random()
    }


}