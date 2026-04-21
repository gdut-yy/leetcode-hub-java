package p2044;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2044ETests extends AbstractOjTests {
    public CF2044ETests() {
        super("/p2044/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2044E.main(null);
        super.doAssertion(OUTPUT1);
    }
}