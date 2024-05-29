package com.example.a30daysfitness.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.a30daysfitness.ui.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

sealed class Screen(val route: String) {
    object Start : Screen("start")
    object Login : Screen("login")
    object RegistrationEmailPassword : Screen("registrationEmailPassword")
    object RoleSelection : Screen("roleSelection/{email}/{password}") {
        fun createRoute(email: String, password: String) = "roleSelection/$email/$password"
    }
    object Registration : Screen("registration/{role}/{email}/{password}") {
        fun createRoute(role: String, email: String, password: String) = "registration/$role/$email/$password"
    }
    object Profile : Screen("profile")
    object CoachMenu : Screen("coachMenu")
    object PlayerMenu : Screen("playerMenu")
}

@Composable
fun NavGraph(navController: NavHostController, auth: FirebaseAuth, firestore: FirebaseFirestore) {
    NavHost(navController = navController, startDestination = Screen.Start.route) {
        composable(Screen.Start.route) {
            StartScreen(navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController,auth, firestore)
        }
        composable(Screen.RegistrationEmailPassword.route) {
            RegistrationEmailPasswordScreen(navController)
        }
        composable(
            route = Screen.RoleSelection.route,
            arguments = listOf(
                navArgument("email") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email") ?: ""
            val password = backStackEntry.arguments?.getString("password") ?: ""
            RoleSelectionScreen(navController, email, password)
        }
        composable(
            route = Screen.Registration.route,
            arguments = listOf(
                navArgument("role") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val role = backStackEntry.arguments?.getString("role") ?: ""
            val email = backStackEntry.arguments?.getString("email") ?: ""
            val password = backStackEntry.arguments?.getString("password") ?: ""
            RegistrationScreen(navController, role, email, password, auth, firestore)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController, auth)
        }
        composable(Screen.CoachMenu.route) {
            CoachMenuScreen(navController)
        }
        composable(Screen.PlayerMenu.route) {
            PlayerMenuScreen(navController)
        }
    }
}
