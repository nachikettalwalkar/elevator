import elevator.Location
import elevator.Person
import elevator.Elevator


object Main { 
	def main(args: Array[String]) = {
	    
	   val elevator1 = new Elevator(1,false,false,Location(0),Location(0))
       val elevator2 = new Elevator(2,false,false,Location(0),Location(0))

 
	   def reachDestination(choice: Int, person:Person, elevator:Elevator) = {
	   		println("*******************************************")
	   	    println("Enter the elevator")

	   	    choice match {
    			case x if x < person.currentFloor.floorNo => {
    				println("Elevator "+elevator.id+" going down carrying a person")
    			}	
    			case x if x > person.currentFloor.floorNo => {
    				println("Elevator "+elevator.id+" going up carrying a person")
    			}	
    			case x if x == person.currentFloor.floorNo => {
    				println("Elevator "+elevator.id+" at the same floor - Door opening")
    			}	
			}

			elevator.currentFloor.floorNo = choice
 			println("You have reached the destination floor !")

 			elevator.destinationFloor.floorNo = choice
 			println("*******************************************")
 			println("Elevator 1 is at floor - "+ elevator1.currentFloor.floorNo)
            println("Elevator 2 is at floor - "+ elevator2.currentFloor.floorNo)
 			println("*******************************************")
			getNewPerson
	   }

       def callElevator(person: Person, elevator: Elevator) {
            println("*******************************************")
			person.currentFloor.floorNo match {
    			case x if x < elevator.currentFloor.floorNo => {
    				println("Elevator "+elevator.id+" going down")
    			}	
    			case x if x > elevator.currentFloor.floorNo => {
    				println("Elevator "+elevator.id+" going up")
    			}	
    			case x if x == elevator.currentFloor.floorNo => {
    				println("Elevator "+elevator.id+" at the same floor - Door opening")
    			}	
			}

			elevator.currentFloor.floorNo = person.currentFloor.floorNo

			println("Door opening")
			println("Currently elevator "+elevator.id+ " and you are at floor - "+elevator.currentFloor.floorNo)
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
    			  reachDestination(choice,person,elevator)
        	    }
        	  }else {
        	  	println("Entry prohibited ! 5th Floor is only accessible to Tenants and Landlords and emergency services")
        	  	getNewPerson
        	  }	
        	}else {
        		elevator.destinationFloor.floorNo = choice
    			reachDestination(choice,person,elevator)
        	}
        }

        def prioritizeElevator(person: Person, elevatorList: List[Int]) = {

            def c(l:List[Int],n:Int)=l.sortWith((a,b)=>(a-n).abs<(b-n).abs)(0)
            c(elevatorList,person.currentFloor.floorNo)
        }

        def monitor(person: Person) = {
            println("Elevator 1 is at floor - "+ elevator1.currentFloor.floorNo)
            println("Elevator 2 is at floor - "+ elevator2.currentFloor.floorNo)
            println("Press button to call elevator [ Press 1 ] - ")
            var ln = readInt
            println(ln)
            if(ln == 1) {
                if(elevator1.currentFloor.floorNo == elevator2.currentFloor.floorNo) {
                    callElevator(person,elevator1)
                }else {
                    val elevatorList = List(elevator1.currentFloor.floorNo,elevator2.currentFloor.floorNo)
                    prioritizeElevator(person, elevatorList) match {
                        case x if x == elevator1.currentFloor.floorNo => {
                            callElevator(person,elevator1) 
                        }
                        case x if x == elevator2.currentFloor.floorNo => {
                            callElevator(person,elevator2)  
                        }
                    }
                }
            }
        }

        def getNewPerson = {
        	println("Please present your identification")
        	println("1. Guest")
        	println("2. Tenant")
        	var ln = readInt

        	println("Please provide your current floor location ?")
        	var currPos = readInt

        	val person = new Person(ln,Location(currPos))
        	println("*******************************************")

        	println("Your current position is floor - "+ person.currentFloor.floorNo)

	    	monitor(person)
        }

        getNewPerson
	}
}