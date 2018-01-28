package iammert.com.meowlib.data

import android.content.Context
import iammert.com.meowlib.util.edit

/**
 * Created by mertsimsek on 27/01/18.
 */
class PreferencesHelper {

    companion object {
        val PREF_NAME = "PREF_NAME_MEOW"
        val KEY_SELECTED_REMOTE_SOURCE = "KEY_SELECTED_REMOTE_SOURCE"

        fun getSharedPreferences(context: Context) = context.getSharedPreferences(PREF_NAME, 0)

        fun saveSelectedRemoteSource(context: Context, id: Int) {
            getSharedPreferences(context).edit { putInt(KEY_SELECTED_REMOTE_SOURCE, id) }
        }

        fun getSelectedRemoteSource(context: Context): Int {
            return getSharedPreferences(context).getInt(KEY_SELECTED_REMOTE_SOURCE, -1)
        }
    }

}