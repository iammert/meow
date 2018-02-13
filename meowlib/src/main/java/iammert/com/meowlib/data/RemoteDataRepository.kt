package iammert.com.meowlib.data

import android.content.Context
import iammert.com.meowlib.model.MeowConfig
import iammert.com.meowlib.model.RemoteSource

/**
 * Created by mertsimsek on 13/02/2018.
 */
class RemoteDataRepository constructor(private val context: Context, private val config: MeowConfig) {

    fun getRemoteDataList(): List<RemoteSource> {
        val list = config.remoteList
        val updatedList: ArrayList<RemoteSource> = ArrayList()
        val selectedId = PreferencesHelper.getSelectedRemoteSource(context.applicationContext)
        list.mapTo(updatedList) { RemoteSource(it.id, it.name, it.baseUrl, selectedId == it.id) }
        return updatedList
    }

    fun saveSelectedRemoteSource(remoteSource: RemoteSource) {
        PreferencesHelper.saveSelectedRemoteSource(context, remoteSource.id)
    }
}