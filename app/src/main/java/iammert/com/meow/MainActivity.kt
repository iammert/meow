package iammert.com.meow

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener { request() }
    }

    private fun request() {
        (application as MeowSampleApplication)
                .getRetrofit()
                .getUsers()
                .enqueue(object : Callback<List<String>> {
                    override fun onFailure(call: Call<List<String>>?, t: Throwable?) {
                    }

                    override fun onResponse(call: Call<List<String>>?, response: Response<List<String>>?) {
                        Log.v("TEST", "result:" + response?.body().toString())
                    }
                })
    }
}
