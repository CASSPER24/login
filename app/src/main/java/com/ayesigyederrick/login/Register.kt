package com.ayesigyederrick.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        analytics = Firebase.analytics

        val btn = findViewById<Button>(R.id.btn_skip)
        btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            //finish()
        }

        val texttologin = findViewById<TextView>(R.id.text_login)
        texttologin.setOnClickListener {
            val intent_2 = Intent(this, Login::class.java)
            startActivity(intent_2)
            //finish()
        }
    }

    fun GotoMain(view:View) {
        val email = findViewById<EditText>(R.id.email_register).text.toString()
        val password = findViewById<EditText>(R.id.password_register).text.toString()
        Firebase.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                    //finish()
                }
            }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()

        }
    }

}