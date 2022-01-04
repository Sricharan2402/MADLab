package com.example.p10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webview = (WebView)findViewById(R.id.webview);
        Button search = findViewById(R.id.search);
        EditText url = findViewById(R.id.url);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.setWebViewClient(new WebViewClient());
                webview.getSettings().setJavaScriptEnabled(true);
                webview.loadUrl(url.getText().toString());
            }
        });
    }
}