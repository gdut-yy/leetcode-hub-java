package p1932;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1932ATests extends AbstractOjTests {
    public CF1932ATests() {
        super("/p1932/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1932A.main(null);
        super.doAssertion(OUTPUT1);
    }
}