package com.kotlindiscord.api.client

import com.kotlindiscord.api.client.models.InfractionFilterModel
import com.kotlindiscord.api.client.models.InfractionModel
import com.kotlindiscord.api.client.models.RoleModel
import com.kotlindiscord.api.client.models.UserModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.http.ContentType
import io.ktor.http.contentType

class APIClient(val apiKey: String, val baseUrl: String = "https://kotlindiscord.com/api") {
    private val infractionsRoute = "$baseUrl/infractions"
    private val rolesRoute = "$baseUrl/roles"
    private val usersRoute = "$baseUrl/users"

    val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = GsonSerializer {
                disableHtmlEscaping()
                enableComplexMapKeySerialization()
                serializeNulls()
                serializeSpecialFloatingPointValues()
                setLenient()
            }
        }

        defaultRequest {
            header("X-Api-Key", apiKey)
        }
    }

    suspend fun getInfractions(filter: InfractionFilterModel): List<InfractionModel> {
        return client.get {
            contentType(ContentType.Application.Json)
            url(infractionsRoute)

            this.body = filter
        }
    }

    suspend fun createInfraction(infraction: InfractionModel): InfractionModel {
        return client.post {
            contentType(ContentType.Application.Json)
            url(infractionsRoute)

            this.body = infraction
        }
    }

    suspend fun upsertRole(role: RoleModel) {
        client.post<String?> {
            contentType(ContentType.Application.Json)
            url(rolesRoute)

            this.body = role
        }
    }

    suspend fun deleteRole(id: Long) {
        client.delete<String?> {
            contentType(ContentType.Application.Json)
            url("$rolesRoute/$id")
        }
    }

    suspend fun getRoles(): List<RoleModel> {
        return client.get {
            contentType(ContentType.Application.Json)
            url(rolesRoute)
        }
    }

    suspend fun upsertUser(role: UserModel) {
        client.post<String?> {
            contentType(ContentType.Application.Json)
            url(usersRoute)

            this.body = role
        }
    }

    suspend fun getUser(id: Long): UserModel {
        return client.get {
            contentType(ContentType.Application.Json)
            url("$usersRoute/$id")
        }
    }

    suspend fun getUsers(): List<UserModel> {
        return client.get {
            contentType(ContentType.Application.Json)
            url(usersRoute)
        }
    }
}
