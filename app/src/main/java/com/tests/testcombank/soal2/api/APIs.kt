package com.tests.testcombank.soal2.api

import com.tests.testcombank.soal2.Constants
import com.tests.testcombank.soal2.model.User
import com.tests.testcombank.soal2.model.UserList
import com.tests.testcombank.soal2.model.UserRequest
import com.tests.testcombank.soal2.model.UserResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface APIs {

    /* https://gorest.co.in/public/v1/users */
    @GET("users")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json"
    )
    fun getUsersList(): Observable<UserList>


    /* https://gorest.co.in/public/v1/users/user_id */
    @GET("users/{user_id}")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json"
    )
    fun getUser(@Path("user_id") user_id: String): Observable<UserResponse>

    /* https://gorest.co.in/public/v1/users?name=a */
    @POST("users")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json",
        "Authorization: Bearer ${Constants.ACCESS_TOKEN}"
    )
    fun createUser(@Body params: User): Observable<UserResponse>


    @PATCH("users/{user_id}")
    @Headers(
        "Accept: application/json",
        "Content-Type:application/json",
        "Authorization: Bearer ${Constants.ACCESS_TOKEN}"
    )
    fun updateUser(
        @Path("user_id")
        user_id: String,
        @Body params: User
    ): Observable<UserResponse>


    @DELETE("users/{user_id}")
    @Headers(
        "Accept:application/json",
        "Content_Type:application/json",
        "Authorization: Bearer ${Constants.ACCESS_TOKEN}"
    )
    fun deleteUser(@Path("user_id") user_id: String): Observable<Response<Void>>
}