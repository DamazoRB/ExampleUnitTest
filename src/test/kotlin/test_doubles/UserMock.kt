package test_doubles

import models.User

//Fake
val userOne = User(
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

//Dummy
val userEmpty = User(
    4,
    "Hector",
    "Perez",
    "",
    "",
    listOf()
)

//Fake and dummy
val userWithoutAddresses = User(
    3,
    "Hector",
    "Perez",
    "Calle toltecas, ....",
    "BARDGYEGYR7367",
    listOf()
)

