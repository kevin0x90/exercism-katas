class Triangle {
    private val a: Double
    private val b: Double
    private val c: Double

    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    constructor(a: Double, b: Double, c: Double) {
        require(a != 0.0 && b != 0.0 && c != 0.0) { "a, b and c must not be 0" }
        require(a + b > c && a + c > b && b + c > a) { "triangle inequality not fulfilled" }

        this.a = a
        this.b = b
        this.c = c
    }

    val isEquilateral: Boolean
        get() = a == b && b == c

    val isIsosceles: Boolean
        get() = a == b || a == c || b == c

    val isScalene: Boolean
        get() = a != b && a != c && b != c
}