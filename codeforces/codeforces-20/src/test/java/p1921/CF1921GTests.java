package p1921;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1921GTests extends AbstractOjTests {
    public CF1921GTests() {
        super("/p1921/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1921G.main(null);
        super.doAssertion(OUTPUT1);
    }
}
