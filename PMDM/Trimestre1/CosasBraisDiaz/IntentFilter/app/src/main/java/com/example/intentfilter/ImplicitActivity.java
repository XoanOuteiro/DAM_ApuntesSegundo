package com.example.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ImplicitActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        webView = findViewById(R.id.webViewImpl);

        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);              //Habilita JavaScript para las páginas que lo necesiten

        Intent intent = getIntent();
        Uri url = intent.getData();
        webView.loadUrl(url.toString());

    }
}