package iammert.com.meowlib.ui

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iammert.com.meowlib.R
import iammert.com.meowlib.data.RemoteDataRepository
import iammert.com.meowlib.model.MeowConfig
import iammert.com.meowlib.model.RemoteSource

/**
 * Created by mertsimsek on 23/01/2018.
 */
class MeowFragment : Fragment(), RemoteSourceAdapter.ItemClickListener {

    lateinit var config: MeowConfig
    lateinit var dataRepository: RemoteDataRepository
    lateinit var adapter: RemoteSourceAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_meow, container, false)
        recyclerView = view?.findViewById(R.id.recyclerview_remote_sources) as RecyclerView
        config = arguments.getParcelable(KEY)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dataRepository = RemoteDataRepository(this.activity, config)
        adapter = RemoteSourceAdapter(dataRepository.getRemoteDataList(), this)
        recyclerView.adapter = adapter
    }

    override fun onItemClicked(remoteSource: RemoteSource) {
        dataRepository.saveSelectedRemoteSource(remoteSource)
        adapter.updateList(dataRepository.getRemoteDataList())
    }

    companion object {
        const val KEY = "KEY"

        fun newInstance(config: MeowConfig): MeowFragment {
            val bundle = Bundle()
            bundle.putParcelable(KEY, config)
            val fragment = MeowFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}