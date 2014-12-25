package elevator

case class Elevator(
 id:Int,	
 moving: Boolean = false,
 summoned: Boolean = false,
 currentFloor: Location,
 destinationFloor: Location
)