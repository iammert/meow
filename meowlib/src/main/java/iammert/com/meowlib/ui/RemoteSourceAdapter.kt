package iammert.com.meowlib.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import iammert.com.meowlib.databinding.ItemRemoteSourceBinding
import iammert.com.meowlib.model.RemoteSource

/**
 * Created by mertsimsek on 24/01/18.
 */
class RemoteSourceAdapter(private val remoteSourceList: List<RemoteSource> = ArrayList()) : RecyclerView.Adapter<RemoteSourceAdapter.RemoteSourceViewHolder>() {

    override fun getItemCount() = remoteSourceList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RemoteSourceViewHolder {
        return RemoteSourceViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RemoteSourceViewHolder?, position: Int) {
        holder?.bind(remoteSourceList[position])
    }

    class RemoteSourceViewHolder(val binding: ItemRemoteSourceBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(remoteSource: RemoteSource) {
            binding.remoteSource = remoteSource
            binding.executePendingBindings()
        }

        companion object {
            fun create(parent: ViewGroup?): RemoteSourceViewHolder {
                val remoteSourceBinding = ItemRemoteSourceBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
                return RemoteSourceViewHolder(remoteSourceBinding)
            }
        }

    }
}