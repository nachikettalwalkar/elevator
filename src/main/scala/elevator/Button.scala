package elevator

case class Button (

)

object Button {
	def buttonPressed(pressed: Boolean) = {if(pressed) false else true}
}