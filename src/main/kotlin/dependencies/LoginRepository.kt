package dependencies

import models.User

class LoginRepository {
    fun startSession(userName: String, password: String, listener: (user: User) -> Unit) {
        val user = User(
            2,
            "Hector",
            "Perez",
            "Calle toltecas, ....",
            "BARDGYEGYR7367",
            listOf(
                "futbol",
                "ajedrez"
            )
        )
        listener(user)
    }
}