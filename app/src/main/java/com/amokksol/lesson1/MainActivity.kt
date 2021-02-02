package com.amokksol.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
//объявляем переменную до запуска приложения. чтобы потмо не вызыват ьее каждый рапз в функции
lateinit var diceImage: ImageView
lateinit var diceImage2: ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //указываем на что ссылается ранее объявленная переменная
        diceImage=findViewById(R.id.dice_image)
        diceImage2=findViewById(R.id.dice_image2)
        //кнопка Roll - делаем ее доступной в интерфейсе
        val rollButton:Button = findViewById(R.id.roll_button)
        //зпуск функции rollDice - при нажатии
        rollButton.setOnClickListener { rollDice() }

        val clearButton:Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener { clearDice() }
    }

  private fun rollDice(){

        //при нажатии на кнопку RandomInt - будет меняться каждый раз в данном диапазоне
        val randomInt = (1..6).random()
        val randomInt2 = (1..6).random()

        //проверяем все условия и для каждого свой рисунок
        val drawableResource = when(randomInt) {
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else ->R.drawable.dice_6
        }
      val drawableResource2 = when(randomInt2) {
          1->R.drawable.dice_1
          2->R.drawable.dice_2
          3->R.drawable.dice_3
          4->R.drawable.dice_4
          5->R.drawable.dice_5
          else ->R.drawable.dice_6
      }

        //передаем рисунок перемнной diceImage  - которая имеет ссылку на ImageView
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)
}

    private fun clearDice(){
        val cleanImage = R.drawable.empty_dice
        diceImage.setImageResource(cleanImage )
        diceImage2.setImageResource(cleanImage )


    }
}