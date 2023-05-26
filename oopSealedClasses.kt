sealed class AcceptedCurrency{

    abstract fun empty():Boolean
    abstract val inDollars:Float
    abstract var name:String
    var amount = 0.0f

    class Dollar:AcceptedCurrency(){
        override fun empty():Boolean{
            return Dollar() is AcceptedCurrency
        }
        override var name:String = "Dollar"
        override val inDollars:Float = 1.0f
    }

    class Euro:AcceptedCurrency(){
        override fun empty():Boolean{
            return Euro() is AcceptedCurrency
        }
        override var name:String = "Euro"
        override val inDollars:Float = 1.2f
    }

    class Crypto:AcceptedCurrency(){
        override fun empty():Boolean{
            return Crypto() is AcceptedCurrency
        }
        override var name:String = "NerdCoin"
        override val inDollars:Float = 123.2f
    }

    fun convertAmount():Float{
        return inDollars * amount
    }
   

    // or you can just write this:
    // val name:String
    //   get() = when(this){
    //        is Dollar -> "Dollar"
    //       is Euro -> "Euro"
    //         is Crypto -> "nerdCoin"
    //  }
 
 
}

 fun main(args: Array<String>) {
    val currency = AcceptedCurrency.Crypto()
    println("you have got some ${currency.name}")

    println(currency.empty())
    
    currency.amount = 3.7534f
    println(currency.convertAmount())

}