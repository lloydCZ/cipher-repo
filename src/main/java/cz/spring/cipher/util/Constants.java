package cz.spring.cipher.util;

import java.util.Map;

public class Constants {
    // text for valid input
    public static final String VALIDATE_SUCCESS = "VALIDATE_SUCCESS";

    // size of english alphabet
    public static final int EN_ALPHABET_SIZE = 26;

    // default morse code
    public static final String EN_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String[] MORSE_CHAR_EN_ALPHABET = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
            "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--.."};

    public static final String DELIMITER = "|";
    public static final String WORD_DELIMITER = "#";
    public static final String UNDEFINED = "?";
}
