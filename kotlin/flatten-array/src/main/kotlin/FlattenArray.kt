object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> = source
            .flatMap { elem ->
                when (elem) {
                    is Collection<Any?> -> flatten(elem)
                    null -> listOf()
                    else -> listOf(elem)
                }
            }
}
