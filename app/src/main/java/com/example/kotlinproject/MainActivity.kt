package com.example.kotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById(R.id.buttonCalcular) as Button
        button.setOnClickListener { calcularPreco() }
    }

    fun calcularPreco(){
        val precoAlcool = findViewById<TextView>(R.id.editTextAlcool).text.toString();
        val precoGasolina = findViewById<TextView>(R.id.editTextGasolina).text.toString();

        if(validarCampos(precoAlcool, precoGasolina)){
            melhorPreco(precoAlcool, precoGasolina)
        }else{
            Toast.makeText(applicationContext, "Preencha todos os campos antes de continuar", Toast.LENGTH_SHORT).show()
        }
    }
    fun melhorPreco(precoAlcool: String, precoGasolina: String){
        val alcool = precoAlcool.toDouble()
        val gasolina = precoGasolina.toDouble()
        val textResultado = findViewById<TextView>(R.id.textViewResposta)
        /*
        Se alcool/gasolina > 0.7 -> melhor gasolina
        se alcool/gasolina < 0.7 -> melhor alcool
         */
        val resultado = alcool/gasolina
        if(resultado >= 0.7){
            textResultado.setText("A melhor opção é gasolina")
        }else{
            textResultado.setText("A melhor opção é alcool")
        }
    }
    fun validarCampos(precoAlcool: String, precoGasolina: String) : Boolean{
        if(!precoAlcool.isEmpty() || !precoAlcool.equals("")){
            if(!precoGasolina.isEmpty() || !precoGasolina.equals("")){
                return true;
            }
        }
        return false;
    }
}