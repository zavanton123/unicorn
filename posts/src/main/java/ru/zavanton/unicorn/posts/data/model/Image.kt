package ru.zavanton.unicorn.posts.data.model

data class Image(

    var source: Source? = null,

    var resolutions: List<Resolution>? = null,

    var variants: Variants? = null,

    var id: String? = null
)
