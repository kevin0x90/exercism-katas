import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond {

    private static GIGA_SECOND_DURATION = Duration.ofSeconds(1_000_000_000)

    static LocalDateTime add(final LocalDate localDate) {
        add(LocalDateTime.of(localDate.year, localDate.month, localDate.dayOfMonth, 0, 0, 0))
    }

    static LocalDateTime add(final LocalDateTime localDateTime) {
        localDateTime + GIGA_SECOND_DURATION
    }
}
