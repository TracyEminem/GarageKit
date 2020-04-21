package com.wanttobuy.garagekit.data.bbs

data class PostListData(
    val comment_count: String,
    val content: String,
    val created_at: String,
    val diff_for_humans: String,
    val hobby_id: Int,
    val hobby_label: Any,
    val hobby_score: String,
    val id: Int,
    val is_official: Int,
    val title: String,
    val type: String,
    val uid: String,
    val updated_at: String,
    val user: UserX,
    val zan_count: String
)