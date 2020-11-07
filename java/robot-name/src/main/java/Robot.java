import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

class Robot {
    private static final Set<String> GENERATED_NAMES = ConcurrentHashMap.newKeySet();
    private static final char CHAR_START = 'A';
    private static final char CHAR_END = 'Z';

    private String name;

    public Robot() {
        generateName();
    }

    public String getName() {
        return name;
    }

    public void reset() {
        GENERATED_NAMES.remove(name);
        generateName();
    }

    private void generateName() {
        String generatedName;
        do {
            final var result = new StringBuilder();

            for (int i = 0; i < 2; ++i) {
                result.append(generateChar());
            }

            for (int i = 0; i < 3; ++i) {
                result.append(ThreadLocalRandom.current().nextInt(10));
            }

            generatedName = result.toString();
        } while (GENERATED_NAMES.contains(generatedName));

        name = generatedName;
        GENERATED_NAMES.add(name);
    }

    private char generateChar() {
        return (char) ((ThreadLocalRandom.current().nextInt(CHAR_END - CHAR_START + 1) + CHAR_START));
    }
}