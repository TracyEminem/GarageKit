package com.wanttobuy.garagekit.data.notification

data class SysMsg(
    val created_at: String,
    val from_uid: Int,
    val from_user: FromUserX,
    val id: Int,
    val is_read: Int,
    val msg: String,
    val source: SourceX,
    val type: String,
    val uid: Int,
    val updated_at: String
)