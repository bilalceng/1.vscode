class Person(var name:String , var surname:String ){
    val fullName:String
    get() = "$name $surname caciki"
}

class person constructor(var name:String , var surname:String){
    val fullName:String
    get() = "$name $surname"
}

open class Shape{
    constructor(size: Int) {
    println("first constructor worked")
    }
    constructor(size: Int, color: String):this(size) {
    println("second constructor worked")
    }
    }

    class Circle : Shape {
        constructor(size: Int) : super(size) {
         println("sub first constructor worked")
        }
        constructor(size: Int, color: String) : super(size, color) {
        println("sub second constructor worked")
        }
        }


        class Car(val carName: String) {
            inner class Engine(val engineName: String) {
            override fun toString(): String {
            return "$engineName in a $carName"
         
            }
            }
            }


fun main(args: Array<String>) {
    var ali = person("ali", "yavuz")
    var veli = Person("veli", "yavuz")

    println(ali.fullName)
    println(veli.fullName)

    val circle = Shape(20); 
    val square = Shape(200, "blue")
    println()
    
    var circle2 = Circle(12,"yellow")

   var  toyota = Car("toyota")
   var engineToyota = toyota.Engine("rotary")
   println(engineToyota)

}