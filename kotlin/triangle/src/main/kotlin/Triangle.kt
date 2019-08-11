import kotlin.math.abs

class Triangle {
    private val numberOfDistinctSides: Int

    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    constructor(a: Double, b: Double, c: Double) {
        require(a >= 0.0 && b >= 0.0 && c >= 0.0) { "a, b and c must not be 0" }
        require(abs(a - b) < c && c < a + b) { "triangle inequality not fulfilled" }

        numberOfDistinctSides = listOf(a, b, c).distinct().size
    }

    val isEquilateral: Boolean
        get() = numberOfDistinctSides == 1

    val isIsosceles: Boolean
        get() = numberOfDistinctSides < 3

    val isScalene: Boolean
        get() = numberOfDistinctSides == 3
}