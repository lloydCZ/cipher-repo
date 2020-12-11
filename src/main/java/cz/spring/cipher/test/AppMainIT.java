package cz.spring.cipher.test;


import com.google.gson.Gson;
import cz.spring.cipher.AppMain;
import cz.spring.cipher.caesar.CaesarForm;
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

    private final String caesarURI = "/cipher/caesar";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCaesar() throws URISyntaxException {
        URI uri = new URI(createURLWithPort(caesarURI));

        HttpHeaders headers = new HttpHeaders();
        //headers.set("X-COM-PERSIST", "true");
        Gson gson = new Gson();
        CaesarForm form1 = gson.fromJson(TestCaseJson.getCaesarTest1(), CaesarForm.class);


        HttpEntity<CaesarForm> request = new HttpEntity<CaesarForm>(form1, headers);
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        System.out.println("JSEM V TESTU 2: " + result);
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
