package com.multiplerecyclerview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.multiplerecyclerview.R

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val webView = findViewById<WebView>(R.id.webView)
        val getWebUrl = intent.getStringExtra("web").toString()

        webView.webViewClient = WebViewClient()

        webView.loadUrl(getWebUrl)
    }
    }
