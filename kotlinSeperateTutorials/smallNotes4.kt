


fun List<Int>.product():Int{
    var result  = 1
    for(value in this){
        result  = value * result

    }
    return result
}

fun main(){
var list1 = listOf(1,2,3,4,5)
var result = list1.product()
println(result)


}


