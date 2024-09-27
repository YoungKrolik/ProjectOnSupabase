package com.example.projectonsupabase.ui.theme.ui

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


class SupabaseAuthRepository (private val context: Context) {
    //Supabase URL и ключ
    private val supabaseUrl = "https://aslycnfddvdpvujaqobs.supabase.co"
    private val supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImFzbHljbmZkZHZkcHZ1amFxb2JzIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MjU2MDA3MjYsImV4cCI6MjA0MTE3NjcyNn0.D6bpfITjEKAbUCkpuAOU21b7Evk1tCwPrYlOjAb-2i4"

    private val requestQueue:
            RequestQueue by lazy {
                Volley.newRequestQueue(context)
    }

    fun login(email: String, password:
    String, onSuccess: (Boolean) -> Unit, onError: (String) -> Unit) {
        val url = "$supabaseUrl/auth/v1/token?grant_type=password"

        val params = JSONObject().apply {
            put("email", email)
            put("password", password)
        }

        val request = object :  JsonObjectRequest(
            Request.Method.POST, url, params,
            { response ->
                //Обработка успешного ответа, например, получение access_token
                val accessToken = response.optString("access_token", "")
                if (accessToken.isNotEmpty()){
                    onSuccess(true)
                } else {
                    onError("Неверный ответ от сервера.")
                }
            },
            { error ->
                /* Обработка ошибок запроса */
                error.printStackTrace()
                onError(error.localizedMessage ?: "Произошла ошибка :(")
            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["apikey"] = supabaseKey
                headers["Content-Type"] = "application/json"
                return headers
            }
        }
        requestQueue.add(request)

    }
}




