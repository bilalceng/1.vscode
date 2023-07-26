
class temp{
   
fun feature1(number:(Int) -> Unit){
    progress(number)
}

fun progress(number:(Int) -> Unit){
  for (i in 1 until 10 step 2) {
      number(8)
      progress2(number)
  }
}

fun progress2(number:(Int) -> Unit){
    for (i in 7 downTo 1) {
        number(10)
    }
}
}

fun main(){
temp().feature1 { number ->
    when(number){

        10 -> println("the number is ten")
        9 -> println("the number is nine")
        8 -> println("the number is eight")
        7 -> println("the number is seven")
        6 -> println("the number is six")
        5 -> println("the number is five")
        4 -> println("the number is four")
        3 -> println("the number is three")
        else -> println("wrong number")
    }
}
}