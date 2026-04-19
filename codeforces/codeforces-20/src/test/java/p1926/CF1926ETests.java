package p1926;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1926ETests extends AbstractOjTests {
    public CF1926ETests() {
        super("/p1926/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1926E.main(null);
        super.doAssertion(OUTPUT1);
    }
}
