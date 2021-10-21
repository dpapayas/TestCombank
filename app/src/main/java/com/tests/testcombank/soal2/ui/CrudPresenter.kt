package com.tests.testcombank.soal2.ui

import com.tests.testcombank.R
import com.tests.testcombank.soal2.api.APIs
import com.tests.testcombank.soal2.core.BasePresenter
import com.tests.testcombank.soal2.model.User
import com.tests.testcombank.soal2.model.UserRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CrudPresenter(crudView: CrudView) : BasePresenter<CrudView>(crudView) {
    @Inject
    lateinit var apis: APIs

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadUsers()
    }

    /**
     * Loads the posts from the API and presents them in the view when retrieved, or shows error if
     * any.
     */
    fun loadUsers() {
        view.showLoading()
        subscription = apis
            .getUsersList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { userList -> view.getUsers(userList) },
                { view.showError(R.string.unknown_error) }
            )
    }

    fun getUser(id: String) {
        view.showLoading()
        subscription = apis
            .getUser(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { userList -> view.getUser(userList) },
                { view.showError(R.string.unknown_error) }
            )
    }

    fun createUsers(user: User) {
        view.showLoading()
        subscription = apis
            .createUser(user)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { userList -> view.createUsers(userList) },
                { view.showError(R.string.unknown_error) }
            )
    }

    fun updateUsers(id:String, user: User) {
        view.showLoading()
        subscription = apis
            .updateUser(id, user)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { userList -> view.updateUsers(userList) },
                { view.showError(R.string.unknown_error) }
            )
    }

    fun deleteUsers(id:String) {
        view.showLoading()
        subscription = apis
            .deleteUser(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe(
                { userList -> view.showSuccess("Success Delete") },
                { view.showError(R.string.unknown_error) }
            )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}