package math.solver

import math.matrix.Matrix

interface Solver<T : Matrix> {

    fun solve(matrix: T, b: MutableList<Double>, eps: Double): List<Double>
}
