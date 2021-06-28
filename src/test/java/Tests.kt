import examples.F1
import math.ScalarFunction
import math.matrix.Vector
import method.*
import org.junit.jupiter.api.Test

class Tests {
    private val METHODS = listOf(
        ClassicNewtonMethod(),
        DescentNewtonMethod(),
        LinearSearchNewtonMethod(),
        PowellMethod()
    )

    private fun abstractTest(function: ScalarFunction, startPoints: List<Vector>, inaccuracy: Double = 1e-7, methods: List<MinimizeMethod> = METHODS) {
        for (startPoint in startPoints) {
            for (method in methods) {
                println(method.javaClass.name + ": " + method.minimize(function, startPoint, inaccuracy))
            }
        }
    }

    @Test
    fun test1() {
        abstractTest(
            F1(),
            listOf(
                Vector(listOf(1.0, 1.0, 1.0, 1.0)),
                Vector(listOf(5.0, 4.0, 3.0, 2.0)),
                Vector(listOf(10.0, 10.0, 10.0, 10.0)),
            ),
            1e-7
        )
    }
}