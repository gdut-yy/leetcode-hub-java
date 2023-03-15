package p1692;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1692GTests extends AbstractOjTests {
    public CF1692GTests() {
        super("/p1692/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1692G.main(null);
        super.doAssertion();
    }
}
