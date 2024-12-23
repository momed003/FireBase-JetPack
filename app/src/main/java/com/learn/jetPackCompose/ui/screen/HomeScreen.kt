package com.learn.jetPackCompose.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.database.database

@Composable
fun Home() {

    //connecting real time fireBase
    val db = Firebase.database
    val ref = db.getReference("name")

//    ref.setValue("FirstConnetion in FireBase")
    var text by remember { mutableStateOf("") }

    Column (modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            label = { Text(text="Informe seu nome")}
        )
        Button(
            onClick = {ref.setValue(text)},
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text="Enviar")
        }
    }
}