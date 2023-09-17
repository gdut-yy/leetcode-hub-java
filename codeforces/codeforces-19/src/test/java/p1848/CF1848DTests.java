package p1848;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1848DTests extends AbstractOjTests {
    public CF1848DTests() {
        super("/p1848/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1848D.main(null);
        super.doAssertion();
    }
}