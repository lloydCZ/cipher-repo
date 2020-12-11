package cz.spring.cipher;

import lombok.Data;

@Data
public class CipherResult {

    private String resultDecrypted;
    // encrypted text
    private String resultEncrypted;
    // possible error
    private String errorMsg;

}
