package com.example.juegodel7

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
 var intentos = 3
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            btnjugar.setOnClickListener {
                if (intentos > 0) {
                    txtcentro.setText(valorRandom(1..9).toString())
                    txtderecha.setText(valorRandom(1..9).toString())
                    txtizquierda.setText(valorRandom(1..9).toString())
                    if (txtderecha.equals(7) && (txtcentro.equals(7) && (txtizquierda.equals(7)))) {
                        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                        builder.setTitle("FELICIDADES!!!!!")
                        builder.setMessage("Enhorabuena Has Ganado")
                        builder.setPositiveButton("Aceptar", null)
                        val dialog: AlertDialog = builder.create()
                        dialog.show()
                    } else {
                        intentos--
                        txtintentos.setText("intentos " + intentos)
                    }
                }
                else {
                    val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                    builder.setTitle("LO SIENTO:[")
                    builder.setMessage("Has agotado tus intentos")
                    builder.setPositiveButton("Aceptar", null)
                    val dialog: AlertDialog = builder.create()
                    dialog.show()
                    intentos = 3
                    txtintentos.setText("Intentos "+ intentos)
                    txtderecha.setText("")
                    txtcentro.setText("")
                    txtizquierda.setText("")
                }
            }


    }
    fun valorRandom(valores: IntRange) : Int {
        var r = Random()
        var valorRandom = r.nextInt(valores.last - valores.first) + valores.first
        return valorRandom
    }
}