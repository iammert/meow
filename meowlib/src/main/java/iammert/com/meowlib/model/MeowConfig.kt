package iammert.com.meowlib.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by mertsimsek on 27/01/18.
 */
data class MeowConfig(val remoteList: List<RemoteSource>) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(RemoteSource))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(remoteList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MeowConfig> {
        override fun createFromParcel(parcel: Parcel): MeowConfig {
            return MeowConfig(parcel)
        }

        override fun newArray(size: Int): Array<MeowConfig?> {
            return arrayOfNulls(size)
        }
    }
}