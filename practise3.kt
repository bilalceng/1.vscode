
val months = arrayOf("january","februry", "march","april","may",
"june","july","august","semptember", "october","november","december")

class SimpleDate(var month: String, var day: Int = 0) {
    var counter = 0
fun findIndex():Int{
   

   do{
  
    counter += 1
   }while(months[counter] == month)
       
    println("****$counter")
    println("****$month")
    return counter
}
   
fun advance() {
    var index = findIndex()
  

day += 1

if(index > 11){
    index = index % 11
}
if(day == 32 && (index % 2 == 0 || index == 7) ){
    day = 1
    month = months[index + 1] 
}else if(index == 1 && day == 29){

    day = 1
    month = months[index + 1]

}else if(day == 31 && (index % 2 == 1) && index != 7){
    day = 1
    month = months[index + 1]
}
 

}
}

 fun main(args: Array<String>) {
    val date = SimpleDate("december",29)
   date.advance()
   date.advance()
   date.advance()
   
   println(date.month)
   println(date.day)
 

}