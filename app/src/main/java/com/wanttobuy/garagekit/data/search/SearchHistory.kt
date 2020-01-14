package com.wanttobuy.garagekit.data.search

data class SearchHistory(
    val hot_search: List<String>,
    val user_search: List<String>
)