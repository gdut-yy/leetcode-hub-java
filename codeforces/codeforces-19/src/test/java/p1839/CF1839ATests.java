package p1839;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1839ATests extends AbstractOjTests {
    public CF1839ATests() {
        super("/p1839/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1839A.main(null);
        super.doAssertion();
    }
}