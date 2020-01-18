package com.wanttobuy.garagekit.ui.garagekit

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.base.BaseFragment
import com.wanttobuy.garagekit.databinding.FragmentGaragekitBinding
import kotlinx.android.synthetic.main.fragment_garagekit.*

class GarageKitFragment : BaseFragment<GarageKitViewModel,FragmentGaragekitBinding>() {


    override fun layoutId(): Int {
        return R.layout.fragment_garagekit
    }

    override fun initView(savedInstanceState: Bundle?) {



    }

    override fun lazyLoadData() {

        viewModel.run {
            getBanner()
        }


        viewModel.mBanners.observe(this, Observer {
            Log.e("EEEEE","----"+it.size)
            var imageList =  emptyList<String>()
            for (i in 0 until it.size!!){
            imageList.toMutableList().add(it[i].url)
            }
            banner.setImages(imageList)
        })

    }

}