package com.wanttobuy.garagekit.ui.search

import android.os.Bundle
import com.aleyn.mvvm.base.BaseActivity
import com.aleyn.mvvm.base.NoViewModel
import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.databinding.ActivitySearchBinding

class SearchActivity :BaseActivity<NoViewModel,ActivitySearchBinding>() {

    override fun initData() {

    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun layoutId(): Int {
        return R.layout.activity_search
    }


}