package com.example.splash_screen

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi


class Instagram : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_instagram)
        val webViewVariable= findViewById<WebView>(R.id.webView)
        webViewSetUp(webViewVariable)

        }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetUp(a: WebView){

        a.webViewClient= WebViewClient()

        a.apply {
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
            loadUrl("https://www.instagram.com/accounts/login/?hl=en")
        }
    }
}