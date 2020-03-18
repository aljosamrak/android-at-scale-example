package com.pinko.benchmark.json.models.moshi


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * From: https://github.com/mootazltaief/android-json-benchmark
 */
@JsonClass(generateAdapter = true)
data class Photos(
    @Json(name = "results")
    val results: List<Result>,
    @Json(name = "total")
    val total: Int,
    @Json(name = "total_pages")
    val totalPages: Int
) {
    @JsonClass(generateAdapter = true)
    data class Result(
        @Json(name = "color")
        val color: String,
        @Json(name = "created_at")
        val createdAt: String,
        @Json(name = "description")
        val description: String,
        @Json(name = "height")
        val height: Int,
        @Json(name = "id")
        val id: String,
        @Json(name = "liked_by_user")
        val likedByUser: Boolean,
        @Json(name = "likes")
        val likes: Int,
        @Json(name = "links")
        val links: Links,
        @Json(name = "urls")
        val urls: Urls,
        @Json(name = "user")
        val user: User,
        @Json(name = "width")
        val width: Int
    ) {
        @JsonClass(generateAdapter = true)
        data class Links(
            @Json(name = "download")
            val download: String,
            @Json(name = "html")
            val html: String,
            @Json(name = "self")
            val self: String
        )

        @JsonClass(generateAdapter = true)
        data class User(
            @Json(name = "first_name")
            val firstName: String,
            @Json(name = "id")
            val id: String,
            @Json(name = "instagram_username")
            val instagramUsername: String,
            @Json(name = "last_name")
            val lastName: String,
            @Json(name = "links")
            val links: Links,
            @Json(name = "name")
            val name: String,
            @Json(name = "portfolio_url")
            val portfolioUrl: String,
            @Json(name = "profile_image")
            val profileImage: ProfileImage,
            @Json(name = "twitter_username")
            val twitterUsername: String,
            @Json(name = "username")
            val username: String
        ) {
            @JsonClass(generateAdapter = true)
            data class ProfileImage(
                @Json(name = "large")
                val large: String,
                @Json(name = "medium")
                val medium: String,
                @Json(name = "small")
                val small: String
            )

            @JsonClass(generateAdapter = true)
            data class Links(
                @Json(name = "html")
                val html: String,
                @Json(name = "likes")
                val likes: String,
                @Json(name = "photos")
                val photos: String,
                @Json(name = "self")
                val self: String
            )
        }

        @JsonClass(generateAdapter = true)
        data class Urls(
            @Json(name = "full")
            val full: String,
            @Json(name = "raw")
            val raw: String,
            @Json(name = "regular")
            val regular: String,
            @Json(name = "small")
            val small: String,
            @Json(name = "thumb")
            val thumb: String
        )
    }
}