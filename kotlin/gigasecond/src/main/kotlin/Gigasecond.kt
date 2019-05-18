import java.time.LocalDate
import java.time.LocalDateTime


class Gigasecond {
    private val GIGA_SECOND: Long = 1_000_000_000L
    private val localDateTime: LocalDateTime

    constructor(localDate: LocalDate) {
        localDateTime = localDate.atStartOfDay()
    }

    constructor(localDateTime: LocalDateTime) {
        this.localDateTime = localDateTime
    }

    private fun calculateGigaSecond() = localDateTime.plusSeconds(GIGA_SECOND)

    val date: LocalDateTime by lazy<LocalDateTime> { calculateGigaSecond() }
}