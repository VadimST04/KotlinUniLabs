fun main(args: Array<String>) {
    val pass1 = Passenger(null, "ABC123")
    val pass2 = Passenger("Tom", "GYH546")

    val passengers = listOf(
        Passenger("John Doe", "ABC123"),
        Passenger(null, "DEF456"),
        Passenger("Alice", null),
        Passenger(null, null)
    )

    for (pass in passengers) {
        if (pass.canTravel()) {
            println("Passenger $pass can travel")
        } else {
            println("This Passenger can not travel")
        }
    }
}