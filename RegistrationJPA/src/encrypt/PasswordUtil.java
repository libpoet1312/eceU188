package encrypt;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;

/*
 * Using Argon2 tool for hashing passwords
 * 
 */

public final class PasswordUtil {

	private static Argon2 init() {
		Argon2 argon2 = Argon2Factory.create(Argon2Types.ARGON2id);
		return argon2;
	}

	public static String hash(char[] password) {
		String hash;
		Argon2 argon2 = null;

		try {
			argon2 = init();

			// Compute and return the hash
			// 4 iterations, 1 GB of memory, and 1 degrees of parallelism ( 1 CPU core #
			// change for more cores )
			hash = argon2.hash(4, 1024 * 1024, 1, password);
		} finally {
			// Clean the password from the memory
			if (argon2 != null) {
				argon2.wipeArray(password);
			}
		}

		return hash;
	}

	public static boolean Verify(String hash, char[] password) {

		Argon2 argon2 = null;
		boolean isMatching;

		try {

			argon2 = init();

			isMatching = argon2.verify(hash, password);

		} finally {
			// Clean the password from the memory
			if (argon2 != null) {
				argon2.wipeArray(password);
			}
		}

		return isMatching;
	}

}
