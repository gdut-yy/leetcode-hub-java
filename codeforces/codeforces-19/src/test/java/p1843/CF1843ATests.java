package p1843;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1843ATests extends AbstractOjTests {
    public CF1843ATests() {
        super("/p1843/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1843A.main(null);
        super.doAssertion();
    }
}