package p1898;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1898DTests extends AbstractOjTests {
    public CF1898DTests() {
        super("/p1898/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1898D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
