package p2081;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2081ATests extends AbstractOjTests {
    public CF2081ATests() {
        super("/p2081/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2081A.main(null);
        super.doAssertion(OUTPUT1);
    }
}