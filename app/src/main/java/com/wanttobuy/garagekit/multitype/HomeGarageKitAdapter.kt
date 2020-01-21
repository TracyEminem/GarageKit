package com.wanttobuy.garagekit.multitype

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.data.garageKit.Data

class HomeGarageKitAdapter:ItemViewBinder<Data,HomeGarageKitAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, item: Data) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
       return  ViewHolder(inflater.inflate(R.layout.item_home_garagekit,parent,false))
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun setData(){



        }

    }

}