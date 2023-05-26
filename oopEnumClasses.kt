import java.util.Calendar

enum class DayOfTheWeek(val isWeekend:Boolean = false){
    
    monday,
    tuesday,
    wednesday,
    thursday,
    friday,
    saturday(true),
    sunday(true);

    fun daysUntil(other:DayOfTheWeek):Int{
        return if(ordinal > other.ordinal){
            ordinal - other.ordinal
        }
        else{
            other.ordinal - ordinal
        }
    }

    companion object{
        fun toDay():DayOfTheWeek{
            val calendarDayOfWeek  = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
             var adjustedDay = calendarDayOfWeek - 2
            val days  = DayOfTheWeek.values()
            println(days)
            if(adjustedDay < 0 ){
                adjustedDay += days.count()
            }

            val toDay = days.first{it.ordinal == adjustedDay}
            return toDay
        }
    }

    fun empty(satur:DayOfTheWeek){
        println(satur)
    }
    
}

 fun main(args: Array<String>) {
    for(day in DayOfTheWeek.values()){
        println("Day ${day.ordinal}: ${day.name} : ${day.isWeekend}")
    }

    val dayAtIndex = DayOfTheWeek.values()[0]
    println("$dayAtIndex")// sunday

    val saturday = DayOfTheWeek.valueOf("saturday")
    println(saturday.ordinal) // 6
    val count = DayOfTheWeek.values().count()
    println(count)//7

    val today = DayOfTheWeek.toDay()
    println(today) // tuesday

    val monday = DayOfTheWeek.valueOf("monday") 

    println(monday.daysUntil(saturday)) //5

    
    
    //val barnsday = DayOfTheWeek.valueOf("barnsday")Exception in thread "main" java.lang.IllegalArgumentException: No enum constant DayOfTheWeek.barnsday
	                                                //at java.base/java.lang.Enum.valueOf(Enum.java:240)
	                                                //at DayOfTheWeek.valueOf(oopEnumClasses.kt)
	                                                //at OopEnumClassesKt.main(oopEnumClasses.kt:23)
 when(today){
    DayOfTheWeek.monday -> println("today is $today")
    DayOfTheWeek.tuesday -> println("today is $today")
    DayOfTheWeek.wednesday -> println("today is $today")
    DayOfTheWeek.thursday -> println("today is $today")
    DayOfTheWeek.friday -> println("today is $today")
    DayOfTheWeek.saturday -> println("today is $today")
    DayOfTheWeek.sunday -> println("today is $today")
    else -> println("i do not know today")
 }
}