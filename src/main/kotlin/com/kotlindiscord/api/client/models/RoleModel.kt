package com.kotlindiscord.api.client.models

import kotlinx.serialization.Serializable

@Serializable
data class RoleModel(
        val id: Long,

        val name: String,
        val colour: Int
)
