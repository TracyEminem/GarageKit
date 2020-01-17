package com.wanttobuy.garagekit.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.drakeet.multitype.MultiTypeAdapter
import com.wanttobuy.garagekit.R

/**
 *
 * @ClassName:      RefreshLayout
 * @Description:
 * @Author:         Jeremy
 * @CreateDate:     2020/1/16 上午 11:51
 */
class RefreshLayout @JvmOverloads constructor(context: Context,
                                              attrs: AttributeSet? = null,
                                              defStyleAttr: Int = 0)  : FrameLayout(context, attrs, defStyleAttr){

    lateinit var srlRefresh:SwipeRefreshLayout
    lateinit var mRecyclerView:RecyclerView
    lateinit var flEmpty:FrameLayout
    lateinit var tvReload:TextView

    init {

        var view = View.inflate(getContext(), R.layout.pull_refresh_layout,this)

//        var typeArray = getContext().obtainStyledAttributes(attrs,R.styleable.)


    }

    fun setView(){

    }

    public fun addItemDecoration(itemDecoration: RecyclerView.ItemDecoration){
        mRecyclerView.addItemDecoration(itemDecoration)
    }

    fun setLayoutManager(layoutManager: RecyclerView.LayoutManager?) {
        mRecyclerView.setLayoutManager(layoutManager)
    }

    fun setAdapter(adapter: MultiTypeAdapter) {
        mRecyclerView.setAdapter(adapter)
    }


}