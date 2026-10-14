package com.webapp.together

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.webapp.together.navigation.Route
import com.webapp.together.ui.screens.IntroScreen
import com.webapp.together.ui.screens.MainScreen
import com.webapp.together.ui.screens.MatchScreen
import com.webapp.together.ui.screens.UserAddScreen
import com.webapp.together.ui.screens.UserListScreen
import com.webapp.together.ui.theme.TogetherTheme
import com.webapp.together.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TogetherTheme {
                val navController = rememberNavController()
                val userViewModel = remember { UserViewModel() }

                NavHost(
                    navController = navController,
                    startDestination = Route.Intro.route
                ) {
                    composable(Route.Intro.route) {
                        IntroScreen(
                            onApplyClick = {
                                navController.navigate(Route.Main.route) {
                                    popUpTo(Route.Intro.route) {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }

                    composable(Route.Main.route) {
                        MainScreen(navController, userViewModel)
                    }

                    composable(Route.UserList.route) {
                        UserListScreen(navController, userViewModel)
                    }

                    composable(Route.UserAdd.route) {
                        UserAddScreen(navController, userViewModel)
                    }
                }
            }
        }
    }
}