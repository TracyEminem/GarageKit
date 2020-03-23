package com.wanttobuy.garagekit.ui.notificationFragment

import com.wanttobuy.garagekit.R
import com.wanttobuy.garagekit.base.BaseFragment
import com.wanttobuy.garagekit.databinding.FragmentNotificationBinding

class NotificationFragment : BaseFragment<NotificationViewmodel, FragmentNotificationBinding>() {

    override fun layoutId(): Int {
        return R.layout.fragment_notification
    }


}