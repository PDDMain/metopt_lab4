import examples.F1
import examples.F2
import examples.F3
import examples.F4
import math.ScalarFunction
import math.matrix.Vector
import method.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Tests {
    private val METHODS = listOf(
        ClassicNewtonMethod(),
        DescentNewtonMethod(),
        LinearSearchNewtonMethod(),
        PowellMethod()
    )

    private fun abstractTest(
        function: ScalarFunction,
        startPoints: List<Vector> = listOf(
            Vector(listOf(1.0, 1.0)),
//            Vector(listOf(5.0, 4.0)),
//            Vector(listOf(10.0, 10.0)),
        ),
        inaccuracy: Double = 1e-7,
        methods: List<MinimizeMethod> = METHODS
    ) {
        for (startPoint in startPoints) {
            val array = ArrayList<Vector>()
            for (method in methods) {
                val v = method.minimize(function, startPoint, inaccuracy)
                array.add(v)
                println(method.javaClass.name + ": " + v)
            }

            for (x in array) {
                assertTrue(array[0].equals(x, inaccuracy), "Methods give different results")
            }
        }
    }

    @Test
    fun test1() {
        abstractTest(
            F1()
        )
    }

    @Test
    fun test2() {
        abstractTest(
            F2()
        )
    }

    @Test
    fun test3() {
        abstractTest(
            F3()
        )
    }

    @Test
    fun test4() {
        abstractTest(
            F4()
        )
    }
}