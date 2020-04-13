import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Flattener {
    public List<Object> flatten(final Collection<Object> list) {
        return list.stream()
                .flatMap(this::flattenElement)
                .collect(Collectors.toUnmodifiableList());
    }

    private Stream<? extends Object> flattenElement(final Object element) {
        if (!(element instanceof Collection<?>)) {
            return Stream.ofNullable(element);
        }

        return ((Collection<?>) element).stream()
                .filter(Objects::nonNull)
                .flatMap(this::flattenElement);
    }
}