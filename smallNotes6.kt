fun main(){
    var list = (1..5).toList()

    var newList = list.customFilter { it % 2 == 0 }

    for (value in newList){
        println(value)
    }
    var result = list.folder { integer, string ->
        31
    }
    println(result)
}

fun List<Int>.customFilter(filterFunction: (Int) -> Boolean):List<Int>{
    var intlist = mutableListOf<Int>()

  for (it in this){

      if(filterFunction(it)){
          intlist.add(it)
      }
  }
    return intlist
}

fun List<Int>.folder(foldlist: (Int,String) -> (Int)):Int{
    var result1 = 1
    for (result in this ){
        result1 *= result
    }
    return result1
}