package com.example.quiz_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnstart : Button = findViewById(R.id.btn_start)
        val etName : EditText = findViewById(R.id.et_name)
        btnstart.setOnClickListener{

            if(etName.text.isEmpty()){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show()
            }else{
                val  intent = Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME,etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}