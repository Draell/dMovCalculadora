package com.example.dmovcalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.dmovcalculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var firstValue: Double = 0.0
    var operator: Char = '0'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnAC.setOnClickListener{
            binding.pantalla.text.clear()
        }

        binding.btnDEL.setOnClickListener{
            binding.pantalla.setText(binding.pantalla.text.dropLast(1))
        }

        binding.btnIgual.setOnClickListener{
            when (operator){
                '+' -> {
                    binding.pantalla.setText("${firstValue + binding.pantalla.text.toString().toDouble()}")
                }

                '×' -> {
                    binding.pantalla.setText("${firstValue * binding.pantalla.text.toString().toDouble()}")
                }

                '÷' -> {
                    binding.pantalla.setText("${firstValue / binding.pantalla.text.toString().toDouble()}")
                }

                '-' -> {
                    binding.pantalla.setText("${firstValue - binding.pantalla.text.toString().toDouble()}")
                }

                else -> binding.pantalla.setText("error")
            }
        }

        binding.btnPorcentaje.setOnClickListener{
            binding.pantalla.setText(porcentaje(operator))
        }
    }

    fun porcentaje(operatorToUse: Char) : String {
        when (operatorToUse){
            '+' -> {return "${firstValue + (firstValue*binding.pantalla.text.toString().toDouble()/100)}"}
            '-' -> {return "${firstValue - (firstValue*binding.pantalla.text.toString().toDouble()/100)}"}
            '0' -> {return "${binding.pantalla.text.toString().toDouble()/100}"}
            else -> {return "Error"}
        }
    }


    fun getOperator(view: View){
        val button = view as Button

        operator = button.text.get(0)

       /* operator = when(button.id){
            binding.btnDiv.id -> {'÷'}
            binding.btnMult.id -> {'x'}
            binding.btnSuma.id -> {'+'}
            binding.btnResta.id -> {'-'}
            else -> { '0' }
        }*/

        firstValue = binding.pantalla.text.toString().toDouble()
        binding.pantalla.text.clear()
    }

    fun numberButtonClicked(view: View){
        val button = view as Button

        if(button.id.equals(binding.btnPunto.id) ){
            if(!binding.pantalla.text.contains('.')){
                binding.pantalla.text.append(button.text)
            }
        }else{
            binding.pantalla.text.append(button.text)
        }



        /*
        when(button.id){
            binding.btnPunto.id -> {
                if (!binding.pantalla.text.contains('')){
                    binding.pantalla.text.append(".")
                    }
                }

            binding.btn0.id -> {binding.pantalla.text.append("0")}
            binding.btn1.id -> {binding.pantalla.text.append("1")}
            binding.btn2.id -> {binding.pantalla.text.append("2")}
            binding.btn3.id -> {binding.pantalla.text.append("3")}
            binding.btn4.id -> {binding.pantalla.text.append("4")}
            binding.btn5.id -> {binding.pantalla.text.append("5")}
            binding.btn6.id -> {binding.pantalla.text.append("6")}
            binding.btn7.id -> {binding.pantalla.text.append("7")}
            binding.btn8.id -> {binding.pantalla.text.append("8")}
            binding.btn9.id -> {binding.pantalla.text.append("9")}
            else -> {
            Toast.makeText(this, "else", Toast.LENGTH_SHORT).show()
        }
    }

         */
    }
}