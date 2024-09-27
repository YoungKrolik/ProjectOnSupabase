package com.example.projectonsupabase.ui.theme.ui

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.*
import com.example.projectonsupabase.ViewModels.LoginViewModel

@Composable
fun LoginScreen(context: Context, viewModel: LoginViewModel = viewModel())
{
    var email by remember { mutableStateOf("")}
    var password by remember{ mutableStateOf("")}
    val loginSuccess by remember { mutableStateOf(viewModel.loginError)}
    val loginError by remember { mutableStateOf(viewModel.loginError)}

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier =
        Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange ={ password = it },
            label = { Text("Password")},
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier =
        Modifier.height(16.dp))

        Button(
            onClick = { 
                viewModel.login(email, password) //Вызываем коллбек при клике на кнопку
            },
            modifier = Modifier.fillMaxWidth()
        ) {
           Text("Login")
        }

        Spacer(modifier =
        Modifier.height(16.dp))

        if (loginSuccess) {
            Text("Login successful!", color = MaterialTheme.colorScheme.primary)
        } else if (loginError != null) {
            Text("Error: $loginError", color = MaterialTheme.colorScheme.error)
        }
    }
}