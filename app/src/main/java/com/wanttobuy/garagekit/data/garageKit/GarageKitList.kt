package com.wanttobuy.garagekit.data.garageKit

data class GarageKitList(
    val count: Int,
    val current_page: Int,
    val `data`: List<Data>,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)