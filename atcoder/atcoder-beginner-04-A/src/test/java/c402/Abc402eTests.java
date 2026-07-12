package c402;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Disabled("浮点数")
public class Abc402eTests extends AbstractOjTests {
    public Abc402eTests() {
        super("/c402/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc402_e.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc402_e.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Abc402_e.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        Abc402_e.main(null);
        super.doAssertion(OUTPUT4);
    }
}
