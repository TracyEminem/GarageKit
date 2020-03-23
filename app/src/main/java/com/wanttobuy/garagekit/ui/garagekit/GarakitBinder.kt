package com.wanttobuy.garagekit.ui.garagekit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.drakeet.multitype.ItemViewBinder
import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.data.garageKit.Data
import com.wanttobuy.garagekit.databinding.ItemHomeGaragekitBinding
import com.wanttobuy.garagekit.utils.BaseViewHolder

class GarakitBinder : ItemViewBinder<Data,BaseViewHolder<ItemHomeGaragekitBinding>>() {

    override fun onBindViewHolder(holder: BaseViewHolder<ItemHomeGaragekitBinding>, item: Data) {
        holder.binding.garakit = item
        holder.binding.executePendingBindings()
        holder.binding.starCount.rating = (item.recommend_grade / 2).toFloat()
    }

    override fun onCreateViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): BaseViewHolder<ItemHomeGaragekitBinding> {
        var binding = DataBindingUtil.inflate<ItemHomeGaragekitBinding>(inflater,R.layout.item_home_garagekit,parent,false)
        return BaseViewHolder(binding)
    }
}