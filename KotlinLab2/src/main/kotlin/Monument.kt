import java.time.LocalDate

class Monument(author: String, date: LocalDate, private val height: Double) :
    Composition(author, date) {
    override fun toString(): String {
        return "Composition(author='$author', dateOfCreated=$dateOfCreated)" +
        " Monument(height=$height)"
    }
}