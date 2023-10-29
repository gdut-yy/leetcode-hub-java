package p1867;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1867DTests extends AbstractOjTests {
    public CF1867DTests() {
        super("/p1867/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1867D.main(null);
        super.doAssertion();
    }
}