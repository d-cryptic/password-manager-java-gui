// This MessageDigest class provides applications the functionality of a message digest algorithm, such as SHA-1 or SHA-256. 
// Message digests are secure one-way hash functions that take arbitrary-sized data and output a fixed-length hash value.
import java.security.MessageDigest;

// This exception is thrown when a particular cryptographic algorithm is requested but is not available in the environment.
import java.security.NoSuchAlgorithmException;

import java.security.SecureRandom;


public class PasswordEncryption {
	public static String get_SHA_1_SecurePassword(String passwordToHash, byte[] salt) {

		// A byte is 8 bits (binary data).


		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(salt);
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder str = new StringBuilder();

			for (byte aByte : bytes) {
				str.append(Integer.toString((aByte & 0xfff) + 0x100, 16).substring(1));
			}
			generatedPassword = str.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return generatedPassword;
	}
	
	// adding salt in the password to make it more secure
	public static byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt;
	}
}
