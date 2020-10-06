package dependencies

import interfaces.ValidatorContract

class Validator: ValidatorContract {
    override fun isValidUserNameFormat(userName: String?): Boolean {
        return userName.isNullOrEmpty() || userName.length < 5
    }

    override fun isValidPasswordFormat(password: String?): Boolean {
        return password.isNullOrEmpty() || password.length != 5
    }
}