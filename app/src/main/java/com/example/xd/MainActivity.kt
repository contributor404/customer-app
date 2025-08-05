package com.example.xd

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var usernameView: EditText
    private lateinit var passwordView: EditText
    private lateinit var buttoniew: Button
    private lateinit var dbClass: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttoniew = findViewById<Button>(R.id.btn_login)
        usernameView = findViewById(R.id.username)
        passwordView = findViewById(R.id.password)

        dbClass = DatabaseHelper(this)

        buttoniew.setOnClickListener {

            val username = usernameView.text.toString()
            val password = passwordView.text.toString()

            if (dbClass.checkUser(username, password)) {
                Toast.makeText(this, "Login Sukses", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Username / Password Salah", Toast.LENGTH_SHORT).show()
            }
        }

    }
}