package c348;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class Abc348eTests extends AbstractOjTests {
    public Abc348eTests() {
        super("/c348/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc348_e.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc348_e.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Abc348_e.main(null);
        super.doAssertion(OUTPUT3);
    }
}
