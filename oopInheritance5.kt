data class Privilege(val id:Int , val name:String)


open class User(val userName:String, private val id:String ,protected val age:Int){}

var counter = 0

class PrivilegedUser(userName:String, id:String , age:Int):User(userName, id, age){
    private val privileges:MutableList<Privilege> = mutableListOf<Privilege>()
    
    
    
    var increaseCounter:() -> Int = {
        counter += 1
        counter
    }

    init{
        println(increaseCounter())
    }
     

    fun addPrivilege(privile:Privilege){
        privileges.add(privile)
    }

    fun hasPrivelege(id:Int){
        privileges.map{ it.id }.contains(id)
    }

    fun about():String{
        return "$userName , $age"
    }

 /*   
    companion object{

        var counter:Int = 0
    fun numberOfPrivileges():() -> Int{
           var increaseCounter:() -> Int = {
            counter += 1
            counter
        }
    
        return increaseCounter
    }
}*/
    
}

 fun main(args: Array<String>) {
    val privilegedUser = PrivilegedUser(userName = "sashinka", id = "1234", age = 21)
    val privilegedUser1 = PrivilegedUser(userName = "sashinka", id = "1234", age = 21)
    val privilegedUser2 = PrivilegedUser(userName = "sashinka", id = "1234", age = 21)
    val privilegedUser3 = PrivilegedUser(userName = "sashinka", id = "1234", age = 21)
    
    val privilege = Privilege(1, "invisibility")
    
    privilegedUser.addPrivilege(privilege)
    
    println(privilegedUser.about()) 

      val info: String = PrivilegedUser("bilal", "1234", 23).about()
      println(info)

   /*  var counter1 = PrivilegedUser.numberOfPrivileges()
    println(counter1())
    println(counter1())
    println(counter1())
*/

}