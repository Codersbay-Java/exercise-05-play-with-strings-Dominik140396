package application;

import java.util.Arrays;

public class PlayWithStrings {
	public static void main(String[] args) {
		System.out.println("Hello String World");
		printIntitials("Dominik", "Paschinger");
		System.out.println(areAnagrams("partial men", "p.arliament"));
		System.out.println(areAnagrams("a j u", "oihjpj"));
		System.out.println(isPalindrome("kayak"));



	}

	/**
	 * TODO: print initials
	 * Jeder String kann ein CharackterArray werden !!!!  Tipp von Lukas
	 * This method should print out the initials of a name to standard out.
	 * 
	 * @param firstname
	 * @param lastname
	 */
	public static void printIntitials(String firstname, String lastname) {
		String initials = firstname.substring(0,1) + " " + lastname.substring(0,1);
		System.out.println(initials);
	}

	/**
	 * TODO: check for anagrams
	 * 
	 * This method should determine if two strings are anagrams or not An anagram is
	 * a word or a phrase made by transposing the letters of another word or phrase.
	 * For example, "parliament" is an anagram of "partial men," and "software" is
	 * an anagram of "swear oft." The program should ignore white space and
	 * punctuation.
	 * 
	 * @param value1
	 * @param value2
	 * @return true if the values are anagrams, false otherwise.
	 */
	public static boolean areAnagrams(String value1, String value2) {
		value1 = value1.replaceAll("\\s", "").replaceAll("\\.", "");
		value2 = value2.replaceAll("\\s", "").replaceAll("\\.", "");

		if (value1.length() != value2.length())
			return false;

		char[] array1 = value1.toLowerCase().toCharArray();
		char[] array2 = value2.toLowerCase().toCharArray();

		Arrays.sort(array1);
		Arrays.sort(array2);

		return Arrays.equals(array1, array2);
	}

	/**
	 * TODO: palindrone checker
	 * 
	 * This method should find out if a string value is a palindrome or not. A
	 * palindrome is a sequence of characters (can also be a number) which reads the
	 * same backwards as forwards. Some palindromes are: Anna; wow; Eva can I see
	 * bees in a cave?
	 * 
	 * Upper or lower case should not matter, but keep the white spaces, tabs and
	 * punctuation in mind.
	 * 
	 * @param value
	 * @return true if it is a palindrome, false otherwise.
	 */
	public static boolean isPalindrome(String value) {
		for (int i = 0, j = value.length() - 1; i < j; i++, j--) {
			char startChar = value.charAt(i);
			char endChar = value.charAt(j);

			if (Character.isLowSurrogate(endChar)) {
				if (startChar != value.charAt(--j)) {
					return false;
				}
				if (value.charAt(++i) != endChar) {
					return false;
				}
			} else if (startChar != endChar) {
				return false;
			}
		}
		return true;
	}
}
