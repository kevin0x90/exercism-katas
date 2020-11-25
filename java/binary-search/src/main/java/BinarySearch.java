import org.jetbrains.annotations.NotNull;

import java.util.List;

class BinarySearch {
    @NotNull
    private final List<Integer> elements;

    public BinarySearch(@NotNull final List<Integer> elements) {
        this.elements = elements;
    }

    public int indexOf(final int number) throws ValueNotFoundException {
        int rangeStartIndex = 0;
        int rangeEndIndex = this.elements.size() - 1;

        while (rangeStartIndex <= rangeEndIndex) {
            final int middle = rangeStartIndex + (rangeEndIndex - rangeStartIndex) / 2;
            final int middleElementValue = elements.get(middle);

            if (middleElementValue == number) {
                return middle;
            }

            if (number > middleElementValue) {
                // search right half
                rangeStartIndex = middle + 1;
            } else {
                // search left half
                rangeEndIndex = middle - 1;
            }
        }

        throw new ValueNotFoundException("Value not in array");
    }
}