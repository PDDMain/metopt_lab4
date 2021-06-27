package method

import math.ScalarFunction
import math.solver.LUInPlaceSolver
import method.minimize.Brent


class DescentNewtonMethod: NewtonMethod {
    override fun iterationStep(
        function: ScalarFunction,
        prevPoint: MutableList<Double>,
        inaccuracy: Double
    ): List<List<Double>> {
        val solver = LUInPlaceSolver()

        val g = function.gradient(prevPoint);
        val h = function.hessian(prevPoint);
        val s = listOf(solver.solve(h, -g, inaccuracy));
        val d = if (s * g < 0) {
            s;
        } else {
            -g;
        }

        val r = Brent().minimize(function, prevPoint, d, inaccuracy);
        TODO("Not yet implemented\n" +
                "(*result.additional.rbegin())[\"foundParameter\"] =  r;\n" +
                "        return d * r;")
    }

    private operator fun <E> List<E>.times(g: E): Double {
        TODO("Not yet implemented")
    }
}
