package p1974;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1974GTests extends AbstractOjTests {
    public CF1974GTests() {
        super("/p1974/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1974G.main(null);
        super.doAssertion(OUTPUT1);
    }
}