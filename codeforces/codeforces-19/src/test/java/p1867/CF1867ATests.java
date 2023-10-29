package p1867;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1867ATests extends AbstractOjTests {
    public CF1867ATests() {
        super("/p1867/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1867A.main(null);
        super.doAssertion();
    }
}