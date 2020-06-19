package com.kotlindiscord.api.client.serialisers

import kotlinx.serialization.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Serializer(forClass = Instant::class)
class LocalDateTimeSerialiser : KSerializer<LocalDateTime> {
    private val df: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss.SSS")

    override val descriptor: SerialDescriptor = PrimitiveDescriptor("WithCustomDefault", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalDateTime) = encoder.encodeString(value.format(df))

    override fun deserialize(decoder: Decoder): LocalDateTime = LocalDateTime.parse(decoder.decodeString(), df)
}
