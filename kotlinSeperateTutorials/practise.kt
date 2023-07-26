
fun Int.comparator(other:Int){
when(true){
    other > this -> println("$other is bigger one")
    this > other -> println("$this is bigger one")
    this == other -> println("$other and $this is equal")
}
}

fun Int.evenNumberInterval(){
    for(i in 2..this step 2){
        println(i)
    }
}


fun main(){
    16.comparator(89)
    12.comparator(12)
    39.evenNumberInterval()
}