package com.example.a30daysfitness.ui

sealed class Screen(val route: String) {
    object Auth : Screen("auth")
    object Profile : Screen("profile")
}
