package elevator

case class Elevator(
 moving: Boolean = false,
 summoned: Boolean = false,
 currentFloor: Location,
 destinationFloor: Location
)