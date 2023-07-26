


open class Person(var name:String, var surname:String){
     open fun fullName():String = "$name $surname"
      

}

data class Grades(var letter:Char ,
                var points:Double ,
                var credits:Double)

open class Student( name:String,    surname:String, 
            var grades:MutableList<Grades> = mutableListOf<Grades>()):Person(name,surname){

                open fun recorGrades(grade:Grades){
                    grades.add(grade)
                }
            }

class BandMember(  name:String ,  surname:String):Student(name, surname){
    val minimumPracticeTime:Int
    get(){return 2}

   
    }

    class PhoneBookName(var person:Person){
        val names:String
        get() = "${person.surname}, ${person.name}"
    }

    fun forClass(student:Student){
        println("did you do your homework")
    }

    fun forClass(person:Person){
        println("How is your day")
    }

 fun main(args: Array<String>) {
  
    var John  = Student("John","Appleseed")
    var Jane =  Person("Jane", "Appleseed")
    var kelly = BandMember("kelly", "Jhonson")
    
   
  
    var History = Grades('A',90.0,2.0)
    John.recorGrades(History)
  
    //Jane.recordGrades(History) jane is a person and there is no method recordGrades in person class.


    println(John.fullName())
    println(Jane.fullName())
    println(kelly.fullName())

    val bandMember = PhoneBookName(kelly)
    val person = PhoneBookName(Jane)

    println(bandMember.names)
    println(person.names)

    var hallMonitor = BandMember("jill", "Bananapeel")
    println(hallMonitor !is Student) // is  and !is is used for hierarcical check for inheritance.
    println(hallMonitor is Person) 

    var alex = BandMember("Alex","De Souza")
    
    (alex as Student).recorGrades(History)

   

    val gitarist = BandMember("john","sina") // when we use directly gitarist for our functıon parameter the compiler choose most special one.

    forClass(gitarist as Person)

  

}