class Twofer {
    private static final String TWOFER_TEMPLATE = "One for {{name}}, one for me.";

    String twofer(final String name) {

        final var nameValue = isEmptyName(name)
                ? "you"
                : name;

        return TWOFER_TEMPLATE.replace("{{name}}", nameValue);
    }

    private boolean isEmptyName(final String name) {
        return name == null || name.trim().isEmpty();
    }
}
