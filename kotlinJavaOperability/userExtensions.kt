@file:JvmName("UserExtensions")

val User.fullName: String
    get() = "${this.firstName} ${this.lastName}"
 fun User.addressOfType(type: AddressType): Address?{
    return addresses?.firstOrNull{ address ->
        address.addressType == type }
}

fun User.addOrUpdateAddress(address: Address){
    val existingOfAddressType = addressOfType(address.addressType)
    if(existingOfAddressType != null){
        addresses?.remove(existingOfAddressType)
    }
    addresses?.add(address)
}

fun User.addValidCreditCard(creditCard: CreditCard){

    if(creditCards.isEmpty()){
        creditCards.add(creditCard)
        return
    }

    for (card in creditCards){
       println(creditCard.compareTo(card))
        println(CreditCard.isCreditValid(creditCard))
        if(creditCard.compareTo(card) && CreditCard.isCreditValid(creditCard)){
            println("burdayımla")
            creditCards?.add(creditCard)
            return
        }
    }
}
