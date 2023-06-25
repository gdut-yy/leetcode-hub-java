package p1839;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1839DTests extends AbstractOjTests {
    public CF1839DTests() {
        super("/p1839/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1839D.main(null);
        super.doAssertion();
    }
}