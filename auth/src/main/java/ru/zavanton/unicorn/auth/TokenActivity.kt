package ru.zavanton.unicorn.auth

import android.content.Intent
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class TokenActivity : AppCompatActivity() {

    private val CLIENT_ID = "yrTRBe2U2sH4nw"

    private val REDIRECT_URI = "http://unicorn.zavanton.tmweb.ru/about/"

    private val STATE = "MY_RANDOM_STRING_3"

    private val ACCESS_TOKEN_URL = "https://www.reddit.com/api/v1/access_token"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_token)
    }

    override fun onResume() {
        super.onResume()
        Log.d("zavanton", "zavanton - TokenActivity onResume")

        if (intent != null && intent.action == Intent.ACTION_VIEW) {
            val uri = intent.data
            if (uri!!.getQueryParameter("error") != null) {
                val error = uri.getQueryParameter("error")
                Log.e("zavanton", "zavanton - An error has occurred : " + error!!)
            } else {
                val state = uri.getQueryParameter("state")
                if (state == STATE) {
                    val code = uri.getQueryParameter("code")
                    getAccessToken(code)
                }
            }
        }
    }

    private fun getAccessToken(code: String?) {

        val client = OkHttpClient()

        val authString = "$CLIENT_ID:"
        val encodedAuthString = Base64.encodeToString(
            authString.toByteArray(),
            Base64.NO_WRAP
        )

        val request = Request.Builder()
            .addHeader("User-Agent", "Sample App")
            .addHeader("Authorization", "Basic $encodedAuthString")
            .url(ACCESS_TOKEN_URL)
            .post(
                RequestBody.create(
                    MediaType.parse("application/x-www-form-urlencoded"),
                    "grant_type=authorization_code&code=" + code +
                            "&redirect_uri=" + REDIRECT_URI
                )
            )
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("zavanton", "zavanton - ERROR: $e")

            }

            override fun onResponse(call: Call, response: Response) {
                val json = response.body()?.string()

                var data: JSONObject? = null
                try {
                    data = JSONObject(json!!)
                    val accessToken = data.optString("access_token")
                    val refreshToken = data.optString("refresh_token")

                    Log.d("zavanton", "Access Token = $accessToken")
                    Log.d("zavanton", "Refresh Token = $refreshToken")
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
        })
    }
}
