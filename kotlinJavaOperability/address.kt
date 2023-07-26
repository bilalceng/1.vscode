enum class AddressType {
    Billing,
    Shipping,
    Gift
}

 data class Address(
     val streetLine1: String,
     val streetLine2: String?,
     val city: String,
     val stateOrProvince: String,
     val postalCode: String,
     val addressType: AddressType,
     val country: String
 ){
     fun postalLabel(): String{
         var printAddress = streetLine1
         streetLine2?.let { printAddress + it }
         printAddress += "\n $city, $stateOrProvince  $postalCode"
         printAddress += "\n ${country.toUpperCase()}"
         return  printAddress
     }


     override fun toString(): String {
         return postalLabel()
     }


 }