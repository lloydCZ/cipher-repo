package cz.spring.cipher.test;


import com.google.gson.Gson;
import cz.spring.cipher.AppMain;
import cz.spring.cipher.caesar.CaesarForm;
import cz.spring.cipher.morse.MorseForm;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppMain.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppMainIT {

    @LocalServerPort
    private int port;
    // uri for caesar cipher
    private final String caesarURI = "/cipher/caesar";
    // uri for morse code cipher
    private final String morseURI = "/cipher/morse";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCaesarNormal() throws URISyntaxException {
        URI uri = new URI(createURLWithPort(caesarURI));

        HttpHeaders headers = new HttpHeaders();
        Gson gson = new Gson();
        CaesarForm form1 = gson.fromJson(TestCaseJson.caesarTestNormal, CaesarForm.class);

        HttpEntity<CaesarForm> request = new HttpEntity<CaesarForm>(form1, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        System.out.println(result.getBody());
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    public void testCaesarMaximum() throws URISyntaxException {
        URI uri = new URI(createURLWithPort(caesarURI));

        HttpHeaders headers = new HttpHeaders();
        Gson gson = new Gson();
        CaesarForm form1 = gson.fromJson(TestCaseJson.caesarTestMaximum, CaesarForm.class);

        HttpEntity<CaesarForm> request = new HttpEntity<CaesarForm>(form1, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        System.out.println(result.getBody());
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    public void testCaesarWrongText() throws URISyntaxException {
        URI uri = new URI(createURLWithPort(caesarURI));

        HttpHeaders headers = new HttpHeaders();
        Gson gson = new Gson();
        CaesarForm form1 = gson.fromJson(TestCaseJson.caesarTestWrongText, CaesarForm.class);

        HttpEntity<CaesarForm> request = new HttpEntity<CaesarForm>(form1, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        System.out.println(result.getBody());
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    public void testCaesarWrongOffset() throws URISyntaxException {
        URI uri = new URI(createURLWithPort(caesarURI));

        HttpHeaders headers = new HttpHeaders();
        Gson gson = new Gson();
        CaesarForm form1 = gson.fromJson(TestCaseJson.caesarTestWrongOffset, CaesarForm.class);

        HttpEntity<CaesarForm> request = new HttpEntity<CaesarForm>(form1, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        System.out.println(result.getBody());
        //Verify request succeed
        Assert.assertEquals(400, result.getStatusCodeValue());
    }

    @Test
    public void testMorseEncode() throws URISyntaxException {
        URI uri = new URI(createURLWithPort(morseURI));

        HttpHeaders headers = new HttpHeaders();
        Gson gson = new Gson();
        MorseForm form = gson.fromJson(TestCaseJson.morseTestEncode, MorseForm.class);

        HttpEntity<MorseForm> request = new HttpEntity<MorseForm>(form, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        System.out.println(result.getBody());
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    public void testMorseDecode() throws URISyntaxException {
        URI uri = new URI(createURLWithPort(morseURI));

        HttpHeaders headers = new HttpHeaders();
        Gson gson = new Gson();
        MorseForm form = gson.fromJson(TestCaseJson.morseTestDecode, MorseForm.class);

        HttpEntity<MorseForm> request = new HttpEntity<MorseForm>(form, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        System.out.println(result.getBody());
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    public void testMorseWrongAction() throws URISyntaxException {
        URI uri = new URI(createURLWithPort(morseURI));

        HttpHeaders headers = new HttpHeaders();
        Gson gson = new Gson();
        MorseForm form = gson.fromJson(TestCaseJson.morseTestWrongInput, MorseForm.class);

        HttpEntity<MorseForm> request = new HttpEntity<MorseForm>(form, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        System.out.println(result.getBody());
        //Verify request succeed
        Assert.assertEquals(400, result.getStatusCodeValue());
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
