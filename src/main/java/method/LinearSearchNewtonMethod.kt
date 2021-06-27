package method

import math.ScalarFunction
import math.solver.LUInPlaceSolver
import method.minimize.Brent

class LinearSearchNewtonMethod : NewtonMethod {
    override fun iterationStep(
        function: ScalarFunction,
        prevPoint: MutableList<Double>,
        inaccuracy: Double
    ): List<List<Double>> {
        val solver = LUInPlaceSolver()

        val g = function.gradient(prevPoint)
        val h = function.hessian(prevPoint)

        val d = listOf(solver.solve(h, -g, inaccuracy))

        val r = Brent().minimize(function, prevPoint, d, inaccuracy)

        TODO("Not yet implemented\ncpp code:\n(*result.additional.rbegin())[\"foundParameter\"] =  r;\n return d * r;")
    }
}