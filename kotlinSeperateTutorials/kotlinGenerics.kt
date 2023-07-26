fun main(){
    var list = (1..5).toList()

    var newList = list.customFilter(filterFunction(it % 2)) }

    for (value in newList){
        println(value)
    }
    var result = list.folder { integer, string ->
        31
    }
    println(result)
}

fun <T> List<T>.customFilter(filterFunction: (T) -> Boolean):List<T>{
    var intlist = mutableListOf<T>()

    for (it in this){

        if(filterFunction(it)){
            intlist.add(it)
        }
    }
    return intlist
}

fun <T: Number> List<T>.folder(foldlist: (T,String) -> (T)):Int{
    var result1 = 1
    for (result in this ){
         
        result1 *= result.toInt()
    }
    return result1
}