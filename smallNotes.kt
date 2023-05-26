
import java.util.*
import kotlin.concurrent.timerTask
import kotlin.system.exitProcess

fun empty(){
    println("yarrrak")
}

fun lambda1(multiply : (Int?) -> Unit){
multiply(null)
}


fun main() {
    var number: Int = 10
    when (number) {
        10-> exitProcess(1)
        4 -> exitProcess(0)
        else -> Timer().schedule(timerTask { empty() }, 2000)
    }
    println("yarrak")




    lambda1 {result ->

        when(result){
        null -> println("the number is null.")
        2 -> println("number is 2")
        10 -> println("number is 10")
        }
    }
}
