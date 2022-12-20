package com.example.miprimerapp

import android.content.Context
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miprimerapp.ui.theme.MiPrimerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginUI(applicationContext)
        }
    }
}

@Composable
fun LoginUI(context: Context) {
    //Variables
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    //Diseño
    Column() {

        //Titulo
        Text(
            text = "Iniciar Sesión",
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp, top = 20.dp)
        )

        //TextField EMAIL
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Ingresar Email") },
            leadingIcon = {
                Icon(Icons.Default.AccountCircle, contentDescription = "Person")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        //TextField PASSWORD
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Ingresar Contraseña") },
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        //Button Login
        OutlinedButton(
            onClick = { logged(email, password, context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        ) {
            //Text del button
            Text(
                text = "login",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

//fun Logear
fun logged(email: String, password: String, context: Context) {
    if (email == "john@dot.com" && password == "1234") {
        Toast.makeText(context, "Correcto inicio de sesión", Toast.LENGTH_SHORT).show()

    } else {
        Toast.makeText(context, "inicio de sesión Fallido", Toast.LENGTH_SHORT).show()
    }
}

