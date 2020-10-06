import dependencies.LoginRepository
import dependencies.Validator
import interfaces.LoginContract
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner
import utils.anyObjectOrArgument

@RunWith(MockitoJUnitRunner.StrictStubs::class)
class LoginPresenterTest{

    @Mock
    lateinit var validator: Validator

    @Spy
    @InjectMocks
    lateinit var presenter: LoginPresenter

    @Mock
    lateinit var repository: LoginRepository

    @Mock
    lateinit var view: LoginContract.View

    @Test
    fun isLogged(){
        presenter.isLogged()

        verify(presenter).isLogged()
        assertEquals(true, presenter.isLogged())
    }

    @Test
    fun failedLogin(){
        `when`(validator.isValidUserNameFormat(null))
            .thenReturn(false)
        `when`(validator.isValidPasswordFormat(null))
            .thenReturn(false)

        presenter.login(null, null)

        //Mock
        verify(validator).isValidUserNameFormat(null)
        verify(validator).isValidPasswordFormat(null)
        verify(view).showErrorView()
        verify(view, never()).loadDashboardView(anyObjectOrArgument())
    }

    @Test
    fun loginSuccessful(){
        doReturn(true).`when`(validator).isValidPasswordFormat("pedro123")
        doReturn(false).`when`(validator).isValidPasswordFormat("12345")

        /*lenient().`when`(validator.isValidPasswordFormat("pedro123"))
            .thenReturn(true)
        lenient().`when`(validator.isValidPasswordFormat("pedro"))
            .thenReturn(false)
*/
        presenter.login("pedro", "12345")

        //Mock
        Mockito.verify(validator).isValidUserNameFormat("pedro")
        Mockito.verify(validator).isValidPasswordFormat("12345")

        Mockito.verify(view, never()).loadDashboardView(anyObjectOrArgument())
    }
}