package com.wanttobuy.garagekit.data.evaluate

data class Evaluate(
    val content: String,
    val created_at: String,
    val deleted_at: Any,
    val hobby_id: Int,
    val hobby_label: Any,
    val hobby_score: List<HobbyScore>,
    val id: Int,
    val pv: Int,
    val title: String,
    val type: Int,
    val uid: Int,
    val updated_at: String,
    val user: User
)