package com.example.mootrakiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mootrakiapp.ui.theme.MootrakiAppTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MootrakiAppTheme {
                val navigationController = rememberNavController()
                Scaffold(bottomBar = {NavigationBar(navigationController)}) { innerPadding ->
                    NavHost(
                        navController = navigationController,
                        startDestination = Screen.Home.route,
                        Modifier.padding(innerPadding)
                    ) { //the pages displayed in the navigation bar
                        composable(Screen.Home.route) { Home() }
                        composable(Screen.Calendar.route) { Calendar() }
                        composable(Screen.Charts.route) { Charts() }
                        composable(Screen.Affirmations.route) { Affirmations() }
                    }
                }
            }
        }
    }
}


@Composable
fun NavigationBar(navigationController: NavController){
    val features = listOf(
        Screen.Home,
        Screen.Calendar,
        Screen.Charts,
        Screen.Affirmations
    )

    BottomNavigation (backgroundColor = colorResource(id = R.color.green)){
        features.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    when (screen) {
                        is Screen.Home -> Icon(painterResource(id = R.drawable.ic_home), contentDescription = "Home")
                        is Screen.Calendar -> Icon(painterResource(id = R.drawable.ic_calendar), contentDescription = "Calendar")
                        is Screen.Charts -> Icon(painterResource(id = R.drawable.ic_charts), contentDescription = "Charts")
                        is Screen.Affirmations -> Icon(painterResource(id = R.drawable.ic_affirmations), contentDescription = "Affirmations")
                    }
                },
                label = {Text(screen.route.capitalize())},
                selected = false, // You will need to manage the selected state
                // Change the selected state to true to manage it better
                onClick = {
                    navigationController.navigate(screen.route) {
                        // Clear the back stack to prevent navigating back to previous screens
                        popUpTo(Screen.Home.route){saveState = true}
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                selectedContentColor = colorResource(id = R.color.white), // Use selected color
                unselectedContentColor = colorResource(id = R.color.white) // Use unselected color
            )
        }
    }
}







