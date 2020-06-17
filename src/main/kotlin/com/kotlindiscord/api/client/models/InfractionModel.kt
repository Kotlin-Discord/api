@file:UseSerializers(InstantSerialiser::class, InfractionTypeSerialiser::class)

package com.kotlindiscord.api.client.models

import com.kotlindiscord.api.client.enums.InfractionType
import com.kotlindiscord.api.client.serialisers.InfractionTypeSerialiser
import com.kotlindiscord.api.client.serialisers.InstantSerialiser
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.time.Instant

@Serializable
data class InfractionModel(
    val id: Long,

    val infractor: Long,
    val user: Long,
    val reason: String,
    val type: InfractionType,

    val expires: Instant,
    val created: Instant
)
