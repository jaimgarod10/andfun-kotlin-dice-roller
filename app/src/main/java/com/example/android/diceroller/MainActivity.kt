/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.*
import java.util.*

class MainActivity : AppCompatActivity() {
    //definimos ImageView
    lateinit var diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //definimos el boton tirar dado
        val rollButton: Button = findViewById(R.id.roll_button)
        //llama a la función rollDice cuando se hace click en el boton de tirar
        rollButton.setOnClickListener {
            rollDice()
        }

        diceImage = findViewById(R.id.dice_image)//se carga el ImageView
        diceImage.setImageResource(R.drawable.dado)//se muestra una imagen dentro del ImageView
    }

    private fun rollDice() {
        //generamos un numero aleatorio con la función random
        val randomInt = Random().nextInt(6) + 1
        //dependiendo del numero que salga de la función random se muestra una imagen diferente
        val drawableResource = when (randomInt) {
            1 -> diceImage.setImageResource(R.drawable._1)
            2 -> diceImage.setImageResource(R.drawable._2)
            3 -> diceImage.setImageResource(R.drawable._3)
            4 -> diceImage.setImageResource(R.drawable._4)
            5 -> diceImage.setImageResource(R.drawable._5)
            else -> diceImage.setImageResource(R.drawable._6)
        }
    }
}
