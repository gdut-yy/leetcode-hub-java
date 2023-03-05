package p1800;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1800DTests extends AbstractOjTests {
    public CF1800DTests() {
        super("/p1800/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1800D.main(null);
        super.doAssertion();
    }
}
