package p1862;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1862DTests extends AbstractOjTests {
    public CF1862DTests() {
        super("/p1862/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1862D.main(null);
        super.doAssertion();
    }
}