package api.utility.data;
import java.util.Random;
import com.github.javafaker.Faker;


public class GenerateData {
	
	
	public static String addressGenerator(String input) {

        Faker faker = new Faker();

        String output ="";

        if(input.equalsIgnoreCase("countryV")) {
            output = "United States";
        }else if(input.equalsIgnoreCase("fullnameValue")) {
            output = faker.name().fullName();
        }else if(input.equalsIgnoreCase("PhoneV")){
            output = faker.phoneNumber().cellPhone();
        }else if(input.equalsIgnoreCase("stAddress")) {
            output = faker.address().streetAddress();
        }else if(input.equalsIgnoreCase("aptValue")) {
            output = faker.address().secondaryAddress();
        }else if(input.equalsIgnoreCase("cityValue")) {
            output = faker.address().city();
        }else if(input.equalsIgnoreCase("stateValue")) {
            output = faker.address().state();
        }else if(input.equalsIgnoreCase("zipCodeValue")) {
            String zipcode = faker.address().zipCode().substring(0,5);
            output = zipcode;
        }
        return output;

    }
	
	

	

	    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    private static final String NUMBERS = "0123456789";
	    
	    public static String generateLicensePlate() {
	        Random random = new Random();
	        
	        StringBuilder licensePlate = new StringBuilder();
	        
	        // Generate three random letters
	        for (int i = 0; i < 3; i++) {
	            licensePlate.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
	        }
	        
	        // Generate three random numbers
	        for (int i = 0; i < 3; i++) {
	            licensePlate.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
	        }
	        
	        return licensePlate.toString();
	    }

	    

	
	
	public static String getEmail() {
		String prefix = "Mohamed";
		String provider = "@tekschool.us";		
		int random = (int) (Math.random() * 10000);
		String email = prefix + random + provider; 
		return email;
	}
	
	/**
	 * Generate Random Phone number 10 digit
	 * @return String random phone number
	 * If you can improve it to better solution do it 
	 * 20 Minute break
	 */
//	public static String getPhoneNumber() {
//		String phoneNumber = "9";
//		for (int i = 0; i < 9 ; i ++) {
//			phoneNumber += (int) (Math.random() * 10);
//		}
//		return phoneNumber;
//	}


	
	
	
	
	    public static String RandomPhoneNumber() {
	        String phoneNumber = "";

	        int areaCode = (int) (Math.random() * 800) + 200; // Generate area code between 200 and 999
	        phoneNumber += areaCode;

	        for (int i = 0; i < 7; i++) { // 3 area code + 7 phone number
	            int phoneNumberDigit = (int) (Math.random() * 10);
	            phoneNumber += phoneNumberDigit;
	        }

	        return phoneNumber;
	    }

	    public static void main(String[] args) {
	        System.out.println("Phone Number: " + RandomPhoneNumber());
	    }
	}


	



	
	   