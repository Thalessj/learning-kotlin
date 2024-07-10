package com.example.kotlinlearn

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.kotlinlearn.ui.theme.KotlinLearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinLearnTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AuthScreen(onEnterClick = {
                        Log.i("MainActivity", "onCreate: $it")
                    })
                }
            }
        }
    }
}

@Composable
fun AuthScreen(onEnterClick: (User) -> Unit) {
    Column {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        TextField(
            value = username,
            onValueChange = { newValue -> username = newValue },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            label = { Text("Usuário") },
            leadingIcon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Pessoa que representa o usuário") }
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            label = { Text("Senha") },
            leadingIcon = { Icon(imageVector = Icons.Default.Password, contentDescription = "Cadeado que representa a senha") },
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                        onEnterClick(
                            User(
                                username,
                                password
                            )
                        )
                      },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Entrar")
        }
    }
}

@Composable
fun AuthScreenPreview() {
    KotlinLearnTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            AuthScreen(onEnterClick = {})
        }
    }
}
