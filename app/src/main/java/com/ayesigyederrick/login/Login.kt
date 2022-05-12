package com.ayesigyederrick.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        title = "LogIn"

        val texttoregister = findViewById<TextView>(R.id.text_register)
        texttoregister.setOnClickListener {
            val intent_4 = Intent(this, Register::class.java)
            startActivity(intent_4)
            //finish()
        }
    }

    fun GotoMain_2(view: View) {
        val email = findViewById<EditText>(R.id.email_login).text.toString()
        val password = findViewById<EditText>(R.id.password_login).text.toString()
        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                    finish()
                }
            }.addOnFailureListener { exception ->
                Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG)
                    .show()
            }
    }
}