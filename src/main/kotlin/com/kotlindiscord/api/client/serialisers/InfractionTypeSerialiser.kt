package com.kotlindiscord.api.client.serialisers

import com.kotlindiscord.api.client.enums.InfractionType
import com.kotlindiscord.api.client.enums.toInfractionType
import kotlinx.serialization.*
import java.time.Instant

@Serializer(forClass = Instant::class)
class InfractionTypeSerialiser : KSerializer<InfractionType> {
    override val descriptor: SerialDescriptor = PrimitiveDescriptor("WithCustomDefault", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: InfractionType) {
        encoder.encodeString(value.type)
    }

    override fun deserialize(decoder: Decoder): InfractionType = decoder.decodeString().toInfractionType()
}
