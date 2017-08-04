package arrays_dynamicprograms;

class PetrolPump {

	int petrol;
	int distance;

	PetrolPump(int petrol, int distance) {
		this.petrol = petrol;
		this.distance = distance;
	}

	// it may be +ve or -ve
	public int getExtraPetrol() {
		return petrol - distance;
	}

}

public class PetrolPumpTourProblem {
	
	public static int printTour(PetrolPump []pumps){
		
		int start = 0;
		int end   = 1;
		int currentPetrol = pumps[start].getExtraPetrol();
		while( start != end || currentPetrol < 0){
			
			//if current petrol is -ve then delete start petrol pump tour
			while( currentPetrol < 0  && start != end){
				System.out.println("===deleteing start pomp "+ start+ " petrol ="+currentPetrol);
				currentPetrol = currentPetrol - pumps[start].getExtraPetrol();
				start = (start +1)% pumps.length;
				if(start ==0){
					return -1;
				}
			}
			currentPetrol = currentPetrol + pumps[end].getExtraPetrol();
			end = (end +1)% pumps.length;
		}
		
		return start;
	}

	public static void main(String[] args) {

		PetrolPump [] pumps = {new PetrolPump(6, 4),
				new PetrolPump(3, 6),
				new PetrolPump(7, 3)};
		System.out.println(printTour(pumps));
	}

}
