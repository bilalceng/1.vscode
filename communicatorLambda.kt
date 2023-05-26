class Trial {
    var bilal: String = ""
      lateinit var onListAdded: (() -> Unit)

    fun feature(){
       onListAdded.invoke()

    }
}

fun main(){
    val trial1 = Trial()
    trial1.onListAdded = {
        println("bilal")
    }

    for(i in 1..10){
        trial1.feature()
    }
}