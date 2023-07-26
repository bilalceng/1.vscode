
import java.util.*
import kotlin.concurrent.timerTask

fun trial(){
    println("yarrak")
var number:Int = 5
    when(number){
     10 -> println("number is ten")
        else -> Timer().schedule(timerTask { trial() },500)
    }

}

fun main(){
    trial()
}