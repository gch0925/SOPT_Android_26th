package com.example.myfirstapp.util

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun<T> Call<T>.customEnqueue(
    onFail : () -> Unit = {"Failed"},
    onSuccess : (T, Response<T>) -> Unit,
    onError : () -> Unit
){
    this.enqueue(object : Callback<T>{
        override fun onFailure(call: Call<T>, t: Throwable) {
            onFail()
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            response.body()?.let { onSuccess(response.body()!!, response)} ?: onError
        }
    })

}