package HandshakeCalculator

import Signal

fun calculateHandshake(number: Int): List<Signal> = Signal.values()
        .filter { signal -> signal.isSet(number) }
        .sortedBy { signal -> signal.value * if (reverseSignals(number)) -1 else 1 }

private fun reverseSignals(number: Int): Boolean = (number and 16) == 16
