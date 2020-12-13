package com.kotlindiscord.api.client.serialisers

import com.kotlindiscord.api.client.enums.InfractionType
import com.kotlindiscord.api.client.enums.toInfractionType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.Instant

@Serializer(forClass = Instant::class)
class InfractionTypeSerialiser : KSerializer<InfractionType> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("WithCustomDefault", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: InfractionType) {
        encoder.encodeString(value.type)
    }

    override fun deserialize(decoder: Decoder): InfractionType = decoder.decodeString().toInfractionType()
}
