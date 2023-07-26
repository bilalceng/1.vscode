
sealed class BabyGrowingLevel( var message: String){

    abstract  class GrowingLevelController{
       abstract fun handleGrowingLevel(babyGrowingLevel: BabyGrowingLevel, month: Int)
    }
      class Fetus(): BabyGrowingLevel("I am Fetus")
      class Middle():BabyGrowingLevel("I am at the Middle")
      class Last():BabyGrowingLevel("I am about to come")
      class Coming(): BabyGrowingLevel("I am coming !!!!!")
 }
 
 class Mother(var passedMonth: Int = 0, private var stomachLevel :Double= 0.0) {
     private var babyKicks: ((String) -> String)? = null
     private var stomachController: Boolean = false
 
     fun setKickListener(listener: ((String) -> String )){
         babyKicks = listener
     }
 
     fun growingLevel(): Int{
         passedMonth += 1
         return passedMonth
     }
 
     fun feedTheBaby(){
        stomachLevel += 10.0
 
         if (stomachLevel >= 72.0){
             stomachController = true
 
         }
     }
 
     inner class Baby{
         fun IWillKickYouMom(): String?{
              return  babyKicks?.invoke("I kicked you mom!!")
 
         }
 
         fun feeding(){
             this@Mother.feedTheBaby()
         }
 
         fun full(){
             if(this@Mother.stomachController){
                 println("I am full mom: $stomachLevel")
                 return
             }
             println("I am hungry")
         }
     }
 }
 
 fun main(){
 
     var lucy: Mother = Mother()
     lucy.feedTheBaby()
 
     var growingLevelController = object : BabyGrowingLevel.GrowingLevelController(){
         override fun handleGrowingLevel(babyGrowingLevel: BabyGrowingLevel, month: Int) {
             when(babyGrowingLevel){
 
                is BabyGrowingLevel.Fetus-> {
                     println("${babyGrowingLevel.message} month: $month ")
                 }
                 is BabyGrowingLevel.Middle -> {
                     println("${babyGrowingLevel.message} month: $month ")
                 }
                 is BabyGrowingLevel.Last -> {
                     println("${babyGrowingLevel.message} month: $month ")
                 }
                 is BabyGrowingLevel.Coming -> {
                     println("${babyGrowingLevel.message} month: $month ")
                 }
             }
         }
 
     }
 
     for (i in 0..9){
         lucy.growingLevel()
     }
 
     for(i in 0..9){
         lucy.Baby().feeding()
     }
 
     growingLevelController.handleGrowingLevel(controller(lucy),lucy.passedMonth)
 
 
       lucy.setKickListener { message ->
        message
     }
    var message =  lucy.Baby().IWillKickYouMom()
 
     println(message)
 
     lucy.Baby().full()
 
 }
 
 fun controller(lucy: Mother): BabyGrowingLevel{
     var babyGrowingLevel: BabyGrowingLevel? = null
 
     if (lucy.passedMonth in 0..2){
         babyGrowingLevel = BabyGrowingLevel.Fetus()
     }
     else if (lucy.passedMonth in 3..5){
         babyGrowingLevel = BabyGrowingLevel.Middle()
     }
     else if (lucy.passedMonth in 6 until 8){
         babyGrowingLevel = BabyGrowingLevel.Last()
     }
     else{
         babyGrowingLevel = BabyGrowingLevel.Coming()
     }
 
     return babyGrowingLevel
 }