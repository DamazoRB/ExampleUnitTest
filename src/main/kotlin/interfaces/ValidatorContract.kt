package interfaces

interface ValidatorContract{
    fun isValidUserNameFormat(userName: String?): Boolean
    fun isValidPasswordFormat(password: String?): Boolean
}