package documentReview;


class Car extends Vehicle {
    void startEngine() { 		    	
        System.out.println("Car engine started with key ignition.");
    }

    void stopEngine() {
        System.out.println("Car engine stopped.");
    }
    
    
    public static void main(String[] args) {
	 
    	Car maruthi =new Car();
    	maruthi.displayDetails();
    	maruthi.startEngine();
    	maruthi.stopEngine();
    	
	}
    
}
	
	

