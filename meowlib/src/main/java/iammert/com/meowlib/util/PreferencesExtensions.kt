package iammert.com.meowlib.util

import android.content.SharedPreferences

/**
 * Created by mertsimsek on 27/01/18.
 */
inline fun SharedPreferences.edit(func: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.func()
    editor.apply()
}