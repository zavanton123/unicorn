package ru.zavanton.unicorn

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val AUTH_URL = "https://www.reddit.com/api/v1/authorize.compact?client_id=%s" +
            "&response_type=code&state=%s&redirect_uri=%s&" +
            "duration=permanent&scope=*"

    private val CLIENT_ID = "yrTRBe2U2sH4nw"

    private val REDIRECT_URI = "http://unicorn.zavanton.tmweb.ru/about/"

    private val STATE = "MY_RANDOM_STRING_3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            startSignIn()
        }
    }

    private fun startSignIn() {
        val url = String.format(AUTH_URL, CLIENT_ID, STATE, REDIRECT_URI)
        Log.d("zavanton", "zavanton - url: $url")

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()

        Log.d("zavanton", "zavanton - MainActivity onResume")
    }


}
