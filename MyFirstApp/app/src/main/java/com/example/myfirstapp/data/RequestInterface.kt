package com.example.myfirstapp.data

import com.example.myfirstapp.data.RequestLogin
import com.example.myfirstapp.data.RequestRegister
import com.example.myfirstapp.data.ResponseLogin
import com.example.myfirstapp.data.ResponseRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface {
    @POST("/user/signin")
    fun requestLogin(@Body body: RequestLogin) : Call<ResponseLogin>

    @POST("/user/signup")
    fun requestRegister(@Body body: RequestRegister) : Call<ResponseRegister>

}