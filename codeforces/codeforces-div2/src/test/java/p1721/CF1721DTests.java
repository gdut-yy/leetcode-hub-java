package p1721;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1721DTests extends AbstractOjTests {
    public CF1721DTests() {
        super("/p1721/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1721D.main(null);
        super.doAssertion();
    }
}