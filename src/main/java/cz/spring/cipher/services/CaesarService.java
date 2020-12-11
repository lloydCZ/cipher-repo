package cz.spring.cipher.services;

import cz.spring.cipher.CipherResult;
import cz.spring.cipher.caesar.CaesarCipher;
import cz.spring.cipher.caesar.CaesarForm;
import org.springframework.stereotype.Service;

@Service
public class CaesarService {


    /**
     * decdde / encode with input validation
     * error msg to Result object
     * @param caesarForm
     * @return
     */
    public CipherResult handleCipher(CaesarForm caesarForm) {
        // result object
        CipherResult result = new CipherResult();
        // computing class
        CaesarCipher caesar = new CaesarCipher(caesarForm.getOffset());
        // encoding
        String encryptedText = caesar.encode(caesarForm.getText());
        // decoding
        String decryptedText = caesar.decode(caesarForm.getText());
        // in case of text not between A - Z
        if (encryptedText == null || decryptedText == null) {
            result.setErrorMsg("Incorrect input text - must be upper case ENGLISH aplhabet (A - Z) without space");
        } else {
            result.setResultEncrypted(encryptedText);
            result.setResultDecrypted(decryptedText);
        }

        return result;
    }


}
