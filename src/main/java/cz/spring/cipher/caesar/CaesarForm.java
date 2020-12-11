package cz.spring.cipher.caesar;

import cz.spring.cipher.util.Constants;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class CaesarForm {
    @NotNull(message = "Variable \"Text\" cannot be null")
    private String text;    // text to encrypt / decrypt

    @NotNull(message = "Variable \"offset\" cannot be null")
    @Min(value = 1, message = "Value of \"offset\" must be between 1 and " + Constants.EN_ALPHABET_SIZE)
    @Max(value = Constants.EN_ALPHABET_SIZE, message = "Value of \"offset\" must be between 1 and " + Constants.EN_ALPHABET_SIZE)
    private Integer offset; // offset - key to caesar cipher

}
