package com.wanttobuy.garagekit.data.category

data class Category(
    val vendor: List<Brand>,
    val role: List<Role>,
    val series: List<Sery>,
    val year: List<String>
)