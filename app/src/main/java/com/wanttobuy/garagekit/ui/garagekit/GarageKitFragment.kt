package com.wanttobuy.garagekit.ui.garagekit

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.drakeet.multitype.MultiTypeAdapter
import com.google.android.material.tabs.TabLayout
import com.wanttobuy.garagekit.GaragekitApplication
import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.base.BaseFragment
import com.wanttobuy.garagekit.common.PREF_ACCESS_TOKEN_AUTH
import com.wanttobuy.garagekit.databinding.FragmentGaragekitBinding
import com.wanttobuy.garagekit.utils.FrescoImageLoader
import com.wanttobuy.garagekit.utils.SharedPreferenceUtils
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_garagekit.*

class GarageKitFragment : BaseFragment<GarageKitViewModel,FragmentGaragekitBinding>() {

    lateinit var imageList : ArrayList<String>
    lateinit var mRoleTabs : ArrayList<String>
    lateinit var mVendorTabs : ArrayList<String>
    lateinit var mSeriesTabs : ArrayList<String>
    lateinit var mYearTabs : ArrayList<String>

    lateinit var mGaragekitAdapter : GarakitBinder
//    lateinit var items:MutableList<Any>
//    lateinit var mAdapter :MultiTypeAdapter

    override fun layoutId(): Int {
        return R.layout.fragment_garagekit
    }

    override fun initView(savedInstanceState: Bundle?) {
        mGaragekitAdapter = GarakitBinder()
//        mAdapter = MultiTypeAdapter(items)
        multiTypeAdapter.register(mGaragekitAdapter)
        mBinding?.rvGaragekit?.adapter = multiTypeAdapter
        mBinding?.rvGaragekit?.layoutManager = LinearLayoutManager(activity)
    }

    override fun lazyLoadData() {

        viewModel.run {
            getHomeData()
        }

        viewModel.category.observe(this, Observer {
            mRoleTabs = ArrayList()
            for (i in 0 until it.role.size){
                mRoleTabs.add(it.role[i].name)

            }
//            tl_role.setTabData(mRoleTabs.toTypedArray())

            mVendorTabs = ArrayList()
            for (i in 0 until it.vendor.size){
                mVendorTabs.add(it.vendor[i].name)
            }
//            tl_factory.setTabData(mVendorTabs.toTypedArray())

            mSeriesTabs = ArrayList()
            for (i in 0 until it.series.size){
                mSeriesTabs.add(it.series[i].name)
            }

            mYearTabs = ArrayList()
            for (i in 0 until it.year.size){
                mYearTabs.add(it.year[i])
            }
        })

        viewModel.mBanners.observe(this, Observer {
            imageList = ArrayList()
            imageList.clear()
            for (i in 0 until it.size!!){
                imageList.add(it[i].url)
            }
            banner.setImageLoader(FrescoImageLoader())
            banner.setImages(imageList)
            banner.start()
        })

        viewModel.garageKitItem.observe(this, Observer {
//            Log.e("EEEEE","---size----"+it.size)
//            item.addAll(it)
//            multiTypeAdapter.items = item
//            multiTypeAdapter.notifyDataSetChanged()
            addMore(it)
//            item.clear()
////            for (i in 0 until it.size){
//                item.addAll(it)
//                multiTypeAdapter
//            }

        })



    }

}