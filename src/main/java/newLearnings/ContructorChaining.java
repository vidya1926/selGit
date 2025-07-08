package newLearnings;

public class ContructorChaining {

	int a;
		
	ContructorChaining(int b){
		this.a=b;
		System.out.println("From parametrized constructor");
	}
			
	ContructorChaining(){
		  this(10);
        System.out.println("From default constructor");
     

    }
	
	
	public static void main(String[] args) {
		ContructorChaining obj = new ContructorChaining();		

	}

}

//calling one constructor into another constructor is called constructor chaining
