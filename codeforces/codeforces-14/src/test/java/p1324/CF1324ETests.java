package p1324;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1324ETests extends AbstractOjTests {
    public CF1324ETests() {
        super("/p1324/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1324E.main(null);
        super.doAssertion();
    }
}