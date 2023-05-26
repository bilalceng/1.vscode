import kotlin.math.PI


class Circle(var radius:Double){
    var area:Double
    get():Double{
        
        return field
    }
    set(value){
     value = radius * this.growth(3) * radius * PI
     field = value
    }

    fun growth( factor:Int):Int{
       
        return factor
    }


}

fun  main(args: Array<String>) {
    val circle =  Circle(3.0)
    circle.growth(3)
    println(circle.area)

    
    
}