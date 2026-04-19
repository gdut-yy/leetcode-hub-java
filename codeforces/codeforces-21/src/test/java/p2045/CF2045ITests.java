package p2045;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2045ITests extends AbstractOjTests {
    public CF2045ITests() {
        super("/p2045/I/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2045I.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF2045I.main(null);
        super.doAssertion(OUTPUT2);
    }
}