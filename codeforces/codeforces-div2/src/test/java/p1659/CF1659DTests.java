package p1659;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1659DTests extends AbstractOjTests {
    public CF1659DTests() {
        super("/p1659/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1659D.main(null);
        super.doAssertion();
    }
}