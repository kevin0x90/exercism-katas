public final class MaxValueWithIndex implements Comparable<MaxValueWithIndex> {
    private final int maxValue;
    private final int index;

    MaxValueWithIndex(final int maxValue, final int index) {
        this.maxValue = maxValue;
        this.index = index;
    }

    int getMaxValue() {
        return maxValue;
    }

    int getIndex() {
        return index;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (!(o instanceof MaxValueWithIndex)) {
            return false;
        }

        final var other = (MaxValueWithIndex) o;

        return index == other.index && maxValue == other.maxValue;
    }

    @Override
    public int hashCode() {
        return 31 + Integer.hashCode(maxValue) + Integer.hashCode(index);
    }

    @Override
    public int compareTo(final MaxValueWithIndex o) {
        final int comparison = Integer.compare(maxValue, o.maxValue);
        if (comparison == 0) {
            return Integer.compare(index, o.index);
        }

        return comparison;
    }

    @Override
    public String toString() {
        return String.format("MaxValueWithIndex [maxValue: %d, index: %d]", maxValue, index);
    }
}

