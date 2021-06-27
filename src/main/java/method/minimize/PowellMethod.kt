package method.minimize

import math.ScalarFunction
import math.matrix.DenseMatrix
import java.util.*

class PowellMethod {
    fun minimize(function: ScalarFunction, startPoint: MutableList<Double>, inaccuracy: Double) {
        val result = HypeOptimizationResult()

        var x = startPoint.map { x -> x } as MutableList<Double>
        var gX = function.gradient(x)
        val d = -gX
        val g = DenseMatrix(x.size)
        result.iterations.add(x)
        result.additional.emplace_back()
        ( * result.additional.rbegin())["result"] = f.compute(x)

        while (true) {
            val r = Brent().minimize(function, x, d, inaccuracy) as MutableList<Double>
            val s = d * r
            x = (x + s) as MutableList<Double>
            val gY = gX

            gX = function.gradient(x)
            val p = gX - gY
            val u = s - g * p
            g += DenseMatrix(u * u) * (1.0 / (u * p))
            val d = -Vector(g * gX)

            result.additional.emplace_back()
            ( * result.additional.rbegin())["result"] = f.compute(x)
            result.iterations.push_back(x)

            if (s.norm() < epsilon)
                break
        }
        result.result = x

        return result
    }
}
