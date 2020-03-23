package com.wanttobuy.garagekit.ui.community.posts

import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.base.BaseFragment
import com.wanttobuy.garagekit.databinding.FragmentPostBinding

class PostFragment :BaseFragment<PostViewModel,FragmentPostBinding>() {

    override fun layoutId(): Int {
        return R.layout.fragment_post
    }


}