enum Signal {
    WINK(1),
    DOUBLE_BLINK(2),
    CLOSE_YOUR_EYES(4),
    JUMP(8);

    public boolean isSignalSet(final int number) {
        return (number & value) == value;
    }

    private final int value;

    Signal(final int value) {
        this.value = value;
    }
}
