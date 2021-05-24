object ETL {
    fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> = source
        .asSequence()
        .flatMap(::transformEntry)
        .toMap()
}

private fun transformEntry(entry: Map.Entry<Int, Collection<Char>>): Sequence<Pair<Char, Int>> =
    entry.value.asSequence().map { Pair(it.toLowerCase(), entry.key) }
