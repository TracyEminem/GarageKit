package com.wanttobuy.garagekit.data.garageKit

data class GarageKitDetail(
    val brand: String,
    val child_series: String,
    val collection_count: Int,
    val comment_count: Int,
    val cover: String,
    val currency: String,
    val genre: String,
    val grade_coating: Int,
    val grade_recommend: Int,
    val grade_sculpture: Int,
    val grade_style: Int,
    val height: Int,
    val id: Int,
    val is_collect: Boolean,
    val material: Int,
    val name: Any,
    val name_zh: Any,
    val publish_status: String,
    val recommend_count: Int,
    val reprint: List<Reprint>,
    val role: String,
    val series: String,
    val stylists: Int,
    val weight: Int,
    val year: Int
)