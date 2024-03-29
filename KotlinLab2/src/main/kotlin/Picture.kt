import java.time.LocalDate

class Picture(author: String, date: LocalDate, private val width: Double, private val height: Double) :
    Composition(author, date) {
    fun isSquare(): Boolean {
        return width == height
    }

    override fun toString(): String {
        return "Composition(author='$author', dateOfCreated=$dateOfCreated)\n" +
                "Picture(width=$width, height=$height)"
    }

}