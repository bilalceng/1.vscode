abstract class Mamal(val birthDay:String){
    abstract fun comsumeFood()
}

class Human(birthDay:String):Mamal(birthDay){
    override fun comsumeFood(){

    }
    
    fun createBirthCertificate(){

    }
}



sealed class Shape{
    class Circle(var radius:Double):Shape()
    class Rectangle(var height:Double, var width:Double):Shape()
    class Square(var side:Double):Shape(){

        fun volume():Double{
            return side*side*side
        }
    }
}




fun findShape(shape:Shape){

    

    when(shape){
        is Shape.Circle -> println("the area of circle is: ${3.14 * shape.radius * shape.radius}")
        is Shape.Rectangle -> println("the area of rectangle is: ${shape.height * shape.width}")
        is Shape.Square -> println("the area of square is: ${shape.side*shape.side}")
    }

}

 fun main(args: Array<String>) {
   
    var shape1 = Shape.Circle(2.0)
    var shape2 = Shape.Rectangle(5.0,4.0)
    var shape3 = Shape.Square(6.0) 
    println(shape3.volume())

    findShape(shape1)

    //val mamal1 = Mamal("22/10/1998"); we can not create a instsnce of abstract classes.
    val human1 = Human("22/10/1998");
}