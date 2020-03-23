package com.wanttobuy.garagekit.data.comment

data class X(
    val bbs_id: Int,
    val comment_id: Int,
    val content: String,
    val created_at: String,
    val diff_for_humans: String,
    val id: Int,
    val pid: Int,
    val repay_user: RepayUser,
    val reply_uid: Int,
    val uid: Int,
    val updated_at: String,
    val user: User,
    val zan_count: Int
)