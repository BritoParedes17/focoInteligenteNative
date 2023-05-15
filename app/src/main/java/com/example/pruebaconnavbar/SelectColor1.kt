package com.example.pruebaconnavbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import com.google.android.material.snackbar.Snackbar
import okhttp3.OkHttpClient
import okhttp3.Request

class SelectColor1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_color1)

        /* Codigo para mostrar el texto de los colores - Falta optimizacion */
        val btnRed = findViewById<Button>(R.id.button1)
        val messageRed = findViewById<TextView>(R.id.mensajeColor)

        val btnPink = findViewById<Button>(R.id.button2)
        val messagePink = findViewById<TextView>(R.id.mensajeColor)

        val btnPurple = findViewById<Button>(R.id.button3)
        val messagePurple = findViewById<TextView>(R.id.mensajeColor)

        val btnWhite = findViewById<Button>(R.id.button4)
        val messageWhite = findViewById<TextView>(R.id.mensajeColor)

        val btnBlue = findViewById<Button>(R.id.button5)
        val messageBlue = findViewById<TextView>(R.id.mensajeColor)

        val btnGreen = findViewById<Button>(R.id.button6)
        val messageGreen = findViewById<TextView>(R.id.mensajeColor)

        btnRed.setOnClickListener {
            messageRed.visibility = View.VISIBLE
            messageRed.text = "Rojo"
        }

        btnPink.setOnClickListener {
            messagePink.visibility = View.VISIBLE
            messagePink.text = "Rosa"
        }

        btnPurple.setOnClickListener {
            messagePurple.visibility = View.VISIBLE
            messagePurple.text = "Morado"
        }

        btnWhite.setOnClickListener {
            messageWhite.visibility = View.VISIBLE
            messageWhite.text = "Luz Blanca"
        }

        btnBlue.setOnClickListener {
            messageBlue.visibility = View.VISIBLE
            messageBlue.text = "Azul"
        }

        btnGreen.setOnClickListener {
            messageGreen.visibility = View.VISIBLE
            messageGreen.text = "Verde"
        }

        ////guardarColor()

        /* Consulta con colores */
        val btnEnviar = findViewById<Button>(R.id.btnSave)
        btnEnviar.setOnClickListener{View.OnClickListener {
            turnRedLED() }
        }

        /*val pruebaView = findViewById<ComposeView>(R.id.pruebaCompose) -> Solo para probar jetpack compose
        pruebaView.setContent {
            VistaPrueba()
        }*/
    }

    private fun turnRedLED() {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("http://www.google.com") /* Poner aqui la url del esp para el led rojo */
            .get()
            .build()

        try {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val btnSnackbar = findViewById<Button>(R.id.btnSave)
                btnSnackbar.setOnClickListener {
                    val snackbar = Snackbar.make(it, "Su color ha sido guardado", Snackbar.LENGTH_LONG)
                    snackbar.show()
                }
            } else {
                val btnSnackbar = findViewById<Button>(R.id.btnSave)
                btnSnackbar.setOnClickListener {
                    val snackbar = Snackbar.make(it, "No se pudo guardar", Snackbar.LENGTH_LONG)
                    snackbar.show()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /*
    Snackbar para mostrar que se guardo el registro, no hace nada más

    private fun guardarColor() {
        val btnSnackbar = findViewById<Button>(R.id.btnSave)
        btnSnackbar.setOnClickListener {
            val snackbar = Snackbar.make(it, "Su color ha sido guardado", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
    }*/
}

@Composable
private fun VistaPrueba(){
    Text("Hola como estás?")
}

