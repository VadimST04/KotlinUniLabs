import java.time.LocalDate

fun main(args: Array<String>) {
    val composition = Monument("Author", LocalDate.of(2002, 1, 1), 10.5)
    println(composition)
}