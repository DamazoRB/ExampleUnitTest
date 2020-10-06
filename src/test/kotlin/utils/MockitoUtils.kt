package utils

import org.mockito.ArgumentCaptor
import org.mockito.Mockito

fun <T> ArgumentCaptor<T>.captureNotNull(): T = this.capture()

@Suppress("UNCHECKED_CAST")
fun <T> anyObjectOrArgument(): T {
    Mockito.any<T>()
    return null as T
}


@Suppress("UNCHECKED_CAST")
fun <T> eqTo(value: T): T {
    Mockito.eq(value)
    return value
}