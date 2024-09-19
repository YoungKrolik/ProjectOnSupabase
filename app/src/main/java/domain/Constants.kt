package domain

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object Constants {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://aslycnfddvdpvujaqobs.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImFzbHljbmZkZHZkcHZ1amFxb2JzIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MjU2MDA3MjYsImV4cCI6MjA0MTE3NjcyNn0.D6bpfITjEKAbUCkpuAOU21b7Evk1tCwPrYlOjAb-2i4"
    ) {
        install(Auth)
        install(Postgrest)
        install(Storage)
    }

}