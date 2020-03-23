package com.wanttobuy.garagekit.data.bbs

data class bbs(
    val content: String,
    val created_at: String,
    val date: String,
    val deleted_at: Any,
    val hobby_id: Int,
    val hobby_label: Any,
    val id: Int,
    val pv: Int,
    val title: String,
    val uid: Int,
    val updated_at: String,
    val user: User
)