package com.wanttobuy.garagekit.data.comment

data class Comments(
    val agree_num: Int,
    val content: String,
    val created_at: String,
    val deleted_at: Any,
    val hobby_id: Int,
    val id: Int,
    val updated_at: String,
    val user_id: Int
)