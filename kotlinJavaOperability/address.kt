import java.util.Locale.IsoCountryCode

enum class AddressType {
    Billing,
    Shipping,
    Gift
}

 data class Address @JvmOverloads constructor(
     @JvmField val streetLine1: String,
     @JvmField val streetLine2: String?,
     @JvmField val city: String,
     @JvmField val stateOrProvince: String,
     @JvmField val postalCode: String,
     @JvmField var addressType: AddressType,
     @JvmField val country:String = "Us"
 ){
        // You can replace second constructor or use @JvmOverloads annotation.
    /* constructor(
         streetLine1: String,
         streetLine2: String?,
         city: String,
         stateOrProvince: String,
         postalCode: String,
         addressType: AddressType
     ) : this(streetLine1, streetLine2, city, stateOrProvince, postalCode, addressType, "Us")*/

     fun postalLabel(): String{
         var printAddress = streetLine1
         streetLine2?.let { printAddress + it }
         printAddress += "\n $city, $stateOrProvince  $postalCode"
         printAddress += "\n ${country.toUpperCase()}"
         return  printAddress
     }

     object JSONKeys {
         const val streetLine1 = "street_1"
         const val streetLine2 = "street_2"
         const val city = "city"
         const val stateOrProvince = "state"
         const val postalCode = "zip"
         const val addressType = "type"
         const val country = "country"
     }

     companion object{


         const val street = "myStreet"
         @JvmStatic
         fun addCanadian(type: AddressType): Address{
             return Address(
                 "koram",
                 "koram2",
                 "batman",
                 "sason",
                 "2323232",
                 type,
                 "canada"
             )
         }
     }


     override fun toString(): String {
         return postalLabel()
     }

 }





