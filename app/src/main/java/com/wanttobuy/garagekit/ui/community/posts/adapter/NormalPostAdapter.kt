package com.wanttobuy.garagekit.ui.community.posts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.drakeet.multitype.ItemViewBinder
import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.data.bbs.PostListData
import com.wanttobuy.garagekit.databinding.ItemCommunityPostBinding
import com.wanttobuy.garagekit.utils.BaseViewHolder

class NormalPostAdapter : ItemViewBinder<PostListData, BaseViewHolder<ItemCommunityPostBinding>>(){
    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemCommunityPostBinding>,
        item: PostListData
    ) {
        holder.binding.postData = item
        holder.binding.executePendingBindings()
//        holder.binding.starCount.rating = (item.recommend_grade / 2).toFloat()

        if (item.is_official == 0){
            holder.binding.tvDetail.visibility = View.INVISIBLE
        }else{
            holder.binding.tvDetail.visibility = View.VISIBLE
        }

    }

    override fun onCreateViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): BaseViewHolder<ItemCommunityPostBinding> {
        var binding = DataBindingUtil.inflate<ItemCommunityPostBinding>(inflater,
            R.layout.item_community_post,parent,false)
        return BaseViewHolder(binding)
    }
}