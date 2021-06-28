package method

import math.ScalarFunction
import math.solver.LUInPlaceSolver
import method.minimize.Brent
import math.matrix.Vector


class DescentNewtonMethod : NewtonMethod {
    override fun iterationStep(
        function: ScalarFunction,
        prevPoint: Vector,
        inaccuracy: Double
    ): Vector {
        val solver = LUInPlaceSolver()

        val g = function.gradient(prevPoint)
        val h = function.hessian(prevPoint)

        val s = Vector(solver.solve(h, (-g).data(), inaccuracy))

        val d = if (s.scalar(g) < 0) {
            s
        } else {
            -g
        }

        val r = Brent().minimize(function, prevPoint, d, inaccuracy)

        return d * r
    }
}
