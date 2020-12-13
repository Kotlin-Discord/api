package com.kotlindiscord.api.client.serialisers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Serializer(forClass = Instant::class)
class LocalDateTimeSerialiser : KSerializer<LocalDateTime> {
    private val df: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss.SSS")

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("WithCustomDefault", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalDateTime) = encoder.encodeString(value.format(df))

    override fun deserialize(decoder: Decoder): LocalDateTime = LocalDateTime.parse(decoder.decodeString(), df)
}
