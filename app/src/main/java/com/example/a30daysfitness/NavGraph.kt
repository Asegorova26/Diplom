package com.example.a30daysfitness

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.FirebaseAuth

sealed class Screen(val route: String) {
    object Auth : Screen("auth")
    object Profile : Screen("profile")
}

@Composable
fun NavGraph(navController: NavHostController, auth: FirebaseAuth) {
    NavHost(navController = navController, startDestination = Screen.Auth.route) {
        composable(Screen.Auth.route) {
            AuthScreen(navController, auth)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(auth)
        }
    }
}


