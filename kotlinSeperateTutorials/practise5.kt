import java.lang.Math.pow
import kotlin.math.*

interface Area{
    val area: Double
}

 class Square(var side: Double): Area{
     override val area: Double
         get() = pow(side,2.0)

 }

class Triangle(var side1: Double , var side2: Double , var side3: Double): Area{
    override val area: Double
        get() {
            var averageSides = (side1 + side2 + side3 ) / 2
             var result = sqrt(averageSides * (side1 - averageSides) * (side2 - averageSides) * (side3 - averageSides))
            return result
        }
}

class Circle(var radius: Double): Area{
    override val area: Double
        get() = PI * radius * radius
}


fun main(){
    val triangle = Triangle(4.0,12.0,13.0)
    var circle = Circle(5.0)
    var square = Square(4.0)
    val arrayOfShapes: MutableList<Any?>? = mutableListOf()

    arrayOfShapes?.add(triangle.area)
    arrayOfShapes?.add(square.area)
    arrayOfShapes?.add(circle.area)

   val areas =  arrayOfShapes?.map { it }
    areas?.forEach { println(it) }
    
}