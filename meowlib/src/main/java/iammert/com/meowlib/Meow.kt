package iammert.com.meowlib

import android.app.Application
import android.content.Context
import iammert.com.meowlib.model.MeowConfig

import java.lang.ref.WeakReference

/**
 * Created by mertsimsek on 23/01/2018.
 */

class Meow private constructor() {
    companion object {
        fun install(application: Application, config: MeowConfig) {
            ActivityWatcher.watch(application, config)
        }
    }
}
