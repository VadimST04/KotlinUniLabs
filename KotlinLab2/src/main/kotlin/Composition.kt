import java.time.LocalDate

open class Composition(protected val author: String, protected val dateOfCreated: LocalDate) {
    override fun toString(): String {
        return "Composition(author='$author', dateOfCreated=$dateOfCreated)"
    }
}