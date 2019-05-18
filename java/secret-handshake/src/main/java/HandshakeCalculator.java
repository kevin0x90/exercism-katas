import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class HandshakeCalculator {
    List<Signal> calculateHandshake(final int number) {
        return Stream.of(Signal.values())
                .filter(signal -> signal.isSignalSet(number))
                .sorted(getSignalSortOrder(number))
                .collect(Collectors.toList());
    }

    private static Comparator<? super Signal> getSignalSortOrder(final int number) {
        return Action.REVERSE.isActionSet(number)
                ? Comparator.reverseOrder()
                : Comparator.naturalOrder();
    }
}
