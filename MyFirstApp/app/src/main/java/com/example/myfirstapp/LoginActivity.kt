package com.example.myfirstapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent, 100)
        }
        btn_login.setOnClickListener {
//           request Retrofit
//           todo 로그인 구현 성공하면 Main 아니면 Toast Fail
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
//            data?.let {
//                et_email.setText(it.getStringExtra("email"))
//                et_pw.setText(it.getStringExtra("pw"))}
//
            et_email.setText(data?.getStringExtra("email"))
            et_pw.setText(data?.getStringExtra("pw"))
        }
    }

}
