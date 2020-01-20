package com.wanttobuy.garagekit.ui.setting

import com.aleyn.mvvm.base.NoViewModel
import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.base.BaseFragment
import com.wanttobuy.garagekit.databinding.FragmentSettingBinding

class SettingFragment :BaseFragment<NoViewModel,FragmentSettingBinding>() {

    override fun layoutId(): Int {
        return R.layout.fragment_setting
    }

}