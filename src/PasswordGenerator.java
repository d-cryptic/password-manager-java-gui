// This class provides a cryptographically strong random number generator (RNG).
import java.security.SecureRandom;

public class PasswordGenerator {

	// The static keyword means the value is the same for every instance of the class. 
	// The final keyword means once the variable is assigned a value it can never be changed. 
	// The combination of static final in Java is how to create a constant value.

	// private is a Java keyword which declares a member's access as private. 
	// That is, the member is only visible within the class, not from any other class (including subclasses). 
	// The visibility of private members extends to nested classes.


	private static final SecureRandom random = new SecureRandom();
    private static final String caps="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String small_caps="abcdefghijklmnopqrstuvwxyz";
    private static final String Numeric="1234567890";
    private static final String special_char="~!@#$%^&*(_+{}|:_[?]>=<";
	private static final String dic = caps + small_caps + Numeric + special_char;
	

	public String generatePassword(int len) {

		// Java StringBuilder class is used to create mutable (modifiable) String. 
		// The Java StringBuilder class is same as StringBuffer class except that it is non-synchronized.

		StringBuilder password= new StringBuilder();
        for (int i = 0; i <len ; i++) {
            int index = random.nextInt(dic.length());
            password.append(dic.charAt(index));
        }
        return password.toString();
    }
}
