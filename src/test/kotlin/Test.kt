import com.kotlindiscord.api.client.APIClient
import com.kotlindiscord.api.client.enums.InfractionType
import com.kotlindiscord.api.client.models.InfractionModel
import com.kotlindiscord.api.client.models.RoleModel
import com.kotlindiscord.api.client.models.UserModel
import java.time.LocalDateTime

suspend fun main() {
    val client = APIClient("test", "http://localhost:8080/api")

    val role = RoleModel(0, "admin", 0xFF0000)

    client.upsertRole(role)

    println(client.getRoles())

    client.upsertUser(
            UserModel(
                    0,
                    "gdude",
                    "2002",
                    "n/a",
                    setOf(role.id)
            )
    )

    println(client.getUsers())
    println(client.getUser(0L))

    println(
            client.upsertInfraction(
                    InfractionModel(
                            infractor = 0,
                            user = 0,
                            reason = "Spam",
                            type = InfractionType.WARN,
                            created = LocalDateTime.now()
                    )
            )
    )
}
