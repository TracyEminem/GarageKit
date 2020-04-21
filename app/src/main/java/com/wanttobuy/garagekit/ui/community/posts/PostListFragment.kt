package com.wanttobuy.garagekit.ui.community.posts

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.base.BaseFragment
import com.wanttobuy.garagekit.databinding.FragmentPostListBinding
import com.wanttobuy.garagekit.ui.community.posts.adapter.NormalPostAdapter

class PostListFragment :BaseFragment<PostListViewModel,FragmentPostListBinding>() {

    open fun newInstance(type:String) :PostListFragment{
        var fragment = PostListFragment()
        var bundle = Bundle()
        bundle.putString("TYPE",type)
        fragment.arguments = bundle
        return fragment
    }

    lateinit var postAdapter:NormalPostAdapter

    override fun layoutId(): Int {
        return R.layout.fragment_post_list
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)


        postAdapter = NormalPostAdapter()
        multiTypeAdapter.register(postAdapter)
        mBinding?.rvPosts?.adapter = multiTypeAdapter
        mBinding?.rvPosts?.layoutManager = LinearLayoutManager(activity)


    }

    override fun lazyLoadData() {
        super.lazyLoadData()
        viewModel.getBBSPagesList()

        viewModel.postData.observe(this, Observer {

            if(it.size != 0)
                addMore(it)

        })

    }


}