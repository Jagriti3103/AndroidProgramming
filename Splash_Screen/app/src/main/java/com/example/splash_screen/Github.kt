package com.example.splash_screen

import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Github : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_github)

        val webViewVariable= findViewById<WebView>(R.id.webView)
        webViewSetUp(webViewVariable)
        }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetUp(a: WebView){

        a.webViewClient= WebViewClient()

        a.apply {
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
            loadUrl("https://github.com/Jagriti3103")
        }
    }
}