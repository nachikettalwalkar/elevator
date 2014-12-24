import elevator.Location
import elevator.Person
import elevator.Elevator

object Main { 
	def main(args: Array[String]) = {
	    
	   val elevator = new Elevator(false,false,Location(0),Location(0))

 
	   def reachDestination(choice: Int, person:Person) = {
	   		println("*******************************************")
	   	    println("Enter the elevator")

	   	    choice match {
    			case x if x < person.currentFloor.floorNo => {
    				println("Elevator going down carrying a person")
    			}	
    			case x if x > person.currentFloor.floorNo => {
    				println("Elevator going up carrying a person")
    			}	
    			case x if x == person.currentFloor.floorNo => {
    				println("Elevator at the same floor - Door opening")
    			}	
			}

			elevator.currentFloor.floorNo = choice
 			println("You have reached the destination floor !")

 			elevator.destinationFloor.floorNo = choice
 			println("*******************************************")
 			println("*******************************************")
 			println("*******************************************")
			getNewPerson
	   }

       def callElevator(person: Person) {
			println("Elevator is at floor - "+ elevator.currentFloor.floorNo)

			person.currentFloor.floorNo match {
    			case x if x < elevator.currentFloor.floorNo => {
    				println("Elevator going down")
    			}	
    			case x if x > elevator.currentFloor.floorNo => {
    				println("Elevator going up")
    			}	
    			case x if x == elevator.currentFloor.floorNo => {
    				println("Elevator at the same floor - Door opening")
    			}	
			}

			elevator.currentFloor.floorNo = person.currentFloor.floorNo

			println("Door opening")
			println("Currently elevator and you are at floor - "+elevator.currentFloor.floorNo)
			println("Which floor you want to go ? (0-5) where 0 = basement and 5 = Penthouse: ")
        	var choice = readInt
        	println("You want to go to floor No. - " + choice)
        	println("*******************************************")
        	if(choice == 5) {
        	  if(person.id == 2) {
        	  	println("You are trying to access a penthouse which is only accessible to Tenants,Landlords and emergency services. Please present a passcode to authorize")
        	    var passcode = readLine()	
        	    if(passcode == "password") {
        	      elevator.destinationFloor.floorNo = choice
    			  reachDestination(choice,person)
        	    }
        	  }else {
        	  	println("Entry prohibited ! 5th Floor is only accessible to Tenants and Landlords and emergency services")
        	  	getNewPerson
        	  }	
        	}else {
        		elevator.destinationFloor.floorNo = choice
    			reachDestination(choice,person)
        	}
        }

        def monitor(person: Person) = {
        	callElevator(person)
        }

        def getNewPerson = {
        	println("Please present your identification")
        	println("1. Guest")
        	println("2. Tenant")
        	var ln = readInt

        	println("On which floor are you currently ?")
        	var currPos = readInt

        	val person = new Person(ln,Location(currPos))
        	println("*******************************************")

        	println("Your current position is "+ person.currentFloor.floorNo)

	    	monitor(person)
        }

        getNewPerson
	}
}