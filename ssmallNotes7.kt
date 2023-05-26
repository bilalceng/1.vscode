
fun main(){
    var myList = (1 until 10).toList()

   var result =  myList.customSum { it -> it % 2 == 1 }
    println(result)

}

fun List<Int>.customSum(summation: (Int) -> (Boolean)): Int{
    var sum = 0
    for (value in this){
        if(summation(value)){
            sum += value
        }
    }
    return sum
}