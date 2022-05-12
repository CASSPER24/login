package com.ayesigyederrick.login

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar

class SPLASHSCREEN : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)


        Handler().postDelayed({
            val i = Intent(this, Register::class.java)
            startActivity(i)
            finish()
        },3000)
    }
}