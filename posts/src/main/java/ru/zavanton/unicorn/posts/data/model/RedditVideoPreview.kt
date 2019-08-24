package ru.zavanton.unicorn.posts.data.model

import com.google.gson.annotations.SerializedName

data class RedditVideoPreview(

    @SerializedName("fallback_url")
    var fallbackUrl: String? = null,

    var height: Int? = null,

    var width: Int? = null,

    @SerializedName("scrubber_media_url")
    var scrubberMediaUrl: String? = null,

    @SerializedName("dash_url")
    var dashUrl: String? = null,

    var duration: Int? = null,

    @SerializedName("hls_url")
    var hlsUrl: String? = null,

    @SerializedName("is_gif")
    var isGif: Boolean? = null,

    @SerializedName("transcoding_status")
    var transcodingStatus: String? = null
)
