package com.wanttobuy.garagekit.data.notification

data class ZanMsg(
    val created_at: String,
    val from_uid: Int,
    val from_user: FromUser,
    val id: Int,
    val is_read: Int,
    val msg: String,
    val source: Source,
    val type: String,
    val uid: Int,
    val updated_at: String
)