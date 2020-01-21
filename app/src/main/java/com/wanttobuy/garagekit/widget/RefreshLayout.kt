package com.wanttobuy.garagekit.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.drakeet.multitype.MultiTypeAdapter
import com.wanttobuy.garagekit.R
import kotlinx.android.synthetic.main.pull_refresh_layout.view.*

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

//    lateinit var srlRefresh:SwipeRefreshLayout
//    lateinit var mRecyclerView:RecyclerView
//    lateinit var flEmpty:FrameLayout
//    lateinit var tvReload:TextView

    init {

        var view = View.inflate(getContext(), R.layout.pull_refresh_layout,this)

//        var typeArray = getContext().obtainStyledAttributes(attrs,R.styleable.)


    }

    fun setView(){

    }

    public fun addItemDecoration(itemDecoration: RecyclerView.ItemDecoration){
        rv_records.addItemDecoration(itemDecoration)
    }

    fun setLayoutManager(layoutManager: RecyclerView.LayoutManager?) {
        rv_records.setLayoutManager(layoutManager)
    }

    fun setAdapter(adapter: MultiTypeAdapter) {
        rv_records.setAdapter(adapter)
    }

    fun setItemAnimator(itemAnimator: RecyclerView.ItemAnimator){
        rv_records.itemAnimator = itemAnimator
    }

    fun onLoadingData(runnable: Runnable){
        srl_refresh.isRefreshing = true
        srl_refresh.post(runnable)
    }

    fun setRefreshing(reRefreshing:Boolean){
        srl_refresh.isRefreshing = reRefreshing
    }

    fun onLoadMoreCompleted(){

    }

    fun onRefreshCompleted(){
        srl_refresh.isRefreshing = false
    }

    fun setOnRefreshListener(onRefreshListener: SwipeRefreshLayout.OnRefreshListener) {
        srl_refresh.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
            override fun onRefresh() {
                fl_empty.setVisibility(View.GONE)
                onRefreshListener.onRefresh()
            }
        })
    }

    fun showEmptyView(show: Boolean) {
        if (show) {
            fl_empty.setVisibility(View.VISIBLE)
        } else {
            fl_empty.setVisibility(View.GONE)
        }
    }


}