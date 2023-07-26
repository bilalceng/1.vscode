inline fun <reified T> myExample(name: T) {
    println("Name of your website -> "+name)
    println("Type of myClass: ${T::class.java}")
 }
 
 fun main() {
 
    // calling func() with String
    myExample("www.tutorialspoint.com")
 
    // calling func() with Int value
    myExample(100)
 
    // calling func() with Long value
    myExample(1L)

    
    val number: Number = 12
    val integer = 19

    println(number as? Int)
    println(number::class.java)

    println(integer as? Number)
    println(integer::class.java)

    var myList = mutableListOf<String>("bilal" ,"zeynep", "aleyna")
    println(myList.size)
    myList.removeAt(myList.size - 1)
    println(myList.size)

 
 }
 /*
Generic type parameters are erased at runtime, read about type erasure if you haven't already.
Reified type parameters on inline functions not only inline the method body,
but also the generic type parameter allowing you do to things like T::class.java (which you can't do with normal generic types).
Putting as a comment because I don't have time to flesh out a full answer right now.. */