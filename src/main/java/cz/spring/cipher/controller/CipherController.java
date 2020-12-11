package cz.spring.cipher.controller;

import cz.spring.cipher.CipherResult;
import cz.spring.cipher.caesar.CaesarForm;
import cz.spring.cipher.morse.MorseForm;
import cz.spring.cipher.services.CaesarService;
import cz.spring.cipher.services.MorseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CipherController {

    @Autowired
    private CaesarService caesarService;

    @Autowired
    private MorseCodeService morseCodeService;

    @PostMapping("/cipher/caesar")
    public CipherResult postCaesar(@RequestBody @Valid CaesarForm caesarForm) {
        return caesarService.handleCipher(caesarForm);
    }

    @PostMapping("/cipher/morse")
    public CipherResult postMorse(@RequestBody @Valid MorseForm morseForm) {
        return morseCodeService.handleCipher(morseForm);
    }

}
