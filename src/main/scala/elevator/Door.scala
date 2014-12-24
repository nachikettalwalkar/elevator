package elevator

case class Door (
	
)

object Door {
	def openDoor(opened:Boolean): Boolean = { if(opened) false else true }
}