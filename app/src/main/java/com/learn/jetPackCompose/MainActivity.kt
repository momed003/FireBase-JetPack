package com.learn.jetPackCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.learn.jetPackCompose.ui.screen.ContactScreen
import com.learn.jetPackCompose.ui.screen.Home
import com.learn.jetPackCompose.ui.theme.FireBaseComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
          window.statusBarColor=getColor(R.color.teal_700)
           // Home()
            Tela()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tela(){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    "Tela de Contactos"
                },
                navigationIcon = { Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = ""
                )}
            )
        }
    ){
        paddingValues ->
        Column (modifier = Modifier.padding(paddingValues)){
            ContactScreen()
        }

    }
}
