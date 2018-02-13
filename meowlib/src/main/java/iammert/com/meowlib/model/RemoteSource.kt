package iammert.com.meowlib.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by mertsimsek on 24/01/18.
 */
data class RemoteSource(val id: Int = -1, val name: String = "", val baseUrl: String = "", val isSelected: Boolean = false) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(baseUrl)
        parcel.writeByte(if (isSelected) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RemoteSource> {
        override fun createFromParcel(parcel: Parcel): RemoteSource {
            return RemoteSource(parcel)
        }

        override fun newArray(size: Int): Array<RemoteSource?> {
            return arrayOfNulls(size)
        }
    }
}