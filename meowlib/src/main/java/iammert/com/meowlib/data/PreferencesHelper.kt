package iammert.com.meowlib.data

import android.content.Context
import android.text.TextUtils
import com.google.gson.Gson
import iammert.com.meowlib.model.RemoteSource
import iammert.com.meowlib.util.edit

/**
 * Created by mertsimsek on 27/01/18.
 */
class PreferencesHelper {

    companion object {
        private val PREF_NAME = "PREF_NAME_MEOW"
        private val KEY_SELECTED_REMOTE_SOURCE = "KEY_SELECTED_REMOTE_SOURCE"

        fun getSharedPreferences(context: Context) = context.getSharedPreferences(PREF_NAME, 0)

        fun saveSelectedRemoteSource(context: Context, remoteSource: RemoteSource) {
            getSharedPreferences(context).edit { putString(KEY_SELECTED_REMOTE_SOURCE, Gson().toJson(remoteSource)) }
        }

        fun getSelectedRemoteSource(context: Context): RemoteSource? {
            val remoteSourceJson = getSharedPreferences(context).getString(KEY_SELECTED_REMOTE_SOURCE, "")
            if (TextUtils.isEmpty(remoteSourceJson)) {
                return RemoteSource()
            }
            return Gson().fromJson(remoteSourceJson, RemoteSource::class.java)
        }
    }
}