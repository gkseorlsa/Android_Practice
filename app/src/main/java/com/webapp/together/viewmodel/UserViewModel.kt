package com.webapp.together.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.webapp.together.data.User
import kotlinx.coroutines.launch

class UserViewModel(private val userDao: UserDao): ViewModel() {

    var currentUser by mutableStateOf<User?>(null)
        private set

    private val _userList = mutableStateListOf<User>()
    val userList: List<User> = _userList

    init {
        viewModelScope.launch {
            _userList.addAll(userDao.getAll())
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            userDao.insert(user)
            _userList.clear()
            _userList.addAll(userDao.getAll())
        }
        _userList.add(user)
    }

    fun selectUser(user: User) {
        currentUser = user
    }
}