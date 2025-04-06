/*
Problem:

Write a function named first_non_repeating_letter† that takes a string input, and returns the first character that is not repeated anywhere in the string.

For example, if given the input 'stress', the function should return 't', since the letter t only occurs once in the string, and occurs first in the string.

As an added challenge, upper- and lowercase letters are considered the same character, but the function should return the correct case for the initial letter.
For example, the input 'sTreSS' should return 'T'.

If a string contains all repeating characters, it should return an empty string ("");

Note: the function is called firstNonRepeatingLetter for historical reasons, but your function should handle any Unicode character.
 */

import java.util.*;

class FirstNonRepeatChar {
    public static void main(String[] args) {
        String input1 = "stress";
        String input2 = "sTreSS";
        String input3 = "";

        System.out.println("First non-repeating character " + input1 + ": " + firstNonRepeatingLetter(input1));
        System.out.println("First non-repeating character " + input2 + ": " + firstNonRepeatingLetter(input2));
        System.out.println("First non-repeating character  " + input3 + ": " + firstNonRepeatingLetter(input3));
    }

    // my solution
    public static String firstNonRepeatingLetter(String input) {
        if (input == null || input.isEmpty()) {
            return ""; // Return empty string if input is null or empty
        }

        LinkedHashMap<Character, Integer> charCountMap = new LinkedHashMap<>();

        // Populate the map ignoring case but storing actual case
        for (char ch : input.toCharArray()) {
            char lowerCh = Character.toLowerCase(ch); // Process in lowercase
            charCountMap.put(lowerCh, charCountMap.getOrDefault(lowerCh, 0) + 1);
        }

        // Find the first non-repeating letter
        for (char ch : input.toCharArray()) {
            char lowerCh = Character.toLowerCase(ch); // Compare in lowercase
            if (charCountMap.get(lowerCh) == 1) {
                return String.valueOf(ch); // Return the character in its original case
            }
        }

        return ""; // Return empty string if all characters are repeating
    }

/*
    // Logic: check if the first index and last index of that character if they are the same then return the character
    public static String firstNonRepeatingLetter(String s) {
        for (String str : s.split("")) {
            if (s.toUpperCase().indexOf(str.toUpperCase()) == s.toUpperCase().lastIndexOf(str.toUpperCase()))
                return str;
        }
        return "";
    }

    // this is chatGTP for the checking unicode characters
    public static String firstNonRepeatingLetter(String input) {
        if (input == null || input.isEmpty()) {
            return ""; // Return empty string for null or empty input
        }

        LinkedHashMap<Integer, Integer> charCountMap = new LinkedHashMap<>();

        // Populate the map ignoring case but handling Unicode characters
        for (int i = 0; i < input.length(); i++) {
            int codePoint = Character.toLowerCase(input.codePointAt(i)); // Unicode code point
            charCountMap.put(codePoint, charCountMap.getOrDefault(codePoint, 0) + 1);
        }

        // Find the first non-repeating letter
        for (int i = 0; i < input.length(); i++) {
            int codePoint = Character.toLowerCase(input.codePointAt(i)); // Unicode code point
            if (charCountMap.get(codePoint) == 1) {
                return new String(Character.toChars(input.codePointAt(i))); // Preserve original case
            }
        }

        return ""; // Return empty string if no non-repeating character is found
    }
*/

}

