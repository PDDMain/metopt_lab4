package method

import math.solver.LUInPlaceSolver
import math.ScalarFunction

class ClassicNewtonMethod : NewtonMethod{
    override fun iterationStep(
        function: ScalarFunction,
        prevPoint: MutableList<Double>,
        inaccuracy: Double
    ): List<List<Double>> {
        val solver = LUInPlaceSolver()

        val g = function.gradient(prevPoint)
        val h = function.hessian(prevPoint)

        return listOf(solver.solve(h, -g, inaccuracy))
    }


}