package org.example.bookapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform