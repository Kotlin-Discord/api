package com.kotlindiscord.api.client.serialisers

import kotlinx.serialization.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Serializer(forClass = Instant::class)
class LocalDateTimeSerialiser : KSerializer<LocalDateTime> {
    private val df: DateFormat = SimpleDateFormat("dd/MM/yyyy  HH:mm:ss.SSS")

    override val descriptor: SerialDescriptor = PrimitiveDescriptor("WithCustomDefault", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        encoder.encodeString(df.format(value.toInstant(ZoneOffset.UTC)))
    }

    override fun deserialize(decoder: Decoder): LocalDateTime = LocalDateTime.from(
            df.parse(decoder.decodeString())
                    .toInstant()
    )
}
