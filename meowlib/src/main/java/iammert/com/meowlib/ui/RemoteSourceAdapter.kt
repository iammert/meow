package iammert.com.meowlib.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import iammert.com.meowlib.R
import iammert.com.meowlib.model.RemoteSource

/**
 * Created by mertsimsek on 24/01/18.
 */
class RemoteSourceAdapter(private var remoteSourceList: List<RemoteSource> = ArrayList(),
                          private val itemClickListener: ItemClickListener?) : RecyclerView.Adapter<RemoteSourceAdapter.RemoteSourceViewHolder>() {

    interface ItemClickListener {
        fun onItemClicked(remoteSource: RemoteSource)
    }

    fun updateList(list: List<RemoteSource>) {
        remoteSourceList = list
        notifyDataSetChanged()
    }

    override fun getItemCount() = remoteSourceList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RemoteSourceViewHolder {
        return RemoteSourceViewHolder.create(parent, itemClickListener)
    }

    override fun onBindViewHolder(holder: RemoteSourceViewHolder?, position: Int) {
        holder?.bind(remoteSourceList[position])
    }

    class RemoteSourceViewHolder(private val view: View, private val itemClickListener: ItemClickListener?) : RecyclerView.ViewHolder(view) {

        fun bind(remoteSource: RemoteSource) {
            val textviewName = view.findViewById(R.id.textview_remote_source_name) as TextView
            val background = view.findViewById(R.id.layout_item_remote_source) as ViewGroup
            textviewName.text = remoteSource.name

            var backgroundResource = R.drawable.circle_unselected
            if (remoteSource.isSelected) {
                backgroundResource = R.drawable.circle_selected
            }
            background.setBackgroundResource(backgroundResource)

            view.setOnClickListener { itemClickListener?.onItemClicked(remoteSource) }
        }

        companion object {
            fun create(parent: ViewGroup?, itemClickListener: ItemClickListener?): RemoteSourceViewHolder {
                val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_remote_source, parent, false)
                return RemoteSourceViewHolder(view, itemClickListener)
            }
        }

    }
}