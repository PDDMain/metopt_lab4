package math

import math.matrix.DenseMatrix
import math.matrix.Vector

abstract class ScalarFunction {
    abstract fun gradient(point: Vector): Vector
    abstract fun hessian(point: Vector): DenseMatrix
    abstract fun calc(vector: Vector) : Double
}
