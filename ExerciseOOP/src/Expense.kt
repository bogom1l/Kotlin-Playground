import kotlin.math.pow

interface Expense {
    fun calculate(): Double
}

enum class LocomotiveType {
    STEAM, ELECTRIC, DIESEL
}

abstract class Locomotive : Expense {
    abstract fun getType(): LocomotiveType
}

class ElectricLocomotive : Locomotive() {
    override fun getType(): LocomotiveType {
        return LocomotiveType.ELECTRIC
    }

    override fun calculate(): Double {
        return 7.0
    }
}

class SteamLocomotive : Locomotive() {
    override fun getType(): LocomotiveType {
        return LocomotiveType.STEAM
    }

    override fun calculate(): Double {
        return 9.6
    }
}

class DieselLocomotive : Locomotive() {
    override fun getType(): LocomotiveType {
        return LocomotiveType.DIESEL
    }

    override fun calculate(): Double {
        return 8.5
    }
}

enum class WagonType {
    FREIGHT, PASSENGER
}

abstract class Wagon {
    abstract fun getType(): WagonType
}

class PassengerWagon : Wagon() {
    override fun getType(): WagonType {
        return WagonType.PASSENGER
    }
}

class FreightWagon : Wagon() {
    override fun getType(): WagonType {
        return WagonType.FREIGHT
    }
}

class Town(val name: String, val postalCode: String) {
    //getName() returns error?
    fun getTrainName(): String {
        return name
    }

    fun getTrainPostalCode(): String {
        return postalCode
    }
}

class Coordinate(val longitude: Double, val latitude: Double) {
    private val radiusOfEarth: Double = 6371.0

    fun getDistance(coordinate: Coordinate): Double {
        val dLon = Math.toRadians(coordinate.longitude - longitude)
        val dLat = Math.toRadians(coordinate.latitude - latitude)

        val a = Math.sin(dLat / 2).pow(2.0) +
                Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(coordinate.latitude)) *
                Math.sin(dLon / 2).pow(2.0)

        val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
        return radiusOfEarth * c // Distance in kilometers
    }
}

class Station(val name: String, val town: Town, val coordinate: Coordinate) {
    fun getStationName(): String {
        return name
    }

    fun getStationTown(): Town {
        return town
    }

    fun getStationCoordinate(): Coordinate {
        return coordinate
    }
}

// Class for Train
class Train(val locomotive: Locomotive, val wagons: HashSet<Wagon>) : Expense {
    lateinit var startStation: Station
    lateinit var endStation: Station

    fun getTrainType(): LocomotiveType {
        return locomotive.getType()
    }

    fun getTrainStartStation(): Station {
        return startStation
    }

    fun getTrainEndStation(): Station {
        return endStation
    }

    fun setStations(from: Station, to: Station) {
        startStation = from
        endStation = to
    }

    override fun calculate(): Double {
        return locomotive.calculate() + wagons.size * 1.5 // Example calculation, assuming each wagon adds to the cost
    }
}

