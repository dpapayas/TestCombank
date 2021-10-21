package com.tests.testcombank.soal2.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tests.testcombank.R
import com.tests.testcombank.soal2.core.BaseActivity
import com.tests.testcombank.soal2.model.User
import com.tests.testcombank.soal2.model.UserList
import com.tests.testcombank.soal2.model.UserResponse
import com.tests.testcombank.soal2.ui.adpaters.RecyclerViewAdapter

/**
 * Activity displaying the list of posts
 */
class CrudActivity : BaseActivity<CrudPresenter>(), CrudView, RecyclerViewAdapter.AdapterCallback {

    private lateinit var rvList: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var btnCreate: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvList = findViewById(R.id.rvList)
        btnCreate = findViewById(R.id.create_user_button)
        progressBar = findViewById(R.id.progressBar)

        recyclerViewAdapter = RecyclerViewAdapter(this@CrudActivity)

        rvList.layoutManager =
            ScrollingLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false, 5000)

        rvList.adapter = recyclerViewAdapter

        presenter.onViewCreated()

        btnCreate.setOnClickListener {
            val intent = Intent(this@CrudActivity, CreateNewUserActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun createUsers(userResponse: UserResponse) {
        TODO("Not yet implemented")
    }

    override fun getUsers(userList: UserList) {
        recyclerViewAdapter.updateList(userList.data)
    }

    override fun getUser(userResponse: UserResponse) {
        TODO("Not yet implemented")
    }

    override fun updateUsers(userResponse: UserResponse) {
        TODO("Not yet implemented")
    }

    override fun deleteUsers(userResponse: UserResponse) {
        Toast.makeText(this, "Success Deleted User", Toast.LENGTH_LONG).show()
        presenter.loadUsers()
    }

    override fun showSuccess(success: String) {
        Toast.makeText(this, "Success Deleted User", Toast.LENGTH_LONG).show()
        presenter.loadUsers()
    }


    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun instantiatePresenter(): CrudPresenter {
        return CrudPresenter(this)
    }

    override fun onItemEditClick(user: User) {
        val intent = Intent(this@CrudActivity, CreateNewUserActivity::class.java)
        intent.putExtra("user_id", user.id)
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 100) {
            presenter.loadUsers()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDeletes(id: String) {
        presenter.deleteUsers(id)
    }
}