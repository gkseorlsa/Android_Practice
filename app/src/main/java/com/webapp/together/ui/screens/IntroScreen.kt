package com.webapp.together.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.webapp.together.common.PhonePreview
import com.webapp.together.ui.components.VerticalSpacer
import com.webapp.together.ui.theme.TogetherTheme

@Composable
fun IntroScreen(onApplyClick: () -> Unit = {}) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = """
                        Together 소개팅은
                        소개팅 문화의 발전을 위해
                        일주일에 한 번 소개팅 상대를 추천합니다.
                        소개팅을 신청하면 꼭 만남이 성사되어야 하며,
                        이를 어길 시 더 이상 서비스를 이용할 수 없습니다.
                    """.trimIndent(),
                    textAlign = TextAlign.Center
                )
                VerticalSpacer()
                Button(onClick = onApplyClick) {
                    Text("소개팅을 신청합니다.")
                }
            }
        }
    }
}



@PhonePreview
@Composable
fun IntroScreenPreview() {
    TogetherTheme{
        IntroScreen()
    }
}