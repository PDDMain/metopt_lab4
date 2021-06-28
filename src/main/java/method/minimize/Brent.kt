package method.minimize

import math.ScalarFunction
import math.matrix.Vector

class Brent {
    fun minimize(
        function: ScalarFunction,
        x: Vector,
        d: Vector,
        inaccuracy: Double
    ): Double {
        return minimize({lambda : Double -> function.calc(x + d * lambda)}, 2 * inaccuracy)
    }

    private fun minimize(function: (Double) -> Double, x: Double): Double {
        TODO("add Brent method from lab1")
    }
}
