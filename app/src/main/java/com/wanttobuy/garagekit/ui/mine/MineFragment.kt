package com.wanttobuy.garagekit.ui.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.wanttobuy.garagekit.base.BaseFragment
import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.databinding.FragmentMineBinding

class MineFragment : BaseFragment<MineViewModel,FragmentMineBinding>() {
    override fun layoutId(): Int {
       return R.layout.fragment_mine
    }


    private lateinit var mineViewModel: MineViewModel

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        mineViewModel =
//            ViewModelProviders.of(this).get(MineViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_mine, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        mineViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//        return root
//    }
}