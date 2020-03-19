package com.pinko.benchmark.io.json.models.jackson


import com.fasterxml.jackson.annotation.JsonProperty

/**
 * From: https://github.com/mootazltaief/android-json-benchmark
 */
data class Photos(
    @JsonProperty("results")
    val results: List<Result>,
    @JsonProperty("total")
    val total: Int,
    @JsonProperty("total_pages")
    val totalPages: Int
) {
    data class Result(
        @JsonProperty("color")
        val color: String,
        @JsonProperty("created_at")
        val createdAt: String,
        @JsonProperty("description")
        val description: String,
        @JsonProperty("height")
        val height: Int,
        @JsonProperty("id")
        val id: String,
        @JsonProperty("liked_by_user")
        val likedByUser: Boolean,
        @JsonProperty("likes")
        val likes: Int,
        @JsonProperty("links")
        val links: Links,
        @JsonProperty("urls")
        val urls: Urls,
        @JsonProperty("user")
        val user: User,
        @JsonProperty("width")
        val width: Int
    ) {
        data class Links(
            @JsonProperty("download")
            val download: String,
            @JsonProperty("html")
            val html: String,
            @JsonProperty("self")
            val self: String
        )

        data class User(
            @JsonProperty("first_name")
            val firstName: String,
            @JsonProperty("id")
            val id: String,
            @JsonProperty("instagram_username")
            val instagramUsername: String,
            @JsonProperty("last_name")
            val lastName: String,
            @JsonProperty("links")
            val links: Links,
            @JsonProperty("name")
            val name: String,
            @JsonProperty("portfolio_url")
            val portfolioUrl: String,
            @JsonProperty("profile_image")
            val profileImage: ProfileImage,
            @JsonProperty("twitter_username")
            val twitterUsername: String,
            @JsonProperty("username")
            val username: String
        ) {
            data class ProfileImage(
                @JsonProperty("large")
                val large: String,
                @JsonProperty("medium")
                val medium: String,
                @JsonProperty("small")
                val small: String
            )

            data class Links(
                @JsonProperty("html")
                val html: String,
                @JsonProperty("likes")
                val likes: String,
                @JsonProperty("photos")
                val photos: String,
                @JsonProperty("self")
                val self: String
            )
        }

        data class Urls(
            @JsonProperty("full")
            val full: String,
            @JsonProperty("raw")
            val raw: String,
            @JsonProperty("regular")
            val regular: String,
            @JsonProperty("small")
            val small: String,
            @JsonProperty("thumb")
            val thumb: String
        )
    }
}