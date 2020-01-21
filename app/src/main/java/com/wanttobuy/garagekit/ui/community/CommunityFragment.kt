package com.wanttobuy.garagekit.ui.community

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.base.BaseFragment
import com.wanttobuy.garagekit.databinding.FragmentCommunityBinding
import kotlinx.android.synthetic.main.fragment_community.*

class CommunityFragment : BaseFragment<CommunityViewModel, FragmentCommunityBinding>() {

    override fun layoutId(): Int {
        return R.layout.fragment_community
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)

        btn_signon.setOnClickListener {
            viewModel.run {
                signIn()
            }
        }

    }


}