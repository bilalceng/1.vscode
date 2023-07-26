enum class Direction{
    LEFT,RIGHT;
}

interface Vehicle{
    fun accelerate()
    fun stop()

}

interface WheeledVehicle: Vehicle{
    var numberOfWheels: Int
    var wheelSize: Double

}

class Bike(): WheeledVehicle{
    var peddling = false
    var breaking = false

    override var numberOfWheels: Int
        get() = 0
        set(value) {}
    override var wheelSize: Double
        get() = 0.0
        set(value) {}

    override fun accelerate() {
        peddling = true
        breaking = false
    }

    override fun stop() {
        peddling = false
        breaking = true
    }

}
interface SpaceVehicle{
    fun accelerate()

    fun stop(){
        println("Whoa, slow down!")
    }
}

class Lightfreighter():SpaceVehicle{
    override fun accelerate() {
        println("calm down!!")
    }

    override fun stop() {
        super.stop()
        println("please stop!")
    }

}

interface DirectionalVehicle{
    fun accelerate()
    fun stop()
    fun description(): String
}

interface OptionalDirectionVehicle{
    fun turn(direction: Direction = Direction.LEFT)
}

class Uniciycle: Vehicle{
    private var peddling = false

    override fun accelerate() {
        peddling = true
    }

    override fun stop() {
        peddling = false
    }

}

class OptionalDirection : OptionalDirectionVehicle {
    override fun turn(direction: Direction) {
        println(direction)
    }

}

interface vehiclePrperties{
    val weight: Int
    val name: String
        get() = "vehicle"
}

class Tank(): vehiclePrperties{
    override val weight = 500

}

interface sizedVehicle{
    val size: Double
}


class Boat(): sizedVehicle,Comparable<Boat>{
    override var size: Double = 0.0
        set(value) {
            field = value
        }
        get() = field

    override fun compareTo(other: Boat): Int {
        return when{
            other.size > size -> -1
            other.size == size -> 0
            other.size < size -> 1
            else -> 31
        }
    }

}

fun main(){
    var car = OptionalDirection()
    car.turn()
    car.turn(Direction.RIGHT)


    var lightfreighter = Lightfreighter()
    lightfreighter.stop()
    lightfreighter.accelerate()

    var qe2 = Boat()
    qe2.size = 1200.0

    var titanic = Boat()
    titanic.size = 1100.0

    println(qe2.size < titanic.size)

}