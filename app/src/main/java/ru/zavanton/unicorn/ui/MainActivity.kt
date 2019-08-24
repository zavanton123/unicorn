package ru.zavanton.unicorn.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import ru.zavanton.unicorn.R
import ru.zavanton.unicorn.di.ComponentManager
import ru.zavanton.unicorn.posts.ui.activity.PostsActivity
import ru.zavanton.unicorn.core.Log
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private val AUTH_URL = "https://www.reddit.com/api/v1/authorize.compact?client_id=%s" +
            "&response_type=code&state=%s&redirect_uri=%s&" +
            "duration=permanent&scope=*"

    private val CLIENT_ID = "yrTRBe2U2sH4nw"

    private val REDIRECT_URI = "http://unicorn.zavanton.tmweb.ru/about/"

    private val STATE = "MY_RANDOM_STRING_3"

    @Inject
    lateinit var okHttpClient: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentManager.getAppComponent().inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("okHttpClient: $okHttpClient")

        btnLogin.setOnClickListener {
            // startSignIn()
            goToPosts()
        }
    }

    private fun goToPosts() {
        Intent(this, PostsActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun startSignIn() {
        val url = String.format(AUTH_URL, CLIENT_ID, STATE, REDIRECT_URI)
        Log.d("zavanton - url: $url")

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

}
