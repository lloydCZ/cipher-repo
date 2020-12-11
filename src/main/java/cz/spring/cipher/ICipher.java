package cz.spring.cipher;

public interface ICipher {

    /**
     * Decoding encoded text
     * @param encodeText
     * @return
     */
    public String decode(String encodeText);

    /**
     * Encoding cipher text
     * @param openText
     * @return
     */
    public String encode(String openText);

}
