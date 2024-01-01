package base;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public abstract class AbstractOjTests {
    protected static final String INPUT1 = "input1.txt";
    protected static final String OUTPUT1 = "output1.txt";
    protected static final String INPUT2 = "input2.txt";
    protected static final String OUTPUT2 = "output2.txt";
    protected static final String INPUT3 = "input3.txt";
    protected static final String OUTPUT3 = "output3.txt";
    protected static final String INPUT4 = "input4.txt";
    protected static final String OUTPUT4 = "output4.txt";
    protected static final String INPUT5 = "input5.txt";
    protected static final String OUTPUT5 = "output5.txt";
    protected static final String INPUT6 = "input6.txt";
    protected static final String OUTPUT6 = "output6.txt";
    protected static final String INPUT7 = "input7.txt";
    protected static final String OUTPUT7 = "output7.txt";
    protected static final String INPUT8 = "input8.txt";
    protected static final String OUTPUT8 = "output8.txt";
    protected static final String INPUT9 = "input9.txt";
    protected static final String OUTPUT9 = "output9.txt";
    protected static final String INPUT10 = "input10.txt";
    protected static final String OUTPUT10 = "output10.txt";
    protected static final String INPUT11 = "input11.txt";
    protected static final String OUTPUT11 = "output11.txt";
    protected static final String INPUT12 = "input12.txt";
    protected static final String OUTPUT12 = "output12.txt";
    protected static final String INPUT13 = "input13.txt";
    protected static final String OUTPUT13 = "output13.txt";
    protected static final String INPUT14 = "input14.txt";
    protected static final String OUTPUT14 = "output14.txt";
    protected static final String INPUT15 = "input15.txt";
    protected static final String OUTPUT15 = "output15.txt";
    protected static final String INPUT16 = "input16.txt";
    protected static final String OUTPUT16 = "output16.txt";
    protected static final String INPUT17 = "input17.txt";
    protected static final String OUTPUT17 = "output17.txt";
    protected static final String INPUT18 = "input18.txt";
    protected static final String OUTPUT18 = "output18.txt";
    protected static final String INPUT19 = "input19.txt";
    protected static final String OUTPUT19 = "output19.txt";
    protected static final String INPUT20 = "input20.txt";
    protected static final String OUTPUT20 = "output20.txt";
    private static final String DEFAULT_INPUT = INPUT1;
    private static final String DEFAULT_OUTPUT = OUTPUT1;

    private final String path;
    private final ByteArrayOutputStream byteArrayOutputStream;

    public AbstractOjTests(String path) {
        URL url = getClass().getResource(path);
        Assertions.assertNotNull(url);
        this.path = url.getPath();
        this.byteArrayOutputStream = new ByteArrayOutputStream();
    }

    protected void doSetSystemInOut() throws IOException {
        this.doSetSystemInOut(DEFAULT_INPUT);
    }

    protected void doSetSystemInOut(String inputName) throws IOException {
        File inputFile = new File(path + inputName);
        FileInputStream inputStream = new FileInputStream(inputFile);
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setIn(inputStream);
        System.setOut(printStream);
    }

    protected void doAssertion() throws IOException {
        this.doAssertion(DEFAULT_OUTPUT);
    }

    protected void doAssertion(String outputName) throws IOException {
        File outputFile = new File(path + outputName);
        String expected = FileUtils.readFileToString(outputFile, StandardCharsets.UTF_8.name());
        String actual = byteArrayOutputStream.toString();
        Assertions.assertEquals(expected.trim(), actual.trim());
    }
}