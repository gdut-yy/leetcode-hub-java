package p2019;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2019BTests extends AbstractOjTests {
    public CF2019BTests() {
        super("/p2019/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2019B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
