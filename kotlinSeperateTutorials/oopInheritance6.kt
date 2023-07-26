open class A(var name:String){
   open var relatedWithA:String  = "bilal"
   get() = field
   set(value){
    field = value
   }
   open var relatedWithATwo:String = "23";
  
    
    init{
        println("I am <A>")

    }
}

open class B(name:String):A(name){
   override var relatedWithA:String = "balcik"
   A.relatedWithA
    init{
        println("I am <B>")
        
    }
}

open class C(name:String):B(name){
    init{
        println("I am <C>")
        
    }
}

 fun main(args: Array<String>) {
   val  cObject = C("bilal")


}