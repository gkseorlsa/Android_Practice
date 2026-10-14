package com.webapp.together.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.webapp.together.common.PhonePreview
import com.webapp.together.ui.components.VerticalSpacer
import com.webapp.together.ui.pages.CardView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchScreen(initialIsApply: Boolean = false) {

    var isApply by remember { mutableStateOf(initialIsApply) }
    val verticalScrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(
                    if (isApply) "이번 주 소개팅 상대"
                    else "소개팅 신청하기")
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(verticalScrollState)
        ) {
            CardView(isApply = isApply)
            VerticalSpacer()
            if (!isApply) {
                Button(
                    onClick = { isApply = true },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("소개팅 신청하기")
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "매칭 상대 정보",
                        fontWeight = FontWeight.Bold
                    )

                    Text("닉네임: 카리나")
                    Text("나이: 25")
                    Text("직업: 연예인")
                    Text("MBTI: INTP")
                    Text("취미: 노래 부르기")
                }
            }
        }
    }
}

@PhonePreview
@Composable
fun MatchScreenPreview() {
    MatchScreen()
}