package com.wanttobuy.garagekit.data.comment

data class Comment(
    val content: String,
    val hobby_id: Int,
    val images: List<String>,
    val title: String,
    val type: String,
    val types_grade: TypesGrade
)