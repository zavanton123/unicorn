package ru.zavanton.unicorn.posts.data.model

import com.google.gson.annotations.SerializedName

data class Data_(

    @SerializedName("approved_at_utc")
    var approvedAtUtc: Any? = null,

    var subreddit: String? = null,

    var selftext: String? = null,
    @SerializedName("author_fullname")
    var authorFullname: String? = null,

    var saved: Boolean? = null,

    @SerializedName("mod_reason_title")
    var modReasonTitle: Any? = null,

    var gilded: Int? = null,

    var clicked: Boolean? = null,

    var title: String? = null,

    @SerializedName("link_flair_richtext")
    var linkFlairRichtext: List<Any>? = null,

    @SerializedName("subreddit_name_prefixed")
    var subredditNamePrefixed: String? = null,

    var hidden: Boolean? = null,

    var pwls: Int? = null,

    @SerializedName("link_flair_css_class")
    var linkFlairCssClass: Any? = null,

    var downs: Int? = null,

    @SerializedName("thumbnail_height")
    var thumbnailHeight: Int? = null,

    @SerializedName("hide_score")
    var hideScore: Boolean? = null,

    var name: String? = null,

    var quarantine: Boolean? = null,
    @SerializedName("link_flair_text_color")

    var linkFlairTextColor: String? = null,
    @SerializedName("author_flair_background_color")

    var authorFlairBackgroundColor: Any? = null,
    @SerializedName("subreddit_type")

    var subredditType: String? = null,

    var ups: Int? = null,
    @SerializedName("total_awards_received")

    var totalAwardsReceived: Int? = null,
    @SerializedName("media_embed")

    var mediaEmbed: MediaEmbed? = null,
    @SerializedName("thumbnail_width")

    var thumbnailWidth: Int? = null,
    @SerializedName("author_flair_template_id")

    var authorFlairTemplateId: Any? = null,
    @SerializedName("is_original_content")

    var isOriginalContent: Boolean? = null,
    @SerializedName("user_reports")

    var userReports: List<Any>? = null,
    @SerializedName("secure_media")

    var secureMedia: Any? = null,
    @SerializedName("is_reddit_media_domain")

    var isRedditMediaDomain: Boolean? = null,
    @SerializedName("is_meta")

    var isMeta: Boolean? = null,

    var category: Any? = null,
    @SerializedName("secure_media_embed")

    var secureMediaEmbed: SecureMediaEmbed? = null,
    @SerializedName("link_flair_text")

    var linkFlairText: Any? = null,
    @SerializedName("can_mod_post")

    var canModPost: Boolean? = null,

    var score: Int? = null,
    @SerializedName("approved_by")

    var approvedBy: Any? = null,

    var thumbnail: String? = null,

    var edited: Boolean? = null,
    @SerializedName("author_flair_css_class")

    var authorFlairCssClass: Any? = null,
    @SerializedName("author_flair_richtext")

    var authorFlairRichtext: List<Any>? = null,

    var gildings: Gildings? = null,
    @SerializedName("post_hint")

    var postHint: String? = null,
    @SerializedName("content_categories")

    var contentCategories: Any? = null,
    @SerializedName("is_self")

    var isSelf: Boolean? = null,
    @SerializedName("mod_note")

    var modNote: Any? = null,

    var created: Double? = null,
    @SerializedName("link_flair_type")

    var linkFlairType: String? = null,

    var wls: Int? = null,
    @SerializedName("banned_by")

    var bannedBy: Any? = null,
    @SerializedName("author_flair_type")

    var authorFlairType: String? = null,

    var domain: String? = null,
    @SerializedName("allow_live_comments")

    var allowLiveComments: Boolean? = null,
    @SerializedName("selftext_html")

    var selftextHtml: Any? = null,

    var likes: Any? = null,
    @SerializedName("suggested_sort")

    var suggestedSort: Any? = null,
    @SerializedName("banned_at_utc")

    var bannedAtUtc: Any? = null,
    @SerializedName("view_count")

    var viewCount: Any? = null,

    var archived: Boolean? = null,
    @SerializedName("no_follow")

    var noFollow: Boolean? = null,
    @SerializedName("is_crosspostable")

    var isCrosspostable: Boolean? = null,

    var pinned: Boolean? = null,
    @SerializedName("over_18")

    var over18: Boolean? = null,

    var preview: Preview? = null,
    @SerializedName("all_awardings")

    var allAwardings: List<AllAwarding>? = null,
    @SerializedName("media_only")

    var mediaOnly: Boolean? = null,
    @SerializedName("can_gild")

    var canGild: Boolean? = null,

    var spoiler: Boolean? = null,

    var locked: Boolean? = null,
    @SerializedName("author_flair_text")

    var authorFlairText: Any? = null,

    var visited: Boolean? = null,
    @SerializedName("num_reports")

    var numReports: Any? = null,

    var distinguished: Any? = null,
    @SerializedName("subreddit_id")

    var subredditId: String? = null,
    @SerializedName("mod_reason_by")

    var modReasonBy: Any? = null,
    @SerializedName("removal_reason")

    var removalReason: Any? = null,
    @SerializedName("link_flair_background_color")

    var linkFlairBackgroundColor: String? = null,

    var id: String? = null,
    @SerializedName("is_robot_indexable")

    var isRobotIndexable: Boolean? = null,
    @SerializedName("report_reasons")

    var reportReasons: Any? = null,

    var author: String? = null,
    @SerializedName("num_crossposts")

    var numCrossposts: Int? = null,
    @SerializedName("num_comments")

    var numComments: Int? = null,
    @SerializedName("send_replies")

    var sendReplies: Boolean? = null,
    @SerializedName("whitelist_status")

    var whitelistStatus: String? = null,
    @SerializedName("contest_mode")

    var contestMode: Boolean? = null,
    @SerializedName("mod_reports")

    var modReports: List<Any>? = null,
    @SerializedName("author_patreon_flair")

    var authorPatreonFlair: Boolean? = null,
    @SerializedName("author_flair_text_color")

    var authorFlairTextColor: Any? = null,

    var permalink: String? = null,
    @SerializedName("parent_whitelist_status")

    var parentWhitelistStatus: String? = null,

    var stickied: Boolean? = null,

    var url: String? = null,
    @SerializedName("subreddit_subscribers")

    var subredditSubscribers: Int? = null,
    @SerializedName("created_utc")

    var createdUtc: Double? = null,
    @SerializedName("discussion_type")

    var discussionType: Any? = null,

    var media: Any? = null,
    @SerializedName("is_video")

    var isVideo: Boolean? = null
)
