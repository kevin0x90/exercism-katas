import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Flattener {
    public List<Object> flatten(final Collection<Object> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .flatMap(this::flattenElement)
                .collect(Collectors.toUnmodifiableList());
    }

    private Stream<? extends Object> flattenElement(final Object element) {
        return element instanceof Collection<?>
                ? flatten((Collection<Object>) element).stream()
                : Stream.of(element);
    }
}