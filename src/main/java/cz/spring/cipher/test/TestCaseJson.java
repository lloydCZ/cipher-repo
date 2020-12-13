package cz.spring.cipher.test;


public class TestCaseJson {

    // CAESAR CIPHER
    // normal case - offset to 3 chars
    public static final String caesarTestNormal =
            "{\"text\":\"OFFSETTHREE\"," +
            "\"offset\": 3}";

    // max case - offset to 26 chars - size of alphabet
    // whatever is on input - encode or decodce have to be the same result as input
    public static final String caesarTestMaximum =
            "{\"text\":\"MAXIMUMOFFSET\"," +
            "\"offset\": 26}";

    // wrong text
    public static final String caesarTestWrongText =
            "{\"text\":\"wrong text to encode / decode\"," +
            "\"offset\": 1}";

    // wrong offset
    public static final String caesarTestWrongOffset =
            "{\"text\":\"WRONGOFFSET\"," +
            "\"offset\": 100}";

    // MORSE CODE
    // encode case
    public static final String morseTestEncode =
            "{\"text\":\"MORSE CODE ENCODE\"," +
            "\"action\": 0}";

    // decode case
    public static final String morseTestDecode =
            "{\"text\":\"--|---|.-.|...|.|#-.-.|---|-..|.|#.|-.|-.-.|---|-..|.\"," +
                    "\"action\": 1}";

    // wrong input - bad action
    public static final String morseTestWrongInput =
            "{\"text\":\"MORSE CODE ENCODE\"," +
                    "\"action\": 2}";

}
