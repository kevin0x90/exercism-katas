import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;

class Gigasecond {

    private static final long GIGA_SECOND = 1_000_000_000;
    private final LocalDateTime birthDateTime;

    Gigasecond(final LocalDate birthDate) {
        requireNonNull(birthDate, "birthDate must not be null");
        birthDateTime = birthDate.atStartOfDay();
    }

    Gigasecond(final LocalDateTime birthDateTime) {
        this.birthDateTime = requireNonNull(birthDateTime, "birthDateTime must not be null");
    }

    LocalDateTime getDateTime() {
        return birthDateTime.plusSeconds(GIGA_SECOND);
    }

}
