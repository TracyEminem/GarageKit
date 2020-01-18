package com.wanttobuy.garagekit.utils

import com.wanttobuy.garagekit.data.GarageKitRepository
import com.wanttobuy.garagekit.data.http.GarageKitNetwork

object InjectorUtil {

    fun getGarageKitRepository() = GarageKitRepository.getInstance(GarageKitNetwork.getInstance())

}