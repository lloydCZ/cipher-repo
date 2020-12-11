package cz.spring.cipher.caesar;

import cz.spring.cipher.ICipher;
import cz.spring.cipher.util.Constants;

/**
 * Class encoding / decoding caesar cipher
 *
 */
public class CaesarCipher implements ICipher {

    // key to caesar cipher
    private int offset;

    public CaesarCipher(int offset) {
        this.offset = offset;
    }

    /**
     * Open text to caesar cipher
     * @param openText
     * @return null if text is not between A-Z
     */
    //
    public String encode(String openText) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < openText.length(); i++) {
            char c = openText.charAt(i);
            if (c < 65 || c > 90) {
                return null;
            }
            char encodeSign = c + offset > 90 ? (char)((c + offset) - Constants.EN_ALPHABET_SIZE) : (char)(c + offset);
            result.append(encodeSign);
        }

        return result.toString();
    }


    /**
     * Decoded encrypted text to open text
     * @param encryptedText
     * @return
     */
    public String decode(String encryptedText) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < encryptedText.length(); i++) {
            char c = encryptedText.charAt(i);
            if (c < 65 || c > 90) {
                return null;
            }
            char decodeCign = c - offset < 65 ? (char)((c - offset) + Constants.EN_ALPHABET_SIZE) : (char)(c - offset);
            builder.append(decodeCign);
        }
        return builder.toString();
    }


}
