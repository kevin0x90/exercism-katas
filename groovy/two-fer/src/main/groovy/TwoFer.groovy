import org.codehaus.groovy.util.StringUtil

class TwoFer {

    static String twoFer(String name) {
        "One for ${name?.trim() ?: 'you'}, one for me."
    }
}
