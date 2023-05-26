
open class Person(var name:String, var surname:String){
    open fun fullName():String = "$name $surname"
     

}

data class Grades(var letter:Char ,
               var points:Double ,
               var credits:Double)

open class Student( name:String = "noName",    surname:String = "noSurname", 
           var grades:MutableList<Grades> = mutableListOf<Grades>()):Person(name,surname){

               open fun recordGrades(grade:Grades){
                   grades.add(grade)
               }
           }

class BandMember(  name:String ,  surname:String):Student(name, surname){
   val minimumPracticeTime:Int
   get(){return 2}

  
   }

class studentBaseballPlayer(name : String , surname:String , var position:Int , var number:Int , var battingAverage:String):StudentAthlete(name , surname){
    override fun recordGrades(grade:Grades){
        super.recordGrades(grade)
    }
}

open class StudentAthlete(name:String , surname:String):Student(name, surname){
    val failedClasses:MutableList<Grades> = mutableListOf()
    override fun recordGrades(grade:Grades){
        super.recordGrades(grade)

        if(grade.letter == 'F'){
            failedClasses.add(grade)
        }
      
    }

    val isEligible:Boolean
    get() = failedClasses.size < 3
}



 fun main(args: Array<String>) {

    var history = Grades('F',20.0, 2.0)
    var science = Grades('F',23.0, 3.0)
    var math = Grades('F',22.0, 1.0)
    var pe = Grades('B',78.0, 5.0)

    val Dom = StudentAthlete("Domie", "Dick")

    Dom.recordGrades(history)
    Dom.recordGrades(science)
    Dom.recordGrades(math)
    Dom.recordGrades(pe)

    println(Dom.isEligible)

    for(i in (Dom as Student).grades){
        println(i)
    }

    for(i in Dom.grades){
        println(i)
    }

    val Gina = Student("Gina", "Steinbeck")
    for(i in Gina.grades){
        println(i)
    }
    val student1 = Student()
    println(student1.name)
    println(student1.surname)
}
