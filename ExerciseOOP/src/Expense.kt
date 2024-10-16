import kotlin.math.*

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

        val a = sin(dLat / 2).pow(2.0) +
                cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(coordinate.latitude)) *
                sin(dLon / 2).pow(2.0)

        val c = 2 * atan2(sqrt(a), sqrt(1 - a))

        return radiusOfEarth * c
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

class Train(val locomotive: Locomotive, val wagons: HashSet<Wagon>) : Expense {
    private var startStation: Station? = null
    private var endStation: Station? = null

    fun getTrainType(): LocomotiveType {
        return locomotive.getType()
    }

    fun getTrainStartStation(): Station? {
        return startStation
    }

    fun getTrainEndStation(): Station? {
        return endStation
    }

    fun setStations(from: Station, to: Station) {
        startStation = from
        endStation = to
    }

    override fun calculate(): Double {
        val locomotivePrice = (locomotive.calculate() + locomotive.calculate() * wagons.size)

        val startCoordinate = startStation?.getStationCoordinate()
        val endCoordinate = endStation?.getStationCoordinate()

        if (startCoordinate != null && endCoordinate != null) {
            val distance = startCoordinate.getDistance(endCoordinate)
            return locomotivePrice * distance
        } else {
            return 0.0
        }
    }
}

