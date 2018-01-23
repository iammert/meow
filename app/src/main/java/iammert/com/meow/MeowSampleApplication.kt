package iammert.com.meow

import android.app.Application
import iammert.com.meowlib.Meow

/**
 * Created by mertsimsek on 23/01/2018.
 */
class MeowSampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Meow.install(this)
    }

}