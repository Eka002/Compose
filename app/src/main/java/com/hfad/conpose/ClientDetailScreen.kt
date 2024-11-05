package com.hfad.conpose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@ExperimentalMaterial3Api
@Composable
fun ClientDetailScreen(client: Client, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Детали клиента") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(16.dp)
            .padding(paddingValues)) {
            Text("Имя: ${client.name}", fontSize = 24.sp)
            Text("Дата рождения: ${client.birthDate}", fontSize = 20.sp)
        }
    }
}
