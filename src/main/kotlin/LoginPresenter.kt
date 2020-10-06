import com.sun.org.apache.xpath.internal.operations.Bool
import dependencies.LoginRepository
import dependencies.LoginView
import dependencies.Validator
import interfaces.LoginContract
import models.User

class LoginPresenter(
    private val validator: Validator,
    private val repository: LoginRepository,
    private val view: LoginContract.View
) : LoginContract.Presenter {

    override fun login(userName: String?, password: String?) {
        if (areValidFields(userName, password)) {
            startSession(userName!!, password!!)
        } else {
            view.showErrorView()
        }
    }

    fun isLogged(): Boolean{
        return true
    }

    private fun areValidFields(userName: String?, password: String?): Boolean {
        val isValidUserName = validator.isValidUserNameFormat(userName)
        val isValidPassword = validator.isValidPasswordFormat(password)

        if (isValidUserName.not()) {
            view.userNameInvalidFormat()
        }

        if (isValidPassword.not()) {
            view.passwordInvalidFormat()
        }

        return isValidUserName && isValidPassword
    }

    private fun startSession(userName: String, password: String) {
        repository.startSession(userName, password, ::loadDashboardView)
    }

    private fun loadDashboardView(user: User) {
        view.loadDashboardView(user)
    }


}