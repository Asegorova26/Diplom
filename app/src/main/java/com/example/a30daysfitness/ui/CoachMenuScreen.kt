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
fun CoachMenuScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Меню Тренера", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate(Screen.Profile.route) }, modifier = Modifier.fillMaxWidth()) {
            Text("Профиль")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* TODO: Навигация на экран назначения тренировок */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Назначение тренировок")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* TODO: Навигация на экран статистики */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Статистика")
        }
    }
}
