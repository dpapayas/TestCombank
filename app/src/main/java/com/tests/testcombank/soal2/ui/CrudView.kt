package com.tests.testcombank.soal2.ui

import androidx.annotation.StringRes
import com.tests.testcombank.soal2.core.BaseView
import com.tests.testcombank.soal2.model.User
import com.tests.testcombank.soal2.model.UserList
import com.tests.testcombank.soal2.model.UserResponse

interface CrudView : BaseView {
    fun createUsers(userResponse: UserResponse)
    fun getUsers(userList: UserList)
    fun getUser(userResponse: UserResponse)
    fun updateUsers(userResponse: UserResponse)
    fun deleteUsers(userResponse: UserResponse)
    fun showSuccess(success: String)
    fun showError(error: String)
    fun showError(@StringRes errorResId: Int){
        this.showError(getContext().getString(errorResId))
    }
    fun showLoading()
    fun hideLoading()
}