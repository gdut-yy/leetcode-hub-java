package base;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AbstractOjTests {
    private static final String DEFAULT_INPUT = "input.txt";
    private static final String DEFAULT_OUTPUT = "output.txt";
    protected static final String INPUT2 = "input2.txt";
    protected static final String OUTPUT2 = "output2.txt";

    private final String path;
    private final File actualFile;

    public AbstractOjTests(String path) {
        URL url = getClass().getResource(path);
        URL actualUrl = getClass().getResource("/actual.txt");
        Assertions.assertNotNull(url);
        Assertions.assertNotNull(actualUrl);
        this.path = url.getPath();
        this.actualFile = new File(actualUrl.getPath());
    }

    protected void doSetSystemInOut() throws IOException {
        this.doSetSystemInOut(DEFAULT_INPUT);
    }

    protected void doSetSystemInOut(String inputName) throws IOException {
        File inputFile = new File(path + inputName);
        FileInputStream inputStream = new FileInputStream(inputFile);
        PrintStream printStream = new PrintStream(actualFile);
        System.setIn(inputStream);
        System.setOut(printStream);
    }

    protected void doAssertion() throws IOException {
        this.doAssertion(DEFAULT_OUTPUT);
    }

    protected void doAssertion(String outputName) throws IOException {
        File outputFile = new File(path + outputName);
        String expected = FileUtils.readFileToString(outputFile, StandardCharsets.UTF_8.name());
        String actual = FileUtils.readFileToString(actualFile, StandardCharsets.UTF_8.name());
        Assertions.assertEquals(expected.trim(), actual.trim());
    }
}
