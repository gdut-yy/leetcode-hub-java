package p1607;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1607DTests extends AbstractOjTests {
    public CF1607DTests() {
        super("/p1607/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1607D.main(null);
        super.doAssertion(OUTPUT1);
    }
}