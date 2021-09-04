import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public abstract class AbstractOjTests {
    private static final String DEFAULT_INPUT = "input.txt";
    private static final String DEFAULT_OUTPUT = "output.txt";
    protected static final String INPUT2 = "input2.txt";
    protected static final String OUTPUT2 = "output2.txt";

    private final String path;
    private File outputFile;
    private File actualFile;

    public AbstractOjTests(String path) {
        this.path = getClass().getResource(path).getPath();
    }

    protected void doSetInOut() throws IOException {
        doSetInOut(DEFAULT_INPUT, DEFAULT_OUTPUT);
    }

    protected void doSetInOut(String input, String output) throws IOException {
        File inputFile = new File(path + "/" + input);
        outputFile = new File(path + "/" + output);
        FileInputStream inputStream = new FileInputStream(inputFile);
        System.setIn(inputStream);
        actualFile = new File(getClass().getResource("actual.txt").getPath());
        PrintStream printStream = new PrintStream(actualFile);
        System.setOut(printStream);
    }

    protected void doAssertion() throws IOException {
        String actual = FileUtils.readFileToString(actualFile, StandardCharsets.UTF_8.name());
        String expected = FileUtils.readFileToString(outputFile, StandardCharsets.UTF_8.name());
        Assertions.assertEquals(expected, actual);
    }
}
