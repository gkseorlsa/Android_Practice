package com.webapp.together.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.webapp.together.common.PhonePreview
import com.webapp.together.data.Gender
import com.webapp.together.data.User
import com.webapp.together.ui.components.VerticalSpacer
import com.webapp.together.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserAddScreen(
    navController: NavController,
    userViewModel: UserViewModel = viewModel()
) {
    var nick by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf<Gender>(Gender.M) }
    var mbti by remember { mutableStateOf("") }
    var job by remember { mutableStateOf("") }
    var hobby by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("유저 추가") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "뒤로 가기"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            OutlinedTextField(
                value = nick,
                onValueChange = { nick = it },
                label = { Text("이름") },
                modifier = Modifier.fillMaxWidth()
            )
            VerticalSpacer(8)
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("나이") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            VerticalSpacer(8)

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("성별")
                Gender.entries.forEach { gender ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedGender == gender,
                            onClick = { selectedGender = gender }
                        )
                        Text(gender.title)
                    }
                }
            }
            VerticalSpacer(8)
            OutlinedTextField(
                value = mbti,
                onValueChange = { mbti = it },
                label = { Text("MBTI") },
                modifier = Modifier.fillMaxWidth()
            )
            VerticalSpacer(8)
            OutlinedTextField(
                value = job,
                onValueChange = { job = it },
                label = { Text("직업") },
                modifier = Modifier.fillMaxWidth()
            )
            VerticalSpacer(8)
            OutlinedTextField(
                value = hobby,
                onValueChange = { hobby = it },
                label = { Text("취미") },
                modifier = Modifier.fillMaxWidth()
            )
            VerticalSpacer(8)

            Button(
                onClick = {
                    val user = User(
                        nick = nick,
                        age = age.toInt(),
                        gender = selectedGender,
                        mbti = mbti,
                        job = job,
                        hobby = hobby
                    )

                    userViewModel.addUser(user)
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = nick.isNotBlank()
                        && age.isNotBlank()
            ) {
                Text("저장")
            }
        }
    }
}


@PhonePreview
@Composable
fun UserAddScreenPreview() {
    val navController = rememberNavController()
    UserAddScreen(navController = navController)
}