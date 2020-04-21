package com.wanttobuy.garagekit.ui.community

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Observer
import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.base.BaseFragment
import com.wanttobuy.garagekit.databinding.FragmentCommunityBinding
import com.wanttobuy.garagekit.ui.community.posts.PostListFragment
import kotlinx.android.synthetic.main.fragment_community.*

class CommunityFragment : BaseFragment<CommunityViewModel, FragmentCommunityBinding>() {

    lateinit var pages : MutableList<PostListFragment>

    private val titles = ArrayList<String>()


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

        pages = ArrayList()
        if(pages.size == 0){
            pages.add(PostListFragment().newInstance("热门"))
            pages.add(PostListFragment().newInstance("最新回复"))
            pages.add(PostListFragment().newInstance("最新发布"))

            titles.add("热门")
            titles.add("最新回复")
            titles.add("最新发布")
        }

        mBinding?.vpCommunity?.adapter = MyFragmentPageAdapter(childFragmentManager)
//        mBinding?.vpCommunity?.

        mBinding?.tlDivider?.setupWithViewPager(mBinding?.vpCommunity)

        mBinding?.vpCommunity?.offscreenPageLimit = 3

        viewModel.signInData.observe(this, Observer {

//            Toast.makeText(activity,"打卡成功")
            btn_signon.isEnabled = false

        })

    }

    inner class MyFragmentPageAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager){

        override fun getItem(position: Int): Fragment {
            return pages[position]
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }

        override fun getCount(): Int {
            return pages.size
        }

    }


}