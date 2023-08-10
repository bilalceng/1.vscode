import java.util.*



inline fun someFunction(  crossinline body: () -> Unit) {
    yetAnotherFunction {
        body()
    }
}
fun yetAnotherFunction( body: () -> Unit) {
}
class Robot(val name: String){
    private var random: Random = Random()
    var strength = 0
    private var health = 100
    var isAlive = true

    init{
        strength = random.generateRandomStrength()
        report("Created (strength: $strength)")
    }

    fun report(message:String){
        println("$name: \t $message")
    }

    fun damage(damage: Int){
        var blocked = random.generateBlock()

        if(blocked){
            report("Blocked attack.")
            return
        }
        health -= damage
        report("$name take damage: -$damage remain: $health")

        if(health <= 0){
            isAlive = false
        }

    }

    fun attack(robot: Robot){
        var damage = Random().generateDamage(strength)
        robot.damage(damage)
    }


}

object  BattleField{
      fun beginBattle(firstRobot: Robot, secondRobot: Robot,reportWinner: (Robot) -> Unit ){
        var winner: Robot? = null
        battle(firstRobot,secondRobot)
        winner = if (firstRobot.isAlive.not()) secondRobot else firstRobot
        reportWinner(winner)
    }


    private fun battle(firstRobot: Robot,secondRobot: Robot){
        firstRobot.attack(secondRobot)
        if (secondRobot.isAlive.not()){
            return
        }
        secondRobot.attack(firstRobot)
        if (firstRobot.isAlive.not()){
            return
        }
        battle(firstRobot,secondRobot)
    }
}

fun main(){
    // 1 ) var reportWinner: (Robot) -> Unit = {it.report("win")}
    val firstRobot = Robot("Experimental Space Navigation Droid")
    val secondRobot = Robot("Extra-Terrestrial Air Safety Droid")
    //1 )BattleField.beginBattle(firstRobot, secondRobot , reportWinner)
    //0 ) BattleField.beginBattle(firstRobot, secondRobot , ::reportWinner)
  /* BattleField.beginBattle(firstRobot, secondRobot){
        report("win")
    }*/

    var reportWinner = fun(robot: Robot){
        robot.report("win")
    }
    BattleField.beginBattle(firstRobot, secondRobot, reportWinner)

    yetAnotherFunction {
        println("bilal")
        return@yetAnotherFunction
    }

    //calculateEven()
}
/*
0 )fun reportWinner(winner: Robot){
    winner.report("win")
}*/

fun Random.generateRandomStrength(): Int{
    return   Random().nextInt(100) + 10
}
fun Random.generateBlock(): Boolean{
    return Random().nextBoolean()
}

fun Random.generateDamage(strength: Int): Int{
    return (strength * 0.1 + nextInt(10)).toInt()
}



fun calculateEven1() {
    var result = 0
    (0..20).forEach {
        if (it % 3 == 0) return
        if (it % 2 == 0) result += it
    }
    println(result)
}


fun calculateEven2() {
    var result = 0
    (0..20).forEach {
        if (it % 3 == 0) return@forEach
        if (it % 2 == 0) result += it
    }
    println(result)
}

fun calculateEven3() {
    var result = 0
    (0..20).forEach loop@{
        if (it % 3 == 0) return@loop
        if (it % 2 == 0) result += it
    }
}


fun calculateEven4() {
    var result = 0
    (0..20).forEach(fun(value) {
        if (value % 3 == 0) return
        if (value % 2 == 0) {
            result += value
            println(value)
        }

    })
    println(result)
}


    fun calculateEven5() {
    var result = 0
    (0..20).forEach {
        if (it % 3 == 0) return
        if (it % 2 == 0) result += it
    }
    println(result)
}
import java.util.*



inline fun someFunction(  crossinline body: () -> Unit) {
    yetAnotherFunction {
        body()
    }
}
fun yetAnotherFunction( body: () -> Unit) {
}
class Robot(val name: String){
    private var random: Random = Random()
    var strength = 0
    private var health = 100
    var isAlive = true

    init{
        strength = random.generateRandomStrength()
        report("Created (strength: $strength)")
    }

    fun report(message:String){
        println("$name: \t $message")
    }

    fun damage(damage: Int){
        var blocked = random.generateBlock()

        if(blocked){
            report("Blocked attack.")
            return
        }
        health -= damage
        report("$name take damage: -$damage remain: $health")

        if(health <= 0){
            isAlive = false
        }

    }

