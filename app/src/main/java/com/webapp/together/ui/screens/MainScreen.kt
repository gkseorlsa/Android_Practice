package com.webapp.together.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.webapp.together.common.PhonePreview
import com.webapp.together.navigation.BottomTab
import com.webapp.together.viewmodel.UserViewModel

@Composable
fun MainScreen(
    navController: NavController,
    userViewModel: UserViewModel = viewModel()
) {
    var currentTab by remember { mutableStateOf(BottomTab.MATCH) }
    val tabs = listOf(BottomTab.MATCH, BottomTab.MY_PAGE)

    Scaffold(
        bottomBar = {
            NavigationBar {
                tabs.forEach { tab ->
                    NavigationBarItem(
                        selected = currentTab == tab,
                        onClick = { currentTab = tab },
                        icon = { Icon(tab.icon, tab.title) },
                        label = { Text(tab.title) }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            when (currentTab) {
                BottomTab.MATCH -> MatchScreen()
                BottomTab.MY_PAGE -> MyPageScreen(userViewModel = userViewModel)
            }
        }
    }

}


@PhonePreview
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(navController = navController)
}