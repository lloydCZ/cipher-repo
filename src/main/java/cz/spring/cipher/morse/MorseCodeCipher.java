package cz.spring.cipher.morse;

import cz.spring.cipher.ICipher;
import cz.spring.cipher.model.CodeTableItem;
import cz.spring.cipher.util.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Class encoding / decoding morse code
 *
 */
public class MorseCodeCipher implements ICipher {

    // encoding map
    private Map<String, String> encodeMap = new HashMap<String, String>();
    // decoding map
    private Map<String, String> decodeMap = new HashMap<String, String>();

    public MorseCodeCipher() {
        fillMapsDefault();
    }

    // constructor for case if encode table is in DB
    public MorseCodeCipher(List<CodeTableItem> codeTable) {
        fillMapsDB(codeTable);

    }

    // fill map by constant
    private void fillMapsDefault() {
        for (int i = 0; i < Constants.EN_ALPHABET.length(); i++) {
            encodeMap.put(Character.toString(Constants.EN_ALPHABET.charAt(i)), Constants.MORSE_CHAR_EN_ALPHABET[i]);
            decodeMap.put(Constants.MORSE_CHAR_EN_ALPHABET[i], Character.toString(Constants.EN_ALPHABET.charAt(i)));
        }
    }

    // fill maps by DB values
    private void fillMapsDB(List<CodeTableItem> codeTable) {
        for (CodeTableItem cti : codeTable) {
            encodeMap.put(cti.getKey(), cti.getValue());
            decodeMap.put(cti.getValue(), cti.getKey());
        }
    }

    /**
     * Encode text to MorseCode
     * @param openText
     * @return
     */
    public String encode(String openText) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < openText.length(); i++) {
            String s = Character.toString(openText.charAt(i));
            // space on begin/end cannost be - text is trimmed before calling
            if (s.equals(" ")) {
                result.append(Constants.WORD_DELIMITER);
            } else {
                if (encodeMap.get(s) != null) {
                    result.append(encodeMap.get(s));
                    // to avoid add delimiter after last
                    if (i < openText.length() - 1) {
                        result.append(Constants.DELIMITER);
                    }

                } else {
                    result.append(Constants.UNDEFINED);
                    // to avoid add delimiter after last
                    if (i < openText.length() - 1) {
                        result.append(Constants.DELIMITER);
                    }
                }
            }
        }

        return result.toString();
    }


    /**
     * Decode from MorseCode to open text
     * @param encodeText
     * @return
     */
    public String decode(String encodeText) {
        StringBuilder result = new StringBuilder();
        // split to morse codes
        String[] splitText = encodeText.split(Pattern.quote(Constants.DELIMITER));
        for (String s : splitText) {
            // get to map without posiible word delimiter
            if (decodeMap.get(s.replace(Constants.WORD_DELIMITER, "")) != null) {
                if (s.startsWith(Constants.WORD_DELIMITER)) {
                    result.append(" ");
                }
                result.append(decodeMap.get(s.replace(Constants.WORD_DELIMITER, "")));
            } else {
                if (s.startsWith(Constants.WORD_DELIMITER)) {
                    result.append(" ");
                }
                // in case of text is only word delimiter
                if (!s.equals(Constants.WORD_DELIMITER)) {
                    result.append(Constants.UNDEFINED);
                }

            }
        }


        return result.toString();
    }
}
