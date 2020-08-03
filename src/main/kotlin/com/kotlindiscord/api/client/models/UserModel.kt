package com.kotlindiscord.api.client.models

import kotlinx.serialization.Serializable

@Serializable
data class UserModel(
        val id: Long,

        val username: String,
        val discriminator: String,
        val avatarUrl: String,
        val roles: Set<Long> = setOf(),

        val present: Boolean = true
)
