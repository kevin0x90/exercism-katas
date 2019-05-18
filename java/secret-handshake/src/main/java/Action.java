enum Action {
    REVERSE(16);

    public boolean isActionSet(final int number) {
        return (number & value) == value;
    }

    private final int value;

    Action(final int value) {
        this.value = value;
    }
}
