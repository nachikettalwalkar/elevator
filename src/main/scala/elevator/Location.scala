package elevator

case class Location(
  var floorNo: Int
)

object Location {
  def getDoor: Boolean = Door.openDoor(true)
  def pressButton(press:Boolean): Boolean = Button.buttonPressed(press)
  def getLocation: Location = Location(0)
}