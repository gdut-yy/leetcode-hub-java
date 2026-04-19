package p1547;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1547GTests extends AbstractOjTests {
    public CF1547GTests() {
        super("/p1547/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1547G.main(null);
        super.doAssertion(OUTPUT1);
    }
}