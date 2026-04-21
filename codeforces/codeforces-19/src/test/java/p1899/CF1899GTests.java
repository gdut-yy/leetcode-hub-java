package p1899;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1899GTests extends AbstractOjTests {
    public CF1899GTests() {
        super("/p1899/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1899G.main(null);
        super.doAssertion(OUTPUT1);
    }
}