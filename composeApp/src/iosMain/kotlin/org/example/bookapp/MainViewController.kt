package org.example.bookapp

import androidx.compose.ui.window.ComposeUIViewController
import org.example.bookapp.app.App
import org.example.bookapp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) { App() }