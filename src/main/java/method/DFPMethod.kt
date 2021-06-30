package method

import math.ScalarFunction
import math.matrix.DenseMatrix
import math.matrix.Vector
import math.matrix.identityMatrix
import math.solver.LUInPlaceSolver
import method.minimize.Brent

class DFPMethod : MinimizeMethod {
    override fun minimize(function: ScalarFunction, startPoint: Vector, inaccuracy: Double): Vector {
        TODO("Change BFG method to DFP method")
        val solver = LUInPlaceSolver()
        var x = startPoint.copy()

        var gX = function.gradient(x)
        var d = -gX
        val h = identityMatrix(x.size())
        var r = Brent().minimize(function, x, d, inaccuracy)
        var s = d * r

        while ((s.norm() > inaccuracy)) {
            r = Brent().minimize(function, x, d, inaccuracy)
            s = d * r

            x += s
            val gY = gX
            gX = function.gradient(x)
            val p = gX - gY
            val v = h * s

            val plusH = DenseMatrix(p * p)
            val minusH = DenseMatrix(v * v)

            h += plusH * (1.0 / (p.scalar(s)))
            h -= minusH * (1.0 / (v.scalar(s)))

            d = solver.solve(h, -gX, inaccuracy)
        }

        return x
    }
}