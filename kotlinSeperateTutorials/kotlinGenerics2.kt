

fun main(){
    var yourList = mutableListOf("bilal", 2, 5.0)
    val myList = mutableListOf("first", "second", "third")
    println(myList.toBulletList())
    println(yourList.toBulletList())


}
// the first below function is uselles for various of type list beacause it just  takes  string type collection.



/*fun List<String>.toBulletList(): String{
    val separator = "\n ->  "
    return this.map { "$it" }.joinToString(separator, prefix =
    separator, postfix = "\n")
}*/

 
// thanks to generic we can extand entrance type of list extension function.
fun <T> List<T>.toBulletList(): String{
    val separator = "\n ->  "
    return this.map { "$it" }.joinToString(separator, prefix =
    separator, postfix = "\n")
}
