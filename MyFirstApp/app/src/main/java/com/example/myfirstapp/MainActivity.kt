package com.example.myfirstapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {

    private lateinit var  et_email : EditText
    private lateinit var  et_pw : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_email = findViewById(R.id.et_email)
        et_pw = findViewById(R.id.et_pw)
        val tv_register = findViewById<TextView>(R.id.tv_register)

        tv_register.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            startActivityForResult(intent, 100)
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