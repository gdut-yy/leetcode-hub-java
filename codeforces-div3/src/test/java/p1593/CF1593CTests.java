package p1593;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1593CTests extends AbstractOjTests {
    public CF1593CTests() {
        super("/p1593/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1593C.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1593C.main(null);
        super.doAssertion(OUTPUT2);
    }

    // test DeflateMain.java
    @Test
    @Disabled
    public void testDeflateMain() throws IOException {
        super.doSetSystemInOut("RabinKarp-input.txt");
        RabinKarp.main(null);
        super.doAssertion("RabinKarp-output.txt");
    }
}
