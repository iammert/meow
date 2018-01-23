package iammert.com.meowlib

import android.app.Activity
import android.app.Application
import android.os.Bundle
import iammert.com.meowlib.ui.DrawerAttacher

/**
 * Created by mertsimsek on 23/01/2018.
 */
class ActivityWatcher constructor(application: Application) {

    private val lifecycleCallback = object : Application.ActivityLifecycleCallbacks {
        override fun onActivityPaused(p0: Activity?) {
        }

        override fun onActivityResumed(p0: Activity?) {
            DrawerAttacher(p0).attach()
        }

        override fun onActivityStarted(p0: Activity?) {
        }

        override fun onActivityDestroyed(p0: Activity?) {
        }

        override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
        }

        override fun onActivityStopped(p0: Activity?) {
        }

        override fun onActivityCreated(p0: Activity?, p1: Bundle?) {

        }
    }

    init {
        application.registerActivityLifecycleCallbacks(lifecycleCallback)
    }

    companion object {
        fun watch(application: Application) {
            ActivityWatcher(application)
        }
    }

}