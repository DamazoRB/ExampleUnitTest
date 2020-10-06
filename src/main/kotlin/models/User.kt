package models

data class User(
    val id: Int,
    val name: String,
    val lastName: String,
    val address: String,
    val rfc: String,
    val hobbies: List<String>
)