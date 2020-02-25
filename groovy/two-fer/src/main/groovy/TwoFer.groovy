class TwoFer {

    static String twoFer(String name) {
        def outputName = name == null || name.isAllWhitespace() ? 'you' : name

        "One for ${outputName}, one for me."
    }
}