    infix fun attack(robot: Robot){
        var damage = Random().generateDamage(strength)
        robot.damage(damage)
    }


}

object  BattleField{
      fun beginBattle(firstRobot: Robot, secondRobot: Robot,reportWinner: (Robot) -> Unit ){
        var winner: Robot? = null
        battle(firstRobot,secondRobot)
        winner = if (firstRobot.isAlive.not()) secondRobot else firstRobot
        reportWinner(winner)
    }


    private fun battle(firstRobot: Robot,secondRobot: Robot){
        firstRobot attack secondRobot
        if (secondRobot.isAlive.not()){
            return
        }
        secondRobot attack firstRobot
        if (firstRobot.isAlive.not()){
            return
        }
        battle(firstRobot,secondRobot)
    }
}


fun main(){



    val participants = arrayListOf<Robot>(
        Robot("Extra-Terrestrial Neutralization Bot"),
        Robot("Generic Evasion Droid"),
        Robot("Self-Reliant War Management Device"),
        Robot("Advanced Nullification Android"),
        Robot("Rational Network Defense Droid"),
        Robot("Motorized Shepherd Cyborg"),
        Robot("Reactive Algorithm Entity"),
        Robot("Ultimate Safety Guard Golem"),
        Robot("Nuclear Processor Machine"),
        Robot("Preliminary Space Navigation Machine")
    )


    val topCategory = participants

        .filter { it.strength > 80 }

        .take(3)

        .sortedBy { it.name }




    // 1 ) var reportWinner: (Robot) -> Unit = {it.report("win")}
    val firstRobot = Robot("Experimental Space Navigation Droid")
    val secondRobot = Robot("Extra-Terrestrial Air Safety Droid")
    //1 )BattleField.beginBattle(firstRobot, secondRobot , reportWinner)
    //0 ) BattleField.beginBattle(firstRobot, secondRobot , ::reportWinner)
  /* BattleField.beginBattle(firstRobot, secondRobot){
        report("win")
    }*/

    var reportWinner = fun(robot: Robot){
        robot.report("win")
    }
    BattleField.beginBattle(firstRobot, secondRobot, reportWinner)

    yetAnotherFunction {
        println("bilal")
        return@yetAnotherFunction
    }

    //calculateEven()
}
/*
0 )fun reportWinner(winner: Robot){
    winner.report("win")
}*/

fun Random.generateRandomStrength(): Int{
    return   Random().nextInt(100) + 10
}
fun Random.generateBlock(): Boolean{
    return Random().nextBoolean()
}

fun Random.generateDamage(strength: Int): Int{
    return (strength * 0.1 + nextInt(10)).toInt()
}



fun calculateEven1() {
    var result = 0
    (0..20).forEach {
        if (it % 3 == 0) return
        if (it % 2 == 0) result += it
    }
    println(result)
}


fun calculateEven2() {
    var result = 0
    (0..20).forEach {
        if (it % 3 == 0) return@forEach
        if (it % 2 == 0) result += it
    }
    println(result)
}

fun calculateEven3() {
    var result = 0
    (0..20).forEach loop@{
        if (it % 3 == 0) return@loop
        if (it % 2 == 0) result += it
    }
}


fun calculateEven4() {
    var result = 0
    (0..20).forEach(fun(value) {
        if (value % 3 == 0) return
        if (value % 2 == 0) {
            result += value
            println(value)
        }

    })
    println(result)
}


    fun calculateEven5() {
    var result = 0
    (0..20).forEach {
        if (it % 3 == 0) return
        if (it % 2 == 0) result += it
    }
    println(result)
}

/*
tailrec fun recursive(){
    var counter = 0

    counter++
    if (counter == 6){
        return
    }
    recursive()
}

//its bytecode

public final class AnalyzeByteCodeKt {
   public static final void recursive() {
      int counter;
      do {
         counter = 0;
         ++counter;
      } while(counter != 6);

   }
}

fun recursive(){
    var counter = 0

    counter++
    if (counter == 6){
        return
    }
    recursive()
}

//its bytecode

public final class AnalyzeByteCodeKt {
   public static final void recursive() {
      int counter = 0;
      ++counter;
      if (counter != 6) {
         recursive();
      }
   }
}
*/












