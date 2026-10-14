package com.webapp.together.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomTab(
    val title: String,
    val icon: ImageVector
) {
    MATCH("매칭", Icons.Default.Favorite),
    MY_PAGE("마이페이지", Icons.Default.Person)
}