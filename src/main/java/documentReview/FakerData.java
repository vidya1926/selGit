package documentReview;

import java.sql.Driver;

import com.github.javafaker.Faker;

public class FakerData {

	public static void main(String[] args) {
		 
		
		
		Faker data=new Faker();
		
		System.out.println(data.address().streetAddress());
		System.out.println(data.internet().emailAddress());
	System.out.println(data.company().name());
		System.out.println(data.lorem().sentence(4));
	}

}
