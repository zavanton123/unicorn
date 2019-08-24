package ru.zavanton.unicorn.posts.data.model

import com.google.gson.annotations.SerializedName

data class AllAwarding(

    @SerializedName("is_enabled")
    var isEnabled: Boolean? = null,

    var count: Int? = null,

    @SerializedName("subreddit_id")
    var subredditId: Any? = null,

    var description: String? = null,

    @SerializedName("coin_reward")
    var coinReward: Int? = null,

    @SerializedName("icon_width")
    var iconWidth: Int? = null,

    @SerializedName("icon_url")
    var iconUrl: String? = null,

    @SerializedName("days_of_premium")
    var daysOfPremium: Int? = null,

    var id: String? = null,

    @SerializedName("icon_height")
    var iconHeight: Int? = null,

    @SerializedName("resized_icons")
    var resizedIcons: List<ResizedIcon>? = null,

    @SerializedName("days_of_drip_extension")
    var daysOfDripExtension: Int? = null,

    @SerializedName("award_type")
    var awardType: String? = null,

    @SerializedName("coin_price")
    var coinPrice: Int? = null,

    @SerializedName("subreddit_coin_reward")
    var subredditCoinReward: Int? = null,

    var name: String? = null
)
