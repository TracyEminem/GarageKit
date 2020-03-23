package com.wanttobuy.garagekit.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.aleyn.mvvm.base.BaseViewModel
import com.aleyn.mvvm.base.ViewModelFactory
import com.aleyn.mvvm.event.Message
import com.blankj.utilcode.util.ToastUtils
import com.drakeet.multitype.MultiTypeAdapter
import com.wanttobuy.garagekit.R
import java.lang.reflect.ParameterizedType

/**
 *
 * @ClassName:      BaseFragment
 * @Description:
 * @Author:         Jeremy
 * @CreateDate:     2020/1/16 上午 11:38
 */
abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : Fragment() {

    protected lateinit var viewModel: VM

    protected var mBinding: DB? = null

    lateinit var item:MutableList<Any> //multitype的Item

    lateinit var multiTypeAdapter: MultiTypeAdapter // MultiTypeAdapter

    //是否第一次加载
    private var isFirst: Boolean = true

    private var dialog: MaterialDialog? = null

    protected var isNavigationViewInit = false//记录是否已经初始化过一次视图
    private var lastView: View? = null//记录上次创建的view

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //如果fragment的view已经创建则不再重新创建
        if (lastView == null) {
            Log.e("EEEEE","---onCreateView--"+isNavigationViewInit)
            val cls =
                (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<*>
            if (ViewDataBinding::class.java != cls && ViewDataBinding::class.java.isAssignableFrom(cls)) {
                mBinding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
                return mBinding?.root
            }
            lastView = super.onCreateView(inflater, container, savedInstanceState)
        }
//        return lastView
        return lastView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e("EEEEEEE", "----onViewdsadsadsaCreated---" + isNavigationViewInit)
        if(!isNavigationViewInit) {
            super.onViewCreated(view, savedInstanceState)
            onVisible()
            createViewModel()
            lifecycle.addObserver(viewModel)
            //注册 UI事件
            item = ArrayList()
            multiTypeAdapter = MultiTypeAdapter(item)
            registorDefUIChange()
            initView(savedInstanceState)
            isNavigationViewInit = true
            Log.e("EEEEEEE", "----onViewCreated---" + isNavigationViewInit)
        }
    }

    fun insertData(){

    }

    fun addMore(addItem:List<Any>){
        val tempCount = item.size
        item.addAll(addItem)
        multiTypeAdapter.notifyItemRangeChanged(tempCount - 1,item.size)
    }

    open fun initView(savedInstanceState: Bundle?) {}

    override fun onResume() {
        super.onResume()
        onVisible()
    }

    abstract fun layoutId(): Int

    /**
     * 是否需要懒加载
     */
    private fun onVisible() {
        if (lifecycle.currentState == Lifecycle.State.STARTED && isFirst) {
            Log.e("EEEEEEE","-------"+isNavigationViewInit)
            lazyLoadData()
            isFirst = false
        }
    }

    /**
     * 懒加载
     */
    open fun lazyLoadData() {}

    /**
     * 注册 UI 事件
     */
    private fun registorDefUIChange() {
        viewModel.defUI.showDialog.observe(viewLifecycleOwner, Observer {
            showLoading()
        })
        viewModel.defUI.dismissDialog.observe(viewLifecycleOwner, Observer {
            dismissLoading()
        })
        viewModel.defUI.toastEvent.observe(viewLifecycleOwner, Observer {
            ToastUtils.showShort(it)
        })
        viewModel.defUI.msgEvent.observe(viewLifecycleOwner, Observer {
            handleEvent(it)
        })
    }

    open fun handleEvent(msg: Message) {}

    /**
     * 打开等待框
     */
    private fun showLoading() {
        if (dialog == null) {
            dialog = context?.let {
                MaterialDialog(it)
                    .cancelable(false)
                    .cornerRadius(8f)
                    .customView(R.layout.custom_progress_dialog_view, noVerticalPadding = true)
                    .lifecycleOwner(this)
                    .maxWidth(R.dimen.dialog_width)
            }
        }
        dialog?.show()
    }

    /**
     * 关闭等待框
     */
    private fun dismissLoading() {
        dialog?.run { if (isShowing) dismiss() }
    }


    /**
     * 创建 ViewModel
     */
    @Suppress("UNCHECKED_CAST")
    private fun createViewModel() {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val tp = type.actualTypeArguments[0]
            val tClass = tp as? Class<VM> ?: BaseViewModel::class.java
            viewModel = ViewModelProvider(this, ViewModelFactory()).get(tClass) as VM
        }
    }

}