@file: JvmName("labelPrinter")

fun labelFor(user: User, type: AddressType): String{
    val address = user.addressOfType(type)
    if (address != null){
        var label = "_____\n"
        label += "${user.firstName} ${user.lastName}\n${address.postalLabel()}\n"
        label += "-----\n"
        return label
    }else{
        return "\n!! ${user.fullName} does not have a $type address set up !!\n"
    }

}

fun printLabelFor(user: User, type: AddressType){
   println(labelFor(user, type))
}