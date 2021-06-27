package method

import math.ScalarFunction

interface NewtonMethod {
    fun iterationStep(
        function: ScalarFunction,
        prevPoint: MutableList<Double>,
        inaccuracy: Double
    ): List<List<Double>>

    operator fun MutableList<Double>.unaryMinus(): MutableList<Double> {
        return this.map { x -> -x } as MutableList<Double>
    }

}