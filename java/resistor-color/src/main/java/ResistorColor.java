import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

class ResistorColor {

    private static final Map<String, Integer> NAME_VALUE_MAPPING;

    static {
        final var colorValueMap = new LinkedHashMap<String, Integer>();
        colorValueMap.put("black", 0);
        colorValueMap.put("brown", 1);
        colorValueMap.put("red", 2);
        colorValueMap.put("orange", 3);
        colorValueMap.put("yellow", 4);
        colorValueMap.put("green", 5);
        colorValueMap.put("blue", 6);
        colorValueMap.put("violet", 7);
        colorValueMap.put("grey", 8);
        colorValueMap.put("white", 9);

        NAME_VALUE_MAPPING = Collections.unmodifiableMap(colorValueMap);
    }

    int colorCode(final String color) {
        Objects.requireNonNull(color, "color must not be null");

        return NAME_VALUE_MAPPING.getOrDefault(color.toLowerCase(), -1);
    }

    String[] colors() {
        return NAME_VALUE_MAPPING.keySet().toArray(new String[0]);
    }
}
