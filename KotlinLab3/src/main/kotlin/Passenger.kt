class Passenger(private val name: String?, private val ticket: String?) {
    fun canTravel(): Boolean {
        return !name.isNullOrEmpty() && !ticket.isNullOrEmpty()
    }

    override fun toString(): String {
        return "Passenger(name=$name, ticket=$ticket)"
    }

}