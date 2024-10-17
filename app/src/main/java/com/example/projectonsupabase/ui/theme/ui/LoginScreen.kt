package com.example.projectonsupabase.ui.theme.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectonsupabase.MainActivity
import com.example.projectonsupabase.ViewModels.LoginViewModel
import com.example.projectonsupabase.ViewModels.LoginViewModelFactory

@Composable
fun LoginScreen(context: MainActivity)
{
    //Используем фабрику для создания LoginViewModel с параметром context
    val viewModel : LoginViewModel = viewModel(
        factory = LoginViewModelFactory(context)
    )

    var email by remember { mutableStateOf("")}
    var password by remember{ mutableStateOf("")}

    val loginSuccess = viewModel.loginSuccess
    val loginError = viewModel.loginError

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

        Spacer(modifier = Modifier.height(16.dp))

        if (loginSuccess) {
            Text("Login successful!", color = MaterialTheme.colorScheme.primary)
        } else if (loginError != null) {
            Text("Error: $loginError", color = MaterialTheme.colorScheme.error)
        }
    }
}