package examples

import math.ScalarFunction
import math.matrix.DenseMatrix
import math.matrix.Vector
import kotlin.math.pow


class F1 : ScalarFunction() {
    override fun calc(vector: Vector): Double {
        val m1: Double = vector.data()[1] - vector.data()[0] * vector.data()[0]
        val m2: Double = 1.0 - vector.data()[0]
        return 100.0 * m1 * m1 + m2 * m2
    }

    override fun gradient(point: Vector): Vector {
        return Vector(
            listOf(
                -2.0 * (1.0 + -1.0 * point.data()[0]) +
                        -400.0 * point.data()[0] * (-1.0 * point.data()[0].pow(2.0) + point.data()[1]),
                200.0 * (-1.0 * point.data()[0].pow(2.0) + point.data()[1])
            )
        )
    }

    override fun hessian(point: Vector): DenseMatrix {
        return DenseMatrix(
            arrayListOf(
                arrayListOf(
                    2.0 + 800.0 * point.data()[0].pow(2.0) +
                            -400.0 * (-1.0 * point.data()[0].pow(2.0) + point.data()[1]),
                    -400.0 * point.data()[0]
                ),
                arrayListOf(-400.0 * point.data()[0], 200.0)
            )
        )
    }

}