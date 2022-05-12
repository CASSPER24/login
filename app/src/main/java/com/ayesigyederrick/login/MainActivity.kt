package com.ayesigyederrick.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    private val webView: WebView ? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "FLIGHTS"
        val webView = findViewById<WebView>(R.id.webview)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.makemytrip.com/flights")
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
    }

    override fun onBackPressed() {
        if(webView?.canGoBack() == true) {
            webView?.goBack()
        }
        super.onBackPressed()
        }

    }
