package p1513;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1513BTests extends AbstractOjTests {
    public CF1513BTests() {
        super("/p1513/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1513B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
