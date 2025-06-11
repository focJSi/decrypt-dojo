package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jakob Silbereisen, Foconis Analytics GmbH
 */
public class Decrypter {

	private static final Map<Character, Character> DECRYPT_MAP = new HashMap<>();
	private static final Map<Character, Character> ENCRYPT_MAP = new HashMap<>();

	public Decrypter() {
		String letters = "abcdefghijklmnopqrstuvwxyz ";
		String symbols = "!)\"(£*%&><@abcdefghijklmno ";

		for (int i = 0; i < letters.length(); i++) {
			DECRYPT_MAP.put(symbols.charAt(i), letters.charAt(i));
			ENCRYPT_MAP.put(letters.charAt(i), symbols.charAt(i));
		}
	}

	public String decrypt(String encryped) {
		StringBuilder result = new StringBuilder();
		for (char c : encryped.toCharArray()) {
			Character translater = DECRYPT_MAP.get(c);
			if (translater != null) {
				result.append(translater);
			} else {
				throw new IllegalArgumentException("No translation for character " + c);
			}
		}
		return result.toString();
	}

	public String encrypt(String deprypted) {
		StringBuilder result = new StringBuilder();
		for (char c : deprypted.toCharArray()) {
			Character translater = ENCRYPT_MAP.get(c);
			if (translater != null) {
				result.append(translater);
			} else {
				throw new IllegalArgumentException("No translation for character " + c);
			}
		}
		return result.toString();
	}
}
