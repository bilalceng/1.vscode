
fun <T> List<T>.toBulletList():String{
    return this.joinToString("\n -> ", prefix = "\n -> ") { it.toString() }
}

interface Checkable{
    fun checkIsOk(): Boolean
}


interface Container<T> {
    fun canAddAnotherItem(): Boolean
    fun addItem(item: T)
    fun canRemoveAnotherItem(): Boolean
    fun removeItem():T
    fun getAnother(): Container<T>
    fun contents():List<T>
}

class CardBoardBox: Container<BreakableThing>{

    private var items = mutableListOf<BreakableThing>()
    override fun canAddAnotherItem(): Boolean {
        return items.count() < 2
    }

    override fun canRemoveAnotherItem(): Boolean {
        return items.isNotEmpty()
    }

    override fun removeItem(): BreakableThing {
       var lastItem = items.last()
        items.remove(lastItem)
        return lastItem
    }

    override fun getAnother(): Container<BreakableThing> {
        return CardBoardBox()
    }

    override fun contents(): List<BreakableThing> {
       return items.toList()
    }

    override fun addItem(item: BreakableThing) {
        items.add(item)
    }

}

class CheapThing(private var name: String): Checkable{
    override fun checkIsOk() :Boolean {
        return false
    }

    override fun toString(): String {
        return name
    }
}

class BreakableThing(
    var name: String,
    var isBroken: Boolean = false
): Checkable{
    fun smash(){
        isBroken = true
    }

    override fun checkIsOk(): Boolean {
        return  isBroken
    }

    override fun toString(): String {
        return name
    }
}

class Mover<T: Checkable>(
    private var thingsToMove: List<T>,
    val truckHeightInInches: Int = (12*12)
){
    private var thingsLeftInOldPlace = mutableListOf<T>()
    private var thingsInTruck:MutableList<Any> = mutableListOf()
    private var thingsInNewPlace = mutableListOf<T>()
    private var thingsFailedToCheck = mutableListOf<T>()

    init {
        thingsLeftInOldPlace.addAll(thingsToMove)
    }

    fun moveEverythingToTruck(startingContainer: Container<T>?){
        var currentContainer = startingContainer

        while(thingsLeftInOldPlace.isNotEmpty()){

            val item = thingsLeftInOldPlace.removeAt(0)
                    if (item.checkIsOk()){
                        println("we cannot move your $item to truck")
                        thingsFailedToCheck.add(item)
                    }else{
                        if (currentContainer != null){
                            if (!currentContainer.canAddAnotherItem()){
                                moveContainerToTruck(currentContainer)
                                currentContainer = currentContainer.getAnother()
                            }
                            currentContainer.addItem(item)
                            println("packed your item $item")
                        }
                        else{
                            thingsInTruck.add(item)
                            println("we move your $item to truck")
                        }

                    }

            }
            currentContainer?.let {
                moveContainerToTruck(it)
            }
            }


    fun moveEverythingToNewPlace(){
        while (thingsInTruck.isNotEmpty()){
            val containers = thingsInTruck.filterIsInstance<Container<*>>()
            for(container in containers){
                thingsInTruck.remove(container)
                while (container.canRemoveAnotherItem()){
                    val itemInContainer = container.removeItem()
                    println("Unpacked your $itemInContainer!")
                    tryToMoveEverythingIntoNewPlace(itemInContainer as T)
                }
            }

            while (thingsInTruck.isNotEmpty()) {
                @Suppress("UNCHECKED_CAST")
                val item = thingsInTruck.removeAt(0) as? T
                if (item != null) {
                    tryToMoveEverythingIntoNewPlace(item)
                } else {
                    println("Something in the truck was not of the expected generic type: $item")
                }
            }

        }
    }

     fun moveContainerToTruck(container: Container<T>){
            thingsInTruck.add(container)
         println("moved the container with your ${container.contents().toBulletList()} to the truck ")

    }

    fun tryToMoveEverythingIntoNewPlace(item:T){
        if (item.checkIsOk()){
            println("we cannot move your $item to newPlace")
            thingsFailedToCheck.add(item)
        }else{
            thingsInNewPlace.add(item)
            println("we move your $item to newPlace")
        }
    }

    fun finishMove(){
        println("we are able to move your: ${thingsInNewPlace.toBulletList()}")
        if (thingsFailedToCheck.isNotEmpty()){
            println("but we need to talk abut your items : ${thingsFailedToCheck.toBulletList()}")
        }
    }
}
fun main(){
    var cheapThings = mutableListOf<CheapThing>(
        CheapThing("an old desk"),
        CheapThing("an ugly couch"),
        CheapThing("a worthless painting")
        )

    var mover = Mover<CheapThing>(cheapThings)
    mover.moveEverythingToTruck(null)
    mover.moveEverythingToNewPlace()
    mover.finishMove()

    var smartTv = BreakableThing("a smart TV")
    smartTv.smash()

    var breakableThing = mutableListOf<BreakableThing>(
        smartTv,
        BreakableThing("an new desk"),
        BreakableThing("a antic painting")
    )

    var expensiveMover = Mover<BreakableThing>(breakableThing)
    expensiveMover.moveEverythingToTruck(CardBoardBox())
    expensiveMover.moveEverythingToNewPlace()
    expensiveMover.finishMove()

    val hello = { println("hello") }
    hello.invoke()


}