package com.wanttobuy.garagekit.data.comment

data class Lou(
    val bbs_id: Int,
    val comment_count: Int,
    val comment_id: Int,
    val content: String,
    val created_at: String,
    val diff_for_humans: String,
    val id: Int,
    val pid: Int,
    val reply_uid: Int,
    val uid: Int,
    val updated_at: String,
    val user: UserX,
    val zan_count: Int
)