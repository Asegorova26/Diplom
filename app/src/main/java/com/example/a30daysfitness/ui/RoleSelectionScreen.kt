package com.example.a30daysfitness.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.a30daysfitness.navigation.Screen

@Composable
fun RoleSelectionScreen(navController: NavHostController, email: String, password: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Выберите роль", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate(Screen.Registration.createRoute("Игрок", email, password))
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Игрок")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate(Screen.Registration.createRoute("Тренер", email, password))
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Тренер")
        }
    }
}
