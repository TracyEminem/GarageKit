package com.wanttobuy.garagekit.data.comment

data class PagedComments(
    val bbs_id: Int,
    val comment_count: Int,
    val content: String,
    val created_at: String,
    val diff_for_humans: String,
    val id: Int,
    val pid: Int,
    val uid: Int,
    val updated_at: String,
    val user: UserXX,
    val zan_count: Int
)