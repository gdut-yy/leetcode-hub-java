package p1667;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1667BTests extends AbstractOjTests {
    public CF1667BTests() {
        super("/p1667/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1667B.main(null);
        super.doAssertion(OUTPUT1);
    }
}