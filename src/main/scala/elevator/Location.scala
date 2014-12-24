package elevator

case class Location(
  var floorNo: Int
)

object Location {
  def getDoor: Boolean = Door.openDoor(true)
  def getButton: Boolean = Button.buttonPressed(true)
  def getLocation: Location = Location(0)
}