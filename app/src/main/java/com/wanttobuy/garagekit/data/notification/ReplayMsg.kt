package com.wanttobuy.garagekit.data.notification

data class ReplayMsg(
    val created_at: String,
    val from_uid: Int,
    val from_user: FromUserXX,
    val id: Int,
    val is_read: Int,
    val msg: String,
    val source: SourceXX,
    val type: String,
    val uid: Int,
    val updated_at: String
)