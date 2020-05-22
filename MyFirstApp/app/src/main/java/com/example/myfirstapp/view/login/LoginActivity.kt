package com.example.myfirstapp.view.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myfirstapp.R
import com.example.myfirstapp.data.RetrofitRequest
import com.example.myfirstapp.data.RequestLogin
import com.example.myfirstapp.view.main.MainActivity
import com.example.myfirstapp.view.register.RegisterActivity
import com.example.myfirstapp.util.customEnqueue
import com.example.myfirstapp.util.showToast
import com.example.myfirstapp.util.textChangedListener
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.et_pw
import kotlinx.android.synthetic.main.activity_login.tv_register

class LoginActivity : AppCompatActivity() {

    val retrofitRequest = RetrofitRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent, 100)
        }

        btn_login.setOnClickListener {

            et_id.textChangedListener {
                if (it.isNullOrBlank()){
                    showToast("아이디를 확인하세요")
                }
            }
            et_pw.textChangedListener {
                if (it.isNullOrBlank()){
                    showToast("비밀번호를 확인하세요")
                }
            }

//       todo 로그인 구현 성공하면 Main 아니면 Toast Fail
            if (et_id.text.isNullOrBlank()|| et_pw.text.isNullOrBlank()){
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요 ", Toast.LENGTH_SHORT).show()
            } else {
                //           request Retrofitt
                RetrofitRequest.service.requestLogin(
                    RequestLogin(
                        id = et_id.text.toString(),
                        password = et_pw.text.toString()
                    )
                ).customEnqueue(
                    onError = {showToast("올바르지 못한 요청")},
                    onSuccess = { responseBody, response ->
                        if(responseBody.success){
                            Toast.makeText(this@LoginActivity, "로그인 성공 ", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }  else {
                            when (response.message()){
                                "OK" ->Toast.makeText(this@LoginActivity,"에러 발생",Toast.LENGTH_SHORT).show()
                                "비밀번호가 일치하지 않습니다" ->  Toast.makeText(this@LoginActivity,"비밀번호가 일치하지 않습니다",Toast.LENGTH_SHORT).show()
                                "존재하지 않는 유저 입니다." -> Toast.makeText(this@LoginActivity,"존재하지 않는 유저 입니다",Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                )


//                enqueue(object : Callback<ResponseLogin>{
//                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
//                    }
//                    override fun onResponse(
//                        call: Call<ResponseLogin>,
//                        response: Response<ResponseLogin>
//                    ) {
//                        if (response.isSuccessful){
//                            if(response.body()!!.success){
//                                Toast.makeText(this@LoginActivity, "로그인 성공 ", Toast.LENGTH_SHORT).show()
//                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
//                                startActivity(intent)
//                                finish()
//                            }  else {
//                                when (response.message()){
//                                    "OK" ->Toast.makeText(this@LoginActivity,"에러 발생",Toast.LENGTH_SHORT).show()
//                                    "비밀번호가 일치하지 않습니다" ->  Toast.makeText(this@LoginActivity,"비밀번호가 일치하지 않습니다",Toast.LENGTH_SHORT).show()
//                                    "존재하지 않는 유저 입니다." -> Toast.makeText(this@LoginActivity,"존재하지 않는 유저 입니다",Toast.LENGTH_SHORT).show()
//                                }
//                            }
//                        }
//                    }
//                })
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
//            data?.let {
//                et_email.setText(it.getStringExtra("email"))
//                et_pw.setText(it.getStringExtra("pw"))}
//
            et_id.setText(data?.getStringExtra("id"))
            et_pw.setText(data?.getStringExtra("pw"))
        }
    }

}
