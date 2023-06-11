package p1444;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1444ATests extends AbstractOjTests {
    public CF1444ATests() {
        super("/p1444/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1444A.main(null);
        super.doAssertion();
    }
}