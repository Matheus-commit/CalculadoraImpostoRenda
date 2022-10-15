package br.com.cotemig.calculoimpostorenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var salario = findViewById<EditText>(R.id.salario)
        var btnCalcular = findViewById<Button>(R.id.btnCalcular)
        var salarioLiquido = findViewById<TextView>(R.id.salarioLiquido)
        var imposto = findViewById<TextView>(R.id.imposto)

        btnCalcular.setOnClickListener {

            var s = salario.text.toString().toDouble()
            var tax: Double

            if (s <= 1903.98) {
                tax = 0.0
            } else if (s <= 2826.65) {
                tax = (s * 0.075) - 142.8
            } else if (s <= 3751.05) {
                tax = (s * 0.15) - 354.8
            } else if (s <= 4664.68) {
                tax = (s * 0.225) - 636.13
            } else {
                tax = (s * 0.275) - 869.36
            }

            s -= tax

            var d = NumberFormat.
                getCurrencyInstance(Locale.forLanguageTag("pt-br"))

            salarioLiquido.text = d.format(s)
            imposto.text = d.format(tax)

        }


    }

}