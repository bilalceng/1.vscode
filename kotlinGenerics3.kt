
class CheapThing(val name: String): Checkable{
    override fun checkIsOk(): Boolean {
        return true
    }

    override fun toString(): String {
        return  name
    }

}

class BreakableThing(val name: String): Checkable{
    var isBroken = false

    fun smash(){
        this.isBroken = true
    }

    override fun checkIsOk(): Boolean {
        return !isBroken
    }

    override fun toString(): String {
        return name
    }

}

interface Checkable{
    fun checkIsOk(): Boolean
}

interface Container<T>{
    fun canAddAnotherItem(): Boolean
    fun addItem(item:T)

    fun removeAnotherItem(): Boolean
    fun removeItem(): T

    fun getAnother(): Container<T>

    fun contents(): List<T>

}

class CardBoardBox(): Container<BreakableThing>{

    private var items = mutableListOf<BreakableThing>()

    override fun canAddAnotherItem(): Boolean {
        return items.count() < 2
    }

    override fun removeAnotherItem(): Boolean {
        return items.isNotEmpty()
    }

    override fun removeItem(): BreakableThing {
      return items.removeAt(items.size - 1 )
    }

    override fun getAnother(): Container<BreakableThing> {
        return this
    }

    override fun contents(): List<BreakableThing> {
        return  items.toList()
    }

    override fun addItem(item: BreakableThing) {
        items.add(item)
    }

}

class Mover<T: Checkable>(
    thingsToMove: List<T>,
    var trucHeightInInches: Int = (12*12)
){
    private var thingsFailedToCheck = mutableListOf<T>()
    private var thingsLeftInOldPlace = mutableListOf<T>()
    private var thingsInTruck = mutableListOf<Any>()
    private var thingsInNewPlace = mutableListOf<T>()

    init {
        thingsLeftInOldPlace.addAll(thingsToMove)
    }

    fun moveEverythingToTruck(startingContainer: Container<T>?){
        var currentContainer = startingContainer
        while (thingsLeftInOldPlace.isNotEmpty()){

            val item = thingsLeftInOldPlace.removeAt(0)
            if (item.checkIsOk()) {

                if (currentContainer != null) {
                    if (!currentContainer.canAddAnotherItem()) {
                        moveContainerToTruck(currentContainer)
                        currentContainer = currentContainer.getAnother()
                    } else {
                        currentContainer.addItem(item)
                        println("your $item is packed.")
                    }
                } else {
                    thingsInTruck.add(item)
                    println("moved your $item to truck.")
                }
            } else{
                thingsFailedToCheck.add(item)
                println("this $item could not move to truck.")
            }
            currentContainer?.let { moveContainerToTruck(it) }
        }
    }

    fun moveContainerToTruck(container: Container<T>){
        thingsInTruck.add(container)
        println("moved a container with your ${container.contents().toBulletList()} ")
    }

    fun moveEverythingIntoNewPlace(){
        //val breakableThing = thingsInTruck.filterIsInstance<BreakableThing>()
        //val item = thingsInTruck.filterIsInstance<T>()
        val containerList = thingsInTruck.filterIsInstance<Container<T>>()

        for(container in containerList){
            thingsInTruck.remove(container)
            while(container.removeAnotherItem()){
                val itemInContainer = container.removeItem()
                println("Unpacked your $itemInContainer!")
                tryToMoveThingsInNewPlace(itemInContainer)
            }
        }
        while (thingsInTruck.isNotEmpty()){
            @Suppress("UNCHECKED_CAST")
            val item = thingsInTruck.removeAt(0) as? T
            if (item != null){
                    tryToMoveThingsInNewPlace(item)
            }else{
                println("Something in the truck was not of the expected generic type: $item")
            }

        }
    }
    
    fun finishTomMove() {
        println("Ok we finis to move your ${thingsInNewPlace.toBulletList()}")
        if (thingsFailedToCheck.isNotEmpty()) {
            println("but we need to talk about your ${thingsFailedToCheck.toBulletList()}")
        }
    }

    private fun tryToMoveThingsInNewPlace(item: T){
        if(item.checkIsOk()){
            thingsInNewPlace.add(item)
            println("Moved your $item into your new place!")
        }else{
            thingsFailedToCheck.add(item)
            println("Could not move your $item into your new place :[")
        }
    }

}

fun<T> List<T>.toBulletList(): String{
    val separator = "\n -"
    return this.joinToString(separator, prefix = separator, postfix = "\n") { "$it" }
}

fun main(){


    val cheapThingList = listOf(CheapThing("gardrop"),
        CheapThing("old couch"),
        CheapThing("refrigerator"),
        CheapThing("vase")
    )
    val cheapMover = Mover(cheapThingList)
    cheapMover.moveEverythingToTruck(null)
    cheapMover.moveEverythingIntoNewPlace()
    cheapMover.finishTomMove()

    val television = BreakableThing("television")

    val breakableThingList = listOf(BreakableThing("guitar"),
        television,
        BreakableThing("computer"),
        BreakableThing("Plates"),
        BreakableThing("glasses"))



    val expensiveMover = Mover(breakableThingList)
    television.smash()
    expensiveMover.moveEverythingToTruck(CardBoardBox())
    expensiveMover.moveEverythingIntoNewPlace()
    expensiveMover.finishTomMove()


}