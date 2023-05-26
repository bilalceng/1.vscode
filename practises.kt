val months = arrayOf("january","februry", "march","april","may",
                    "june","july","august","semptember", "october","november","december")

class simpledata(var month:String){
    val monthsUntilWinterBreeak:Int
    get():Int{
        return months.indexOf("december") - months.indexOf(this.month)
    }
}

fun simpledata.monthsUntilSummerBreak():Int{    //extension function example.
    var monthIndex = months.indexOf(month)
    return if(monthIndex in 1..months.indexOf("june")){
            months.indexOf("june") - monthIndex
    }else if(monthIndex in months.indexOf("june")..months.indexOf("august")){
        return 0
    }else{
       12 - (monthIndex - months.indexOf("june"))
    }
}

fun main(){

   var object_1 = simpledata("april")
    println(object_1.monthsUntilWinterBreeak)
    println(object_1.monthsUntilSummerBreak())

}