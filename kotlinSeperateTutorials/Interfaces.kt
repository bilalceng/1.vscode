interface MyinterfaceListener{ // you can not create instance of abstract class. And we can not add constructor to the interfaces.
    var name:String // properties in inetrface is already abstract and public.

    fun onClick(){ //normal methods is not final by deafault . they are public and open by default

    }

    fun onTouch()//normal methods without body are public and abstract by deafult so you must implement at derived class.
}

 // normal classes are public and final by default.

class Button: MyinterfaceListener{
    override var name: String
        get() = ""
        set(value) {}

    override fun onTouch() {

    }

    override fun onClick() {
        super.onClick()
    }

}


abstract class MyabstractClass(var feature:String){
    var surname:String= ""
    abstract var name:String //abstarct properties can not have initializers.
    init{
        println("the most common feauter is $feature")
    }

    abstract fun Empty():Unit //abstract methods can not have a body.


}

fun main(args: Array<String>) {
    // var object1 = MyabstractClass("flying") we can not create an instance of abstarct class.
    var mybtn = Button()
    mybtn.onTouch()
    val myinterfaceListener: MyinterfaceListener? = null
    

    //interfaces are not the class.
}