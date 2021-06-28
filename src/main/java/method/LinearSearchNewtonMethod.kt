package method

import math.ScalarFunction
import math.solver.LUInPlaceSolver
import method.minimize.Brent
import math.matrix.Vector

class LinearSearchNewtonMethod : NewtonMethod {
    override fun iterationStep(
        function: ScalarFunction,
        prevPoint: Vector,
        inaccuracy: Double
    ): Vector {
        val solver = LUInPlaceSolver()

        val g = function.gradient(prevPoint)
        val h = function.hessian(prevPoint)

        val d = Vector(solver.solve(h, (-g).data(), inaccuracy))

        val r = Brent().minimize(function, prevPoint, d, inaccuracy)

        return d * r
    }
}