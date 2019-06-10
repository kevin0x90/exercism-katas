import java.util.Optional;
import java.util.stream.IntStream;

class ReverseString {

    String reverse(final String inputString) {
        final int inputLength = Optional.ofNullable(inputString).orElse("").length();

        return IntStream.range(0, inputLength)
                .map(index -> inputLength - 1 - index)
                .mapToObj(index -> inputString.charAt(index))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

}