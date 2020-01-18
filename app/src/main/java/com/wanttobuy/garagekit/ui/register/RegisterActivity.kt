package com.wanttobuy.garagekit.ui.register

import android.os.Bundle
import com.aleyn.mvvm.base.BaseActivity
import com.aleyn.mvvm.base.NoViewModel
import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.databinding.ActivityRegisterBinding
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity<NoViewModel,ActivityRegisterBinding>(){
    override fun initData() {

    }

    override fun initView(savedInstanceState: Bundle?) {
        tv_verify.setOnClickListener {
            tv_verify.setTextColor(resources.getColor(R.color.black_text))
        }

        btn_confirm.setOnClickListener {



        }

    }

    override fun layoutId(): Int {
        return R.layout.activity_register
    }


}