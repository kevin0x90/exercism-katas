enum class Signal(val value: Int) {

    WINK(1), DOUBLE_BLINK(2), CLOSE_YOUR_EYES(4), JUMP(8);

    fun isSet(number: Int): Boolean = this.value and number == this.value
}
