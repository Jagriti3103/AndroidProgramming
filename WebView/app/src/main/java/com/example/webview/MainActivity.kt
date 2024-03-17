package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webview = findViewById<WebView>(R.id.WebView)
        webViewSetup(webview)
    }
    private fun webViewSetup(web:WebView){
        web.webViewClient = WebViewClient()

        web.apply{
            settings.javaScriptEnabled= true
            settings.safeBrowsingEnabled = true
            loadUrl("https://www.taxspexdevising.com/")
        }


    }
}