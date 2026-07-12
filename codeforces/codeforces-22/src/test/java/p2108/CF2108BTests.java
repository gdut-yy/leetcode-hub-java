package p2108;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF2108BTests extends AbstractOjTests {
    public CF2108BTests() {
        super("/p2108/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2108B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
