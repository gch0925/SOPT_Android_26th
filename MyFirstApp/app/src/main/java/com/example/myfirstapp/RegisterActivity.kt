package com.example.myfirstapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val et_email = findViewById<EditText>(R.id.et_email)
        val et_pw = findViewById<EditText>(R.id.et_pw)
        val et_pwCheck = findViewById<EditText>(R.id.et_pw2)
        val btn_register = findViewById<Button>(R.id.btn_register)
        
        btn_register.setOnClickListener {
            if(et_email.text.isNullOrBlank()||et_pw.text.isNullOrBlank()||et_pwCheck.text.isNullOrBlank()){
                Toast.makeText(this,"아이디와 비밀번호를 확인하세요",Toast.LENGTH_SHORT).show()
            }

            if (et_pw.text.toString().equals(et_pwCheck.text.toString())){
                val intent = Intent()
                intent.putExtra("email",et_email.text.toString())
                intent.putExtra("pw",et_pw.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else{
                Toast.makeText(this,"비밀번호를 확인해주세요",Toast.LENGTH_SHORT).show()
            }

        }

    }



}
