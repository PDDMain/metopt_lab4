package method

import math.solver.LUInPlaceSolver
import math.ScalarFunction
import math.matrix.Vector

class ClassicNewtonMethod : NewtonMethod {
    override fun iterationStep(
        function: ScalarFunction,
        prevPoint: Vector,
        inaccuracy: Double
    ): Vector {
        val solver = LUInPlaceSolver()

        val g = function.gradient(prevPoint)
        val h = function.hessian(prevPoint)

        return Vector(solver.solve(h, (-g).data(), inaccuracy))
    }
}