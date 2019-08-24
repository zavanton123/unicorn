package ru.zavanton.unicorn.posts.data.model

import com.google.gson.annotations.SerializedName

data class Preview(

    var images: List<Image>? = null,

    @SerializedName("reddit_video_preview")
    var redditVideoPreview: RedditVideoPreview? = null,

    var enabled: Boolean? = null
)
