@file:JvmName("UserExtensions")

val User.fullName: String
    get() = "${this.firstName} ${this.lastName}"+ " \n total addresses:${addresses.size}"
 fun User.addressOfType(type: AddressType): Address?{
    return addresses.firstOrNull{ address ->
        address.addressType == type }
}

fun User.addOrUpdateAddress(address: Address){
    val existingOfAddressType = addressOfType(address.addressType)
    if(existingOfAddressType != null){
        addresses.remove(existingOfAddressType)
    }
    addresses.add(address)
}