package com.tests.testcombank.soal2.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.tests.testcombank.R
import com.tests.testcombank.soal2.core.BaseActivity
import com.tests.testcombank.soal2.model.User
import com.tests.testcombank.soal2.model.UserList
import com.tests.testcombank.soal2.model.UserRequest
import com.tests.testcombank.soal2.model.UserResponse

class CreateNewUserActivity : BaseActivity<CrudPresenter>(), CrudView {

    private lateinit var etName: TextView
    private lateinit var etEmail: TextView
    private lateinit var etGender: TextView
    private lateinit var btnSubmit: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_user)

        val user_id = intent.getStringExtra("user_id")

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etGender = findViewById(R.id.etGender)
        btnSubmit = findViewById(R.id.create_button)
        progressBar = findViewById(R.id.progressBar)

        if (user_id != null){
            presenter.getUser(user_id)
            btnSubmit.text = "Update"
        } else {
            progressBar.visibility = View.GONE
        }

        btnSubmit.setOnClickListener {
            createUser(user_id)
        }
    }

    private fun createUser(user_id: String?) {
        val user = User(
            "",
            etName.text.toString(),
            etEmail.text.toString(),
            "Active",
            etGender.text.toString()
        )
        if (user_id.isNullOrEmpty()) {
            presenter.createUsers(user)
        }
        else {
            presenter.updateUsers(user_id, user)
        }
    }

    override fun instantiatePresenter(): CrudPresenter {
        return CrudPresenter(this)
    }

    override fun createUsers(userResponse: UserResponse) {
        Toast.makeText(
            this@CreateNewUserActivity,
            "Successfully created new user",
            Toast.LENGTH_LONG
        ).show()
        finish()
    }

    override fun getUsers(userList: UserList) {
        TODO("Not yet implemented")
    }

    override fun getUser(userResponse: UserResponse) {
        etName.text = userResponse.data?.name
        etEmail.text = userResponse.data?.email
        etGender.text = userResponse.data?.gender
    }

    override fun updateUsers(userResponse: UserResponse) {
        Toast.makeText(
            this@CreateNewUserActivity,
            "Successfully updated new user",
            Toast.LENGTH_LONG
        ).show()
        finish()
    }

    override fun deleteUsers(userResponse: UserResponse) {
        TODO("Not yet implemented")
    }

    override fun showSuccess(success: String) {
        TODO("Not yet implemented")
    }

    override fun showError(error: String) {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }
}