import org.example.Decrypter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Jakob Silbereisen, Foconis Analytics GmbH
 */
public class DecrypterTest {

	@Test
	void testDecrypt() {
		String encryped = "&£aad ldga(";
		String decrypted = "hello world";

		Decrypter decrypter = new Decrypter();
		Assertions.assertEquals(decrypted, decrypter.decrypt(encryped));
	}

	@Test
	void testDecryptUnknownChar() {
		String encryped = "?!";

		Decrypter decrypter = new Decrypter();
		Assertions.assertThrows(IllegalArgumentException.class, () -> decrypter.decrypt(encryped));
	}

	@Test
	void testEncrypt() {
		String encryped = "&£aad ldga(";
		String decrypted = "hello world";

		Decrypter decrypter = new Decrypter();
		Assertions.assertEquals(encryped, decrypter.encrypt(decrypted));
	}

}
