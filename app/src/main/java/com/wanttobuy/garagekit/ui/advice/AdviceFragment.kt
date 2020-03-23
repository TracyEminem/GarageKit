package com.wanttobuy.garagekit.ui.advice

import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.base.BaseFragment
import com.wanttobuy.garagekit.databinding.FragmentAdviceBinding

class AdviceFragment :BaseFragment<AdviceViewmodel,FragmentAdviceBinding>() {

    override fun layoutId(): Int {
        return R.layout.fragment_advice
    }
    
}