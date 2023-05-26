import kotlin.math.PI

open abstract class Shape(
    open var name:String  
){
    constructor(name: String, vararg parameters: Int) : this()

    fun changeName(newName:String){
        name =  newName
    }
    abstract fun area(): Double
}

class Circle(var radius: Double) : Shape() {
    //constructor(diameter: Double): this(diameter/2) you can not declare a constructor like this circle class confuse which one choose.
    constructor(radius: Int): this(radius.toDouble())
    constructor(number1: Int, number2: Int): this(number1.plus(number2).toDouble())
    override fun area(): Double{
        var Result: Double = PI * radius * radius
        return Result
    }
}

fun main() {
    val circle = Circle(10, 12)
    println(circle.name)
    circle.changeName("circle")
    println(circle.name)
    println(circle.area())

    val parallel = object : Shape("parallel", 10, 12, 3) {
        override fun area(): Double {
            return (10 * 12).toDouble()
        }


    }

    val anything = object{
        var name: String = "thing"
    }
    println( anything.name)
}