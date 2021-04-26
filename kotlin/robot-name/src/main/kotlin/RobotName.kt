import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ThreadLocalRandom

private fun generateRandomDigit() = ThreadLocalRandom.current().nextInt(10)
private fun generateRandomCharAtoZ() = (ThreadLocalRandom.current().nextInt('Z'.toInt() - 'A'.toInt() + 1) + 'A'.toInt()).toChar()

class Robot {

    companion object {
        private val GENERATED_NAMES = ConcurrentHashMap.newKeySet<String>()
    }

    private var memory: String = ""

    val name: String
        get() {
            if (memory.isNotEmpty()) {
                return memory
            }

            do {
                memory =
                    "${generateRandomCharAtoZ()}${generateRandomCharAtoZ()}${generateRandomDigit()}${generateRandomDigit()}${generateRandomDigit()}"
            } while (!GENERATED_NAMES.add(memory))

            return memory
        }

    fun reset() {
        GENERATED_NAMES.remove(memory)
        memory = ""
    }
}
