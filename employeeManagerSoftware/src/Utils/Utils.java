package Utils;

import java.util.Iterator;

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
	public static String decrypt(String i) {
		int shift = 12;
        StringBuilder plainText = new StringBuilder();
        shift = shift % 26;

        for (char c : i.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                plainText.append((char) ((c - base - shift + 26) % 26 + base));
            } else {
                plainText.append(c);
            }
        }
        return plainText.toString();
    }
	public static String dateFormatorDMY(String sqldate)
	{
		String[] parts = sqldate.split("-");
		if(parts.length >= 3)
		{
			String resString = parts[2] + "-" + parts[1] + "-" + parts[0] ;
			return resString;
		}else {
			return null;
		}
	}
	public static String dateFormatorYDM(String date)
	{
		String[] parts = date.split("-");
		String resString = parts[2] + "-" + parts[1] + "-" + parts[0] ;
		return resString;
	}
	
}
