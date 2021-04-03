public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public void push(final T value) {
        if (isEmpty()) {
            addFirst(value);
            return;
        }

        tail.next = Node.tailNode(value, tail);
        tail = tail.next;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        final T value = tail.value;
        tail = tail.previous;

        if (tail != null) {
            tail.next = null;
        }

        return value;
    }

    public T shift() {
        if (isEmpty()) {
            return null;
        }

        final T value = head.value;
        head = head.next;

        if (head != null) {
            head.previous = null;
        }

        return value;
    }

    public void unshift(final T value) {
        if (isEmpty()) {
            addFirst(value);
            return;
        }

        head.previous = Node.headNode(value, head);
        head = head.previous;
    }

    private void addFirst(final T value) {
        head = Node.headNode(value, null);
        tail = head;
    }

    private boolean isEmpty() {
        return head == null || tail == null;
    }

    private static class Node<T> {

        private final T value;
        private Node<T> previous;
        private Node<T> next;

        private Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        private static <T> Node<T> tailNode(final T value, final Node<T> previous) {
            return new Node<>(value, previous, null);
        }

        private static <T> Node<T> headNode(final T value, final Node<T> next) {
            return new Node<>(value, null, next);
        }
    }
}