package com.example.myfirstapp.register

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.R
import com.example.myfirstapp.data.RequestRegister
import com.example.myfirstapp.data.ResponseRegister
import com.example.myfirstapp.data.RetrofitRequest
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterActivity : AppCompatActivity() {

    val retrofitRequest = RetrofitRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            if(et_id.text.isNullOrBlank()||et_pw.text.isNullOrBlank()||et_pwCheck.text.isNullOrBlank()){
                Toast.makeText(this,"아이디와 비밀번호를 확인하세요",Toast.LENGTH_SHORT).show()
            } else if (et_name.text.isNullOrBlank()){
                Toast.makeText(this,"이름을 확인하세요",Toast.LENGTH_SHORT).show()
            }  else if (et_email.text.isNullOrBlank()){
                Toast.makeText(this,"이메일을 확인하세요",Toast.LENGTH_SHORT).show()
            } else if(et_phone.text.isNullOrBlank()){
                Toast.makeText(this,"핸드폰 번호를 확인하세요",Toast.LENGTH_SHORT).show()
            } else if (et_pw.text.toString() == et_pwCheck.text.toString()){

                RetrofitRequest.service.requestRegister(
                    RequestRegister(
                        id = et_id.text.toString(),
                        password = et_pw.text.toString(),
                        name = et_name.text.toString(),
                        email = et_email.text.toString(),
                        phone = et_phone.text.toString()
                    )
                ).enqueue(object : Callback<ResponseRegister>{
                    override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                    }

                    override fun onResponse(
                        call: Call<ResponseRegister>,
                        response: Response<ResponseRegister>
                    ) {
                        if(response.isSuccessful){
                            if(response.body()!!.success){
                                Toast.makeText(this@RegisterActivity,"회원가입 성공",Toast.LENGTH_SHORT).show()
                                val intent = Intent()
                                intent.putExtra("id",et_id.text.toString())
                                intent.putExtra("pw",et_pw.text.toString())
                                setResult(Activity.RESULT_OK, intent)
                                finish()
                            } else {
                                when (response.message()){
                                    "OK" ->Toast.makeText(this@RegisterActivity,"에러 발생",Toast.LENGTH_SHORT).show()
                                    "존재하는 ID 입니다." ->  Toast.makeText(this@RegisterActivity,"존재하는 ID 입니다.",Toast.LENGTH_SHORT).show()
                                    "존재하지 않는 유저 입니다." -> Toast.makeText(this@RegisterActivity,"존재하지 않는 유저 입니다",Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    }
                })
            }
        }

    }



}
