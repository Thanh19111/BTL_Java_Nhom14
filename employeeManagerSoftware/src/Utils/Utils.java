package Utils;

public class Utils {
	public static String encrypt(String plaintext) {
		int shift = 12;
        StringBuilder cipherText = new StringBuilder();
        shift = shift % 26;

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                cipherText.append((char) ((c - base + shift + 26) % 26 + base));
            } else {
                cipherText.append(c);
            }
        }
        return cipherText.toString();
    }
	public static String decrypt(String ciphertext) {
		int shift = 12;
        StringBuilder plainText = new StringBuilder();
        shift = shift % 26;

        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                plainText.append((char) ((c - base - shift + 26) % 26 + base));
            } else {
                plainText.append(c);
            }
        }
        return plainText.toString();
    }
}
