class SecretHandshake {

    private static boolean hasBitPattern(final int number, final int bits) {
        (number & bits) == bits
    }

    private static String mapBitsToCommand(final int number, final int bits, final String command) {
        hasBitPattern(number, bits) ? command : null
    }

    static List<String> commands(final int number) {
        List<String> result = [] as List<String>

        result += mapBitsToCommand(number, 0b1, 'wink') ?: [] as List<String>
        result += mapBitsToCommand(number, 0b10, 'double blink') ?: [] as List<String>
        result += mapBitsToCommand(number, 0b100, 'close your eyes') ?: [] as List<String>
        result += mapBitsToCommand(number, 0b1000, 'jump') ?: [] as List<String>

        return hasBitPattern(number, 0b10000)
                ? result.<String> reverse()
                : result as List<String>
    }
}
