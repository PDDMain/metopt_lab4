import math.ScalarFunction

fun assertThrow(b: Boolean, m: String) {
    if (!b) {
        throw IllegalArgumentException(m)
    }
}

