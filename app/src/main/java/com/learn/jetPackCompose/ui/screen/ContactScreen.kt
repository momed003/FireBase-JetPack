package com.learn.jetPackCompose.ui.screen

import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database
import com.learn.jetPackCompose.ui.component.CustomTextFied

@Composable
fun ContactScreen() {
    val db = FirebaseDatabase.getInstance()
    //val ref = db.getReference("Contact description: ")


    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var adress by remember { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        CustomTextFied(name, "Nome:"){name=it}
        Spacer(modifier = Modifier.height(5.dp))
        CustomTextFied(email, "Email: "){email=it}
        Spacer(modifier = Modifier.height(5.dp))
        CustomTextFied(phone, "Contacto"){phone=it}
        Spacer(modifier = Modifier.height(5.dp))
        CustomTextFied(adress, "Endereço"){adress=it}
        Spacer(modifier = Modifier.height(20.dp))

        val context = LocalContext.current
        Button(
            onClick = {
                val contactsRef = db.reference.child("Contact")

                val contactId=contactsRef.push().key ?: return@Button
                val contact = Contact(name,email, phone, adress)
                contactsRef.child(contactId).setValue(contact)

                Toast.makeText(context, "Contacto salvo!", Toast.LENGTH_SHORT).show()
                name = ""
                email = ""
                phone = ""
                adress = ""
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Salvar")
        }
    }
}

data class Contact(
    val name: String,
    val email: String,
    val phone: String,
    val adress: String
)