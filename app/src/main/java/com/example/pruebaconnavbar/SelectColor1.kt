package com.example.pruebaconnavbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView

class SelectColor1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_color1)

        /*val pruebaView = findViewById<ComposeView>(R.id.pruebaCompose)
        pruebaView.setContent {
            VistaPrueba()
        }*/
    }
}

@Composable
private fun VistaPrueba(){
    Text("Hola como estás?")
}