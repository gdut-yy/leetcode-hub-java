package p1270;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1270GTests extends AbstractOjTests {
    public CF1270GTests() {
        super("/p1270/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1270G.main(null);
        super.doAssertion(OUTPUT1);
    }
}