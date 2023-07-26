val months = arrayOf("january","februry", "march","april","may",
                    "june","july","august","semptember", "october","november","december")

class SimpleDate2(var month:String){
    fun monthsUntilWinterBreeak():Int{
    //fun monthsUntilWinterBreeak( from:SimpleDate2):Int{
           // return months.indexOf("december") - months.indexOf(from.month)
           return months.indexOf("december") - months.indexOf(this.month)
    }
}


fun  main(args: Array<String>) {
  val object_1 = SimpleDate2("march")
  //println(object_1.monthsUntilWinterBreeak(object_1))
  println(object_1.monthsUntilWinterBreeak())
}