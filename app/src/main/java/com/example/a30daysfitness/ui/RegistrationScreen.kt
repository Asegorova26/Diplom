package com.example.a30daysfitness.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.example.a30daysfitness.navigation.Screen

@Composable
fun RegistrationScreen(navController: NavHostController, role: String, email: String, password: String, auth: FirebaseAuth, firestore: FirebaseFirestore) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var team by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var position by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var genderExpanded by remember { mutableStateOf(false) }
    var positionExpanded by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    val genders = listOf("Мужской", "Женский")
    val positions = listOf("Разыгрывающий", "Атакующий защитник", "Легкий форвард", "Тяжелый форвард", "Центровой")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Дополнительная информация $role", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("Имя") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Фамилия") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Возраст (лет)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = gender,
                onValueChange = { gender = it },
                label = { Text("Пол") },
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { genderExpanded = true }
            )
            DropdownMenu(
                expanded = genderExpanded,
                onDismissRequest = { genderExpanded = false }
            ) {
                genders.forEach { g ->
                    DropdownMenuItem(
                        text = { Text(g) },
                        onClick = {
                            gender = g
                            genderExpanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = team,
            onValueChange = { team = it },
            label = { Text("Команда") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        if (role == "Игрок") {
            OutlinedTextField(
                value = height,
                onValueChange = { height = it },
                label = { Text("Рост (см)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = position,
                    onValueChange = { position = it },
                    label = { Text("Позиция") },
                    readOnly = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { positionExpanded = true }
                )
                DropdownMenu(
                    expanded = positionExpanded,
                    onDismissRequest = { positionExpanded = false }
                ) {
                    positions.forEach { pos ->
                        DropdownMenuItem(
                            text = { Text(pos) },
                            onClick = {
                                position = pos
                                positionExpanded = false
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Назад")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    if (email.isNotEmpty() && password.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty()) {
                        auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val user = auth.currentUser
                                    val userId = user?.uid
                                    val userMap = hashMapOf(
                                        "email" to email,
                                        "role" to role,
                                        "firstName" to firstName,
                                        "lastName" to lastName,
                                        "team" to team,
                                        "age" to age,
                                        "height" to height,
                                        "position" to position,
                                        "gender" to gender
                                    )
                                    if (userId != null) {
                                        firestore.collection("users").document(userId).set(userMap)
                                            .addOnSuccessListener {
                                                if (role == "Игрок") {
                                                    navController.navigate(Screen.PlayerMenu.route)
                                                } else if (role == "Тренер") {
                                                    navController.navigate(Screen.CoachMenu.route)
                                                }
                                            }
                                            .addOnFailureListener { e ->
                                                message = "Ошибка сохранения данных пользователя: ${e.message}"
                                            }
                                    }
                                    message = "Регистрация прошла успешно"
                                } else {
                                    message = "Ошибка регистрации: ${task.exception?.message}"
                                }
                            }
                    } else {
                        message = "Все поля должны быть заполнены"
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Завершить регистрацию")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = message, style = MaterialTheme.typography.bodyLarge)
    }
}
