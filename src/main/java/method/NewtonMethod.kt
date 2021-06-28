package method

import math.ScalarFunction
import math.matrix.Vector

abstract class NewtonMethod : MinimizeMethod {
    override fun minimize(
        function: ScalarFunction,
        startPoint: Vector,
        inaccuracy: Double
    ): Vector {
        var x = init(function, startPoint, inaccuracy)

        while (true) {
            val delta = iterationStep(function, x, inaccuracy)
            x += delta

            if (delta.norm() < inaccuracy)
                break
        }

        return x
    }

    abstract fun init(
        function: ScalarFunction,
        startPoint: Vector,
        inaccuracy: Double
    ): Vector

    abstract fun iterationStep(
        function: ScalarFunction,
        prevPoint: Vector,
        inaccuracy: Double
    ): Vector
}