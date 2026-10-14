package com.webapp.together.navigation

import androidx.compose.runtime.Composable

sealed class Route(val route: String) {
    object Intro: Route("intro")
    object Main: Route("main")
    object UserList: Route("user_list")
    object UserAdd: Route("user_add")
}