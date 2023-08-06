

fun main(){

    val user = User()

    user.firstName = "bilal"
    user.lastName = "berek"
    user.country = "Turkey"
    user.city = "Batman"





    val billingAddress = Address("123 fake street",
        "4th floor",
        "los Angeles0",
                "CA",
        "90265",
        AddressType.Billing,
        "united states"
        )

    val shippingAddress = Address("987 Unreal Drive",
        null,
        "Burbank",
        "CA",
        "91523",
        AddressType.Shipping,
        "united states")
    user.addOrUpdateAddress(shippingAddress)


    printLabelFor(user)

    val list = mutableListOf("bilal")
    list.add("zeynep")

    val scores = mutableMapOf("Eric" to 9, "Mark" to 12, "Wayne" to 1)
    scores["esteban"] = 3
    scores["lily"] = 3



    for ((key,value) in scores ){
        println("$key, $value")
    }

    var anotherUser = User()

    anotherUser.addresses?.let { println(it.count()) }

}