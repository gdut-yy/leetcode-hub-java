package p1714;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1714ETests extends AbstractOjTests {
    public CF1714ETests() {
        super("/p1714/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1714E.main(null);
        super.doAssertion();
    }
}
