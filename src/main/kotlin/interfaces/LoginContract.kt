package interfaces

import models.User

interface LoginContract {

    interface View{
        fun userNameInvalidFormat()
        fun passwordInvalidFormat()
        fun showErrorView()
        fun loadDashboardView(user: User)
    }

    interface Presenter{
        fun login(userName: String?, password: String?)
    }
}