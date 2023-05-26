

class SimpleDate(var month: String, var day: Int = 0) {

    private val months = arrayOf("january","february", "march","april","may",
        "june","july","august","september", "october","november","december")

    private fun findIndex(): Int {
        return months.indexOf(month)
    }

    fun advance() {
        var index = findIndex()
    println(index)

        day += 1

        if (index >= 11) {
            index %= 11

        }

            if (day == 32 && (index % 2 == 0 || index == 7)) {

                day = 1
                month = months[index + 1]
            } else if (index == 1 && day == 29) {
                println("**")

                day = 1
                month = months[index + 1]

            } else if (day == 31 && (index % 2 == 1) && index != 7) {
                println("***")
                day = 1
                month = months[index + 1]
            }



    }
}

fun main(args: Array<String>) {
    val date = SimpleDate("august" ,29)
    date.advance()
    date.advance()
    date.advance()
    date.advance()
    date.advance()
    date.advance()
    date.advance()
    date.advance()

    println(date.month)
    println(date.day)


}