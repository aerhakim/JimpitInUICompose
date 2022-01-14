package com.example.jimpitinuicompose

data class Image(
    val title: String,
    val rating: Float,
    val desc: String,
    val imgUrl: String
)

val image = listOf(
    Image(
        "Sample 1",
        4.0f,
        "Make it Easy Decription Sample 1",
        ""
    ),
    Image(
        "Sample 2",
        4.5f,
        "Make it Easy Decription Sample 2",
        ""
    ),
    Image(
        "Sample 3",
        5.0f,
        "Make it Easy Decription Sample 3",
        ""
    ),
    Image(
        "Sample 4",
        3.5f,
        "Make it Easy Decription Sample 4",
        ""
    ),
    Image(
        "Sample 5",
        2.0f,
        "Make it Easy Decription Sample 5",
        ""
    )
)