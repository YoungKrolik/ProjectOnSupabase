package com.example.projectonsupabase.ViewModels

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.projectonsupabase.ui.theme.ui.SupabaseAuthRepository

class LoginViewModel(private val context: Context) : ViewModel() {
    private val authRepository = SupabaseAuthRepository(context)

    var loginSuccess by mutableStateOf(false)
        private set

    var loginError by mutableStateOf<String?>(null)
        private set

    //Функция для авторизации
    fun login(email: String, password: String) {
        authRepository.login(email, password, { success ->
            loginSuccess = success
            loginError = null
        }, { error ->
            loginSuccess = false
            loginError = error
        })
    }
}