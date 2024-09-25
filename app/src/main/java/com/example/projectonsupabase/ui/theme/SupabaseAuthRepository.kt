package com.example.projectonsupabase.ui.theme

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import io.ktor.client.engine.cio.*

class SupabaseAuthRepository {
    private val client = HttpClient(CIO)
    {
        install(ContentNegotiation) {
            json(Json
            { ignoreUnknownKeys = true })

        }
    }
}
