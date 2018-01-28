package iammert.com.meow

import android.app.Application
import iammert.com.meowlib.Meow
import iammert.com.meowlib.model.MeowConfig
import iammert.com.meowlib.model.RemoteSource

/**
 * Created by mertsimsek on 23/01/2018.
 */
class MeowSampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val remote1 = RemoteSource(1, "102", "", false)
        val remote2 = RemoteSource(2, "103", "", false)
        val remote3 = RemoteSource(3, "104", "", false)
        val remote4 = RemoteSource(4, "105", "", true)
        val remoteList: MutableList<RemoteSource> = mutableListOf(remote1, remote2, remote3, remote4)
        val config = MeowConfig(remoteList)

        Meow.install(this, config)
    }

}