package cz.spring.cipher.morse;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class MorseForm {
    @NotNull(message = "Variable \"Text\" cannot be null")
    private String text;    // text to encrypt / decrypt

    @NotNull(message = "Variable \"action\" cannot be null")
    @Min(value = 0, message = "Value of \"action\" must be between 0 (encode) and 1 (decode)")
    @Max(value = 1, message = "Value of \"action\" must be between 0 (encode) and 1 (decode)")
    private Integer action; // 0 (encode) and 1 (decode)
}
