package p1760;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1760GTests extends AbstractOjTests {
    public CF1760GTests() {
        super("/p1760/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1760G.main(null);
        super.doAssertion();
    }
}
