package method

import math.ScalarFunction
import math.matrix.Vector

interface NewtonMethod {
    fun iterationStep(
        function: ScalarFunction,
        prevPoint: Vector,
        inaccuracy: Double
    ): Vector
}