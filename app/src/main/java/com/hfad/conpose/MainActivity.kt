package com.hfad.conpose

import ClientListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    MyApp()
                }
            }
        }
    }

    @Preview
    @Composable
    fun MyApp() {
        val navController = rememberNavController()
        val sampleClients = remember {
            listOf(
                Client("Иванов Иван Иванович", "01.01.1990"),
                Client("Петров Петр Петрович", "02.02.1992"),
                Client("Сидоров Сидор Сидорович", "03.03.1993"),
                Client("Смирнов Смирон Смирнович", "30.12.1996"),
                Client("Кузнецов Кузьма Кузьмич", "01.06.1980"),
                Client("Попов Паша Павлович", "14.05.2000"),
                Client("Васильев Василий Васильевич", "20.04.2001"),
                Client("Николаев Николай Николаевич", "24.10.2017"),
                Client("Морозов Морис Морозович", "03.03.2002"),
                Client("Федоров Федор Федорович", "16.04.1993"),
                Client("Соловьев Соломон Соловьевич", "07.09.1996"),
                Client("Алексеев Алексей Алексеевич", "03.12.1985"),
                Client("Яковлев Яков Яковлевич", "31.12.1990"),
                Client("Павлов Павел Павлович", "19.08.1998"),
                Client("Егоров Егор Егорович", "29.11.2004"),
                Client("Трофимов Трофим Трофимович", "15.10.1989"),
                Client("Захаров Захар Захарович", "02.12.1960"),
                Client("Ковалев Котов Ковалевич", "22.08.1999")
            )
        }

        NavHost(navController, startDestination = "client_list") {
            composable("client_list") {
                ClientListScreen(
                    clients = sampleClients,
                    onClientClick = { client ->
                        navController.navigate("client_detail/${client.name}/${client.birthDate}")
                    }
                )
            }
            composable(
                "client_detail/{name}/{birthDate}",
                arguments = listOf(navArgument("name") { type = NavType.StringType },
                    navArgument("birthDate") { type = NavType.StringType })
            ) { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name") ?: ""
                val birthDate = backStackEntry.arguments?.getString("birthDate") ?: ""
                ClientDetailScreen(Client(name, birthDate), navController)
            }
        }
    }
}