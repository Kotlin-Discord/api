@file:UseSerializers(LocalDateTimeSerialiser::class, InfractionTypeSerialiser::class)

package com.kotlindiscord.api.client.models

import com.kotlindiscord.api.client.enums.InfractionType
import com.kotlindiscord.api.client.serialisers.InfractionTypeSerialiser
import com.kotlindiscord.api.client.serialisers.LocalDateTimeSerialiser
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.time.LocalDateTime

@Serializable
data class InfractionFilterModel(
        val id: Long?,

        val infractor: Long?,
        val user: Long?,

        val reason: String?,
        val type: InfractionType?,

        val createdAfter: LocalDateTime?,
        val createdBefore: LocalDateTime?,

        val active: Boolean?
)
