package cz.spring.cipher.services;

import cz.spring.cipher.CipherResult;
import cz.spring.cipher.model.CodeTableItem;
import cz.spring.cipher.morse.MorseCodeCipher;
import cz.spring.cipher.morse.MorseForm;
import cz.spring.cipher.repository.CipherRepository;
import cz.spring.cipher.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MorseCodeService {

    @Autowired
    CipherRepository cipherRepository;

    /**
     * decdde / encode with input validation
     * error msg to Result object
     * @param morseForm
     * @return
     */
    public CipherResult handleCipher(MorseForm morseForm) {
        CipherResult result = new CipherResult();
        String validateResult = validateInput(morseForm);
        if (!validateResult.equals(Constants.VALIDATE_SUCCESS)) {
            result.setErrorMsg(validateResult);
            return result;
        } else {
            MorseCodeCipher morseCodeCipher = new MorseCodeCipher();
            if (morseForm.getAction() == 0) {
                result.setResultEncrypted(morseCodeCipher.encode(morseForm.getText().trim()));
            } else {
                result.setResultDecrypted(morseCodeCipher.decode(morseForm.getText().trim()));
            }
            return result;
        }

    }

    /**
     * Validate correct input text. Return into result msg if some problem occured
     * @param morseForm
     * @return
     */
    private String validateInput(MorseForm morseForm) {
        String result = Constants.VALIDATE_SUCCESS;
        // encode - text must be A-Z
        if (morseForm.getAction() == 0) {
            for(int i = 0; i < morseForm.getText().length(); i++) {
                char c = morseForm.getText().charAt(i);
                if ((c < 65 || c > 90) && c != ' ') {
                    return "Text to encrypt must be A-Z";
                }
            }
        }

        // decode - text must be .- or space
        if (morseForm.getAction() == 1) {
            for(int i = 0; i < morseForm.getText().length(); i++) {
                char c = morseForm.getText().charAt(i);
                if (c != '.' && c != '-' && c != Constants.DELIMITER.charAt(0) && c != Constants.WORD_DELIMITER.charAt(0)) {
                    return "Text to decrypt must be .- or " + Constants.DELIMITER + "(delimiter) or "+ Constants.WORD_DELIMITER +"(word delimiter)";
                }
            }
        }

        return result;
    }


    /**
     * Code table from DB into object
     * Preparing for storing code table to DB
     * @return
     */
    public List<CodeTableItem> findAll() {
        return (List<CodeTableItem>) cipherRepository.findAll();
    }

}
