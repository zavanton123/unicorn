package ru.zavanton.unicorn.auth.ui

import android.content.Intent
import android.os.Bundle
import android.util.Base64
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
import ru.zavanton.unicorn.auth.R
import ru.zavanton.unicorn.auth.di.ComponentManager
import ru.zavanton.unicorn.auth.utils.AuthConstants.ACCESS_TOKEN_URL
import ru.zavanton.unicorn.auth.utils.AuthConstants.CLIENT_ID
import ru.zavanton.unicorn.auth.utils.AuthConstants.REDIRECT_URI
import ru.zavanton.unicorn.auth.utils.AuthConstants.STATE
import ru.zavanton.unicorn.core.Log
import java.io.IOException
import javax.inject.Inject

class TokenActivity : AppCompatActivity() {

    @Inject
    lateinit var okHttpClient: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentManager.getAuthComponent().inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_token)

        Log.d("okHttpClient: $okHttpClient")
    }

    override fun onResume() {
        super.onResume()
        Log.d("zavanton - TokenActivity onResume")

        if (intent != null && intent.action == Intent.ACTION_VIEW) {
            val uri = intent.data
            if (uri!!.getQueryParameter("error") != null) {
                val error = uri.getQueryParameter("error")
                Log.d("zavanton - An error has occurred : " + error!!)
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
                Log.e(e, "zavanton - ERROR")
            }

            override fun onResponse(call: Call, response: Response) {
                val json = response.body()?.string()

                var data: JSONObject? = null
                try {
                    data = JSONObject(json!!)
                    val accessToken = data.optString("access_token")
                    val refreshToken = data.optString("refresh_token")

                    Log.d("Access Token = $accessToken")
                    Log.d("Refresh Token = $refreshToken")
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
        })
    }
}
