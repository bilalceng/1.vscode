class SpaceCraft {
    private var isConnectionAvailable: Boolean = false
    private var isEngineInOrder: Boolean = false
    private var fuel: Int = 0
    var isInSpace: Boolean = false

    fun launch() {

        if (fuel < 5) {
            throw OutOfFuelException("Out of fuel. Can't take off")

        }
        if (!isEngineInOrder) {
           throw BrokenEngineException("The engine is broken. Can't take off")

        }
        if (!isConnectionAvailable) {
           throw SpaceToEarthConnectionFailedException("No connection with Earth. Can't take off")

        }

        sendMessageToEarth("Trying to launch...")
        fuel -= 5
        sendMessageToEarth("I'm in space!")
        sendMessageToEarth("I've found some extraterrestrials")
        isInSpace = true
    }

    fun refuel() {
        fuel += 5
        sendMessageToEarth("The fuel tank is filled.")
    }
    fun repairEngine() {
        isEngineInOrder = true
        sendMessageToEarth("The engine is in order.")
    }
    fun fixConnection() {
        isConnectionAvailable = true
        sendMessageToEarth("Hello Earth! Can you hear me?")
        sendMessageToEarth("Connection is established.")
    }
    fun land() {
        sendMessageToEarth("Landing...")
        isInSpace = false
    }
  fun sendMessageToEarth(message: String) {
        println("Spacecraft to Earth: $message")
    }
}

object SpacePort{
    fun investigateSpace(spaceCraft: SpaceCraft){
        try {
            spaceCraft.launch()
        } catch (exception: OutOfFuelException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.refuel()
        } catch (exception: BrokenEngineException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.repairEngine()
        } catch (exception: SpaceToEarthConnectionFailedException) {
            spaceCraft.sendMessageToEarth(exception.localizedMessage)
            spaceCraft.fixConnection()
        } finally {
            if (spaceCraft.isInSpace) {
                spaceCraft.land()
            } else {
                investigateSpace(spaceCraft)
            }
        }
    }
}

class OutOfFuelException(override var message: String):Exception(message)
class BrokenEngineException(override var message: String): Exception(message)
class SpaceToEarthConnectionFailedException(override var message: String) : Exception(message)

fun main(){
    var mySpaceCraft = SpaceCraft()
    SpacePort.investigateSpace(mySpaceCraft)
}